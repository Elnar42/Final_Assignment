package animals;

import enums.Gender;
import treats.Chaseable;

public class Chimpanzee extends Ape implements Chaseable {
    public Chimpanzee(int age, Gender gender) {
        super("Chimpanzee", age, gender);
        setLifeExpectancy(24);
    }

    public Chimpanzee(int age, Gender gender, int health, int lifeExpectancy) {
        super("Chimpanzee", age, gender);
        setLifeExpectancy(lifeExpectancy);
        setHealth(health);
    }

    @Override
    public void treat() {
        playChase();
    }


    @Override
    public void playChase() {
        setHealth(getHealth() + 4);
    }
}
