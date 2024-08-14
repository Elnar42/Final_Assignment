package animals;

import enums.Food;
import enums.Gender;
import treats.Watchable;

import java.util.Set;

public class Penguin extends Animal implements Watchable {
    public Penguin(int age, Gender gender) {
        super("Penguin", age, gender);
        setLifeExpectancy(15);
        setEats(Set.of(Food.FISH, Food.ICE_CREAM));
    }

    public Penguin(int age, Gender gender, int health, int lifeExpectancy) {
        super("Penguin", age, gender);
        setLifeExpectancy(lifeExpectancy);
        setHealth(health);
    }

    @Override
    public void treat() {
        watchAFilm();
    }


    @Override
    public void watchAFilm() {
        setHealth(getHealth() + 2);
    }
}
