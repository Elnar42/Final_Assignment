package animals;

import enums.Gender;
import treats.Strokeable;

public class Tiger extends BigCat  implements Strokeable {
    public Tiger(int age, Gender gender) {
        super("Tiger", age, gender);
        setLifeExpectancy(24);
    }

    public Tiger(int age, Gender gender, int health, int lifeExpectancy) {
        super("Tiger", age, gender);
        setLifeExpectancy(lifeExpectancy);
        setHealth(health);
    }

    @Override
    public void treat() {
        stroke();
    }

    @Override
    public void stroke() {
        setHealth(getHealth() + 3);
    }
}
