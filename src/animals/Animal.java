package animals;

import boundaries.Enclosure;
import enums.Food;
import enums.Gender;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Animal {
    private String name;
    private int age;
    private Gender gender;
    private Set<Food> eats;
    private int health;
    private int lifeExpectancy;
    private Enclosure enclosure;

    public Animal(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.enclosure = null; // Initially animal has not enclosure
        eats = new HashSet<>();
        health = 0;
        lifeExpectancy = 10;
    }


    public boolean canEat(Food food) {
        return eats.contains(food) && enclosure.getFoodStore().takeFood(food.name());
    }

    public void eat(Food food) {
        if (canEat(food)) {
            setHealth(Math.min(getHealth() + food.getHealth(), 10));
            enclosure.setWaste(enclosure.getWasteSize() + food.getWaste());
        } else {
            throw new IllegalArgumentException("Can't eat food " + food);
        }
    }

    public void decreaseHealth() {
        setHealth(getHealth() - 2);
    }

    public abstract void treat();


    //More reasonable to implement it in Animal class
    public boolean aMonthPasses() {
        decreaseHealth();
        Food foodToEat = null;
        for (Food food : eats) {
            if (enclosure.getFoodStore().getFoodInventory().get(food) > 0) {
                foodToEat = food;
                break;
            }
        }
        if (foodToEat != null) {
            eat(foodToEat); // The method will automatically add waste
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be a positive integer");
        }
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender must be a one [" + Arrays.toString(Gender.values()) + "]");
        }
        this.gender = gender;
    }

    public Set<Food> getEats() {
        return eats;
    }

    public void setEats(Set<Food> eats) {
        if (eats == null) {
            throw new IllegalArgumentException("Eats cannot be null");
        }
        this.eats = eats;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
            return;
        }
        if (health > 10) {
            this.health = 10;
            return;
        }
        this.health = health;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", eats=" + eats +
                ", health=" + health +
                ", lifeExpectancy=" + lifeExpectancy +
                '}';
    }
}

