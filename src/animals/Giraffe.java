package animals;

import enums.Food;
import enums.Gender;
import treats.Massageable;

import java.util.Set;

public class Giraffe extends Animal implements Massageable {
    public Giraffe(int age, Gender gender) {
        super("Giraffe", age, gender);
        setLifeExpectancy(28);
        setEats(Set.of(Food.HAY, Food.FRUIT));
    }

    public Giraffe(int age, Gender gender, int health, int lifeExpectancy) {
        super("Giraffe", age, gender);
        setLifeExpectancy(lifeExpectancy);
        setHealth(health);
    }


    @Override
    public void treat() {
        neckMassage();
    }


    @Override
    public void neckMassage() {
        setHealth(getHealth() + 4);
    }
}
