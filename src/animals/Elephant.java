package animals;

import enums.Food;
import enums.Gender;
import treats.Bathable;

import java.util.Set;

public class Elephant extends Animal implements Bathable {

    public Elephant(int age, Gender gender) {
        super("Elephant", age, gender);
        setLifeExpectancy(36);
        setEats(Set.of(Food.HAY, Food.FRUIT));
    }

    public Elephant(int age, Gender gender, int health, int lifeExpectancy) {
        super("Elephant", age, gender);
        setLifeExpectancy(lifeExpectancy);
        setHealth(health);
    }
    @Override
    public void treat() {
        bath();
    }


    @Override
    public void bath() {
        setHealth(getHealth() + 5);
    }
}
