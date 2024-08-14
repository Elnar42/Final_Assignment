import animals.Animal;
import animals.Bear;
import animals.Giraffe;
import boundaries.Enclosure;
import enums.Food;
import enums.Gender;
import stores.FoodStore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FoodStore store = new FoodStore();
        store.addFood("fish", 5);
        store.addFood("steak", 4);
        store.addFood("fish", 7);

        Bear bear = new Bear(12, Gender.FEMALE);
        Bear bear1 = new Bear(12, Gender.FEMALE);

        Enclosure enclosure1 = new Enclosure(store);
        Enclosure enclosure = new Enclosure(store);

        enclosure.addAnimal(bear);
        enclosure1.addAnimal(bear1);

        bear.eat(Food.FISH);
        bear.eat(Food.FISH);
        bear.eat(Food.FISH);

        bear1.eat(Food.FISH);
        bear1.eat(Food.FISH);

        enclosure.getFoodStore().displayInventory();
        System.out.println("-------------------------------");
        enclosure1.getFoodStore().displayInventory();

        List<Animal> animals = enclosure.getAnimals();
        animals.forEach(System.out::println);

        System.out.println("---------------------------");
        enclosure1.getAnimals().forEach(System.out::println);



    }
}