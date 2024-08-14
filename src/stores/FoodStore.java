package stores;

import enums.Food;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FoodStore implements Cloneable{

    private final Map<Food, Integer> foodInventory;

    public FoodStore() {
        this.foodInventory = new HashMap<>();
        for (Food food : Food.values()) {
            foodInventory.put(food, 0);
        }
    }

    public void addFood(String foodName, int quantity) {
        Optional<Food> food = getFoodByName(foodName);
        if (food.isPresent() && quantity > 0) {
            foodInventory.put(food.get(), foodInventory.get(food.get()) + quantity);
        } else {
            throw new IllegalArgumentException("Invalid food name or quantity");
        }
    }


    public boolean takeFood(String foodName, int quantity) {
        Optional<Food> food = getFoodByName(foodName);
        if (food.isPresent() && quantity > 0) {
            int currentQuantity = foodInventory.get(food.get());
            if (currentQuantity >= quantity) {
                foodInventory.put(food.get(), currentQuantity - quantity);
            } else {
                throw new IllegalArgumentException("Not enough " + foodName + " in food store to take!");
            }
        } else {
            throw new IllegalArgumentException("Invalid food name or quantity");
        }
        return true;
    }

    public boolean takeFood(String foodName) {
        return takeFood(foodName, 1);
    }


    public void displayInventory() {
        for (Map.Entry<Food, Integer> entry : foodInventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " items");
        }
    }

    private Optional<Food> getFoodByName(String foodName) {
        return Optional.of(Food.valueOf(foodName.toUpperCase().replace(" ", "_")));
    }

    public Map<Food, Integer> getFoodInventory() {
        return foodInventory;
    }

    @Override
    public FoodStore clone() {
        try {
            return (FoodStore) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
