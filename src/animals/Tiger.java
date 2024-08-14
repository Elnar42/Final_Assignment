package animals;

import boundaries.Enclosure;
import enums.Food;
import enums.Gender;

import java.util.Set;

public class Tiger extends BigCat {
    public Tiger(int age, Gender gender) {
        super("Tiger", age, gender);
        setLifeExpectancy(24);
    }

    @Override
    public void treat() {

    }
}
