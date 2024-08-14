package animals;

import boundaries.Enclosure;
import enums.Food;
import enums.Gender;

import java.util.Set;

public class Giraffe extends Animal {
    public Giraffe( int age, Gender gender) {
        super("Giraffe", age, gender);
        setLifeExpectancy(28);
        setEats(Set.of(Food.HAY, Food.FRUIT));
    }

    @Override
    public void treat() {

    }


}
