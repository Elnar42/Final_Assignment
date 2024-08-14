package animals;

import boundaries.Enclosure;
import enums.Food;
import enums.Gender;

import java.util.Set;

public class Bear extends Animal{
    public Bear(int age, Gender gender) {
        super("Bear", age, gender);
        setLifeExpectancy(18);
        setEats(Set.of(Food.FISH, Food.STEAK));
    }

    @Override
    public void treat() {

    }


}
