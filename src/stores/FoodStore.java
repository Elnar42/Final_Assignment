package stores;

import enums.Food;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FoodStore {

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
            System.out.println("Invalid food name or quantity.");
        }
    }


    public void takeFood(String foodName, int quantity) {
        Optional<Food> food = getFoodByName(foodName);
        if (food.isPresent() && quantity > 0) {
            int currentQuantity = foodInventory.get(food.get());
            if (currentQuantity >= quantity) {
                foodInventory.put(food.get(), currentQuantity - quantity);
            } else {
                System.out.println("Not enough " + foodName + " in the FoodStore.");
            }
        } else {
            System.out.println("Invalid food name or quantity.");
        }
    }

    public void takeFood(String foodName) {
        takeFood(foodName, 1);
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
}
