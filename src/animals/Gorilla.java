package animals;

import enums.Gender;
import treats.Paintable;

public class Gorilla extends Ape implements Paintable {

    public Gorilla(int age, Gender gender) {
        super("Gorilla", age, gender);
        setLifeExpectancy(32);
    }

    public Gorilla(int age, Gender gender, int health, int lifeExpectancy) {
        super("Gorilla", age, gender);
        setLifeExpectancy(lifeExpectancy);
        setHealth(health);
    }

    @Override
    public void treat() {
        painting();
    }


    @Override
    public void painting() {
        setHealth(getHealth() + 4);
    }
}
