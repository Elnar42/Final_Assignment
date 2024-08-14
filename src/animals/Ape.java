package animals;

import boundaries.Enclosure;
import enums.Food;
import enums.Gender;

import java.util.Set;

public abstract class Ape extends Animal{

    public Ape(String name, int age, Gender gender) {
        super(name, age, gender);
        setEats(Set.of(Food.FISH, Food.ICE_CREAM));
    }
}
