package boundaries;

import animals.Animal;
import stores.FoodStore;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {

    private List<Animal> animals;
    private FoodStore foodStore;
    private final FoodStore refreshFoodStore;
    private int waste;

    public Enclosure(FoodStore foodStore) {
        this.animals = new ArrayList<>(20);
        this.foodStore = foodStore;
        this.refreshFoodStore = foodStore.clone();
        this.waste = 0;
    }

    public void restoreFoodStore(){
        foodStore = refreshFoodStore.clone();
    }

    public void addAnimal(Animal animal) {
        if (animals.contains(animal)) {
            throw new IllegalArgumentException("Animal already exists");
        } else if (animals.isEmpty() || animals.getFirst().getName().equals(animal.getName())) {
            animals.add(animal);
            animal.setEnclosure(this);
        } else {
            throw new IllegalArgumentException("You can not put different type of animals in the same enclosure!");
        }
    }


    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }


    public void removeWaste(int x) {
        if (x <= 0) return;
        if (x > waste) {
            waste = 0;
        } else {
            waste -= x;
        }
    }

    public void addWaste(int x) {
        if (x <= 0) return;
        waste += x;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public FoodStore getFoodStore() {
        return foodStore;
    }

    public void setFoodStore(FoodStore foodStore) {
        this.foodStore = foodStore;
    }

    public int getWasteSize() {
        return waste;
    }

    public void setWaste(int waste) {
        this.waste = waste;
    }

    public int size() {
        return animals.size();
    }

    public void aMonthPasses() {
        animals.forEach(Animal::aMonthPasses);
    }
}
