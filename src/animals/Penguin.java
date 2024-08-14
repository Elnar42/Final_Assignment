package animals;

import boundaries.Enclosure;
import enums.Food;
import enums.Gender;

import java.util.Set;

public class Penguin extends Animal {
    public Penguin(int age, Gender gender) {
        super("Penguin", age, gender);
        setLifeExpectancy(15);
        setEats(Set.of(Food.FISH, Food.ICE_CREAM));
    }

    @Override
    public void treat() {

    }


}
