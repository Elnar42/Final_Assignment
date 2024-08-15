package animals;

import enums.Food;
import enums.Gender;
import treats.Hugable;

import java.util.Set;

public class Bear extends Animal implements Hugable {
    public Bear(int age, Gender gender) {
        super("Bear", age, gender);
        setLifeExpectancy(18);
        setEats(Set.of(Food.FISH, Food.STEAK));
    }

    public Bear(int age, Gender gender, int health, int lifeExpectancy) {
        super("Bear", age, gender);
        setLifeExpectancy(lifeExpectancy);
        setHealth(health);
        setEats(Set.of(Food.FISH, Food.STEAK));
    }

    @Override
    public void treat() {
        hug();
    }


    @Override
    public void hug() {
        setHealth(getHealth() + 3);
    }
}
