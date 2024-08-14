package animals;

import boundaries.Enclosure;
import enums.Food;
import enums.Gender;

import java.util.Set;

public class Elephant extends Animal{

    public Elephant(int age, Gender gender) {
        super("Elephant", age, gender);
        setLifeExpectancy(36);
        setEats(Set.of(Food.HAY, Food.FRUIT));
    }

    @Override
    public void treat() {

    }


}
