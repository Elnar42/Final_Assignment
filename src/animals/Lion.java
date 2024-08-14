package animals;

import enums.Gender;

public class Lion extends BigCat {

    public Lion(int age, Gender gender) {
        super("Lion", age, gender);
        setLifeExpectancy(24);
    }

    public Lion(int age, Gender gender, int health, int lifeExpectancy) {
        super("Lion", age, gender);
        setLifeExpectancy(lifeExpectancy);
        setHealth(health);
    }


    @Override
    public void treat() {
        stroke();
    }


    @Override
    public void stroke() {
        setHealth(getHealth() + 2);
    }
}
