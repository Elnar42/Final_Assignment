package animals;

import boundaries.Enclosure;
import enums.Food;
import enums.Gender;
import treats.Strokeable;

import java.util.Set;

public abstract class BigCat extends Animal{
    public BigCat(String name, int age, Gender gender) {
        super(name, age, gender);
        setEats(Set.of(Food.STEAK, Food.CELERY));
    }
}
