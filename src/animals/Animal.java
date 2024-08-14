package animals;

import enums.Food;
import enums.Gender;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Animal {
    private int age;
    private Gender gender;
    private Set<Food> eats;
    private int health;
    private int lifeExpectancy;

    public Animal(int age, Gender gender) {
        this.age = age;
        this.gender = gender;
        eats = new HashSet<>();
        health = 0;
        lifeExpectancy = 10;
    }

    public boolean canEat(Food food) {
        return eats.contains(food);
    }

    public void eat(Food food) {
        if (canEat(food)) {
            setHealth(Math.min(getHealth() + food.getHealth(), 10));
            // Will add waste as well after eating
        }
    }

    public void decreaseHealth(){
        setHealth(getHealth() - 2);
    }

    public abstract void treat();
    public abstract boolean aMonthPasses();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("Age must be a positive integer");
        }
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if(gender == null) {
            throw new IllegalArgumentException("Gender must be a one [" + Arrays.toString(Gender.values()) + "]");
        }
        this.gender = gender;
    }

    public Set<Food> getEats() {
        return eats;
    }

    public void setEats(Set<Food> eats) {
        if(eats == null) {
            throw new IllegalArgumentException("Eats cannot be null");
        }
        this.eats = eats;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0 || health > 10) {
            throw new IllegalArgumentException("Health must be between 0 and 10");
        }
        this.health = health;
    }

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }
}
