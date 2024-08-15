import animals.*;
import boundaries.Enclosure;
import enums.Gender;
import stores.FoodStore;
import zookeepers.PhysioZookeeper;
import zookeepers.PlayZookeeper;
import zookeepers.Zookeeper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zoo {
    private Set<Enclosure> enclosures;
    private Set<Zookeeper> zookeepers;
    private FoodStore zooFoodStore;
    private Enclosure currentEnclosure;

    public Zoo() {
        zookeepers = new HashSet<>();
        enclosures = new HashSet<>();
        zooFoodStore = new FoodStore();
        currentEnclosure = null;
    }


    public void loadConfiguration(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                if (line.startsWith("enclosure:")) {
                    createEnclosure(line);
                } else if (line.equals("playZookeeper:") || line.equals("physioZookeeper:") || line.equals("zookeeper:")) {
                    createZookeeper(line);
                } else if (line.contains(":")) {
                    if (line.contains(",")) {
                        createAnimal(line);
                    } else {
                        createFood(line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading configuration file: " + e.getMessage());
        }
    }


    private void createEnclosure(String line) {
        String[] parts = line.split(":");
        if (parts.length == 2) {
            int waste = Integer.parseInt(parts[1].trim());
            Enclosure enclosure = new Enclosure(zooFoodStore);
            enclosure.addWaste(waste);
            enclosures.add(enclosure);
            currentEnclosure = enclosure;
            System.out.println("Created enclosure with waste: " + waste);
        }
    }

    private void createFood(String line) {
        String[] parts = line.split(":");
        if (parts.length == 2) {
            String foodName = parts[0].trim();
            int quantity = Integer.parseInt(parts[1].trim());
            zooFoodStore.addFood(foodName, quantity);
            System.out.println("Added " + quantity + " of " + foodName + " to zoo food store.");
        }
    }

    private void createAnimal(String line) {
        String[] parts = line.split(":");
        if (parts.length == 2) {
            String animalInfo = parts[1].trim();
            String[] animalParts = animalInfo.split(",");
            if (animalParts.length == 4 && currentEnclosure != null) {
                String animalType = parts[0].trim();
                char gender = animalParts[0].charAt(0);
                int age = Integer.parseInt(animalParts[1].trim());
                int health = Integer.parseInt(animalParts[2].trim());
                int lifeExpectancy = Integer.parseInt(animalParts[3].trim());
                Animal animal = createAnimalInstance(animalType, gender, age, health, lifeExpectancy);
                if (animal != null) {
                    if (currentEnclosure == null || !canAddAnimalToCurrentEnclosure(animal)) {
                        currentEnclosure = createNewEnclosure();
                    }
                    boolean b = currentEnclosure.addAnimal(animal);
                    if (b) {
                        System.out.println("Added " + animalType + " to enclosure.");
                    }
                }
            }
        }
    }

    private Animal createAnimalInstance(String type, char gender, int age, int health, int lifeExpectancy) {
        return switch (type.toLowerCase()) {
            case "lion" -> new Lion(age, gender == 'M' ? Gender.MALE : Gender.FEMALE, health, lifeExpectancy);
            case "bear" -> new Bear(age, gender == 'M' ? Gender.MALE : Gender.FEMALE, health, lifeExpectancy);
            case "chimpanzee" ->
                    new Chimpanzee(age, gender == 'M' ? Gender.MALE : Gender.FEMALE, health, lifeExpectancy);
            case "elephant" -> new Elephant(age, gender == 'M' ? Gender.MALE : Gender.FEMALE, health, lifeExpectancy);
            case "giraffe" -> new Giraffe(age, gender == 'M' ? Gender.MALE : Gender.FEMALE, health, lifeExpectancy);
            case "gorilla" -> new Gorilla(age, gender == 'M' ? Gender.MALE : Gender.FEMALE, health, lifeExpectancy);
            case "penguin" -> new Penguin(age, gender == 'M' ? Gender.MALE : Gender.FEMALE, health, lifeExpectancy);
            case "tiger" -> new Tiger(age, gender == 'M' ? Gender.MALE : Gender.FEMALE, health, lifeExpectancy);
            default -> {
                System.err.println("Unknown animal type: " + type);
                yield null;
            }
        };
    }

    private boolean canAddAnimalToCurrentEnclosure(Animal animal) {
        return currentEnclosure.getAnimals().isEmpty() || currentEnclosure.getAnimals().getFirst().getClass().equals(animal.getClass());
    }

    private Enclosure createNewEnclosure() {
        Enclosure newEnclosure = new Enclosure(zooFoodStore);
        enclosures.add(newEnclosure);
        System.out.println("Created new enclosure for different animal type.");
        return newEnclosure;
    }

    private void createZookeeper(String line) {
        Zookeeper zookeeper = null;

        line = line.trim();
        switch (line) {
            case "playZookeeper:" -> zookeeper = new PlayZookeeper(currentEnclosure, zooFoodStore);
            case "physioZookeeper:" -> zookeeper = new PhysioZookeeper(currentEnclosure, zooFoodStore);
            case "zookeeper:" -> zookeeper = new Zookeeper(currentEnclosure, zooFoodStore);
            default -> System.err.println("Unknown zookeeper type: " + line);
        }

        if (zookeeper != null && currentEnclosure != null) {
            zookeeper.setEnclosure(currentEnclosure);
            zookeepers.add(zookeeper);
            System.out.println("Added " + zookeeper.getClass().getSimpleName() + " to the zoo.");
        } else {
            System.err.println("No enclosure available for zookeeper or invalid zookeeper type.");
        }
    }


    public void aMonthPasses() {
        enclosures.forEach(enclosure -> {
            List<Animal> animals = enclosure.getAnimals();
            for (int i = 0; i < animals.size(); i++) {
                Animal animal = animals.get(i);
                animal.increaseAge();
                if (animal.getAge() > animal.getLifeExpectancy()) {
                    System.out.println("Removing " + animal + " due to exceeding life expectancy.");
                    animals.remove(i--); // Remove the animal and adjust index
                }
            }
        });

        enclosures.forEach(Enclosure::aMonthPasses); // 1th requirement
        zookeepers.forEach(Zookeeper::aMonthPasses); // 2nd requirement
        enclosures.forEach(enclosure -> {
            List<Animal> animals = enclosure.getAnimals();
            animals.removeIf(animal -> animal.getHealth() == 0);
        });

        enclosures.forEach(Enclosure::restoreFoodStore); // 4th requirement

        enclosures.forEach(e -> {
            System.out.println("---------------ENCLOSURE ID: " + e.getId() + "-----------------");
            if(e.getAnimals().isEmpty()) System.out.println("EMPTY!!!");
            e.getAnimals().forEach(System.out::println);
        });
    }


    public void go() {
        int month = 1;
        while (true) {
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("Month " + month);
            aMonthPasses();
            if(enclosures.stream().allMatch(enclosure -> enclosure.getAnimals().isEmpty())) {
                System.out.println("NO ANIMAL LEFT IN ZOO!");
                break;
            }
            month++;
        }
    }

    public Set<Enclosure> getEnclosures() {
        return enclosures;
    }

    public void setEnclosures(Set<Enclosure> enclosures) {
        this.enclosures = enclosures;
    }

    public Set<Zookeeper> getZookeepers() {
        return zookeepers;
    }

    public void setZookeepers(Set<Zookeeper> zookeepers) {
        this.zookeepers = zookeepers;
    }

    public FoodStore getZooFoodStore() {
        return zooFoodStore;
    }

    public void setZooFoodStore(FoodStore zooFoodStore) {
        this.zooFoodStore = zooFoodStore;
    }

    public Enclosure getCurrentEnclosure() {
        return currentEnclosure;
    }

    public void setCurrentEnclosure(Enclosure currentEnclosure) {
        this.currentEnclosure = currentEnclosure;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "enclosures=" + enclosures +
                ", zookeepers=" + zookeepers +
                ", zooFoodStore=" + zooFoodStore +
                ", currentEnclosure=" + currentEnclosure +
                '}';
    }
}
