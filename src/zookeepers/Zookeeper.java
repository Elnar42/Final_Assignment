package zookeepers;

import animals.Animal;
import boundaries.Enclosure;
import enums.Food;
import stores.FoodStore;
import treats.Hugable;
import treats.Strokeable;

public class Zookeeper {
    private Enclosure enclosure; // Enclosure
    private FoodStore zooFoodStore; // General FoodStore


    public Zookeeper(Enclosure enclosure, FoodStore foodStore) {
        this.enclosure = enclosure;
        this.zooFoodStore = foodStore;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public void aMonthPasses() {
        moveFood();
        enclosure.removeWaste(20);
        giveATreat();
    }

    public void moveFood() {
        FoodStore enclosureFoodStore = enclosure.getFoodStore();
        int itemsMoved = 0;
        for (Food food : zooFoodStore.getFoodInventory().keySet()) {
            if (itemsMoved >= 20) break;
            int quantityToMove = Math.min(20 - itemsMoved, zooFoodStore.getFoodInventory().get(food));
            if (quantityToMove > 0) {
                enclosureFoodStore.addFood(food.name(), quantityToMove);
                zooFoodStore.takeFood(food.name(), quantityToMove);
                itemsMoved += quantityToMove;
            }
        }
    }


    public void giveATreat() {
        int numberOfTreats = 0;
        for (Animal animal : enclosure.getAnimals()) {
            if (numberOfTreats >= 2) break;
            if (animal.getHealth() > 0) {

                if (animal instanceof Strokeable) {
                    ((Strokeable) animal).stroke();
                }
                if (animal instanceof Hugable) {
                    ((Hugable) animal).hug();

                }
                numberOfTreats++;
            }
        }
    }


}
