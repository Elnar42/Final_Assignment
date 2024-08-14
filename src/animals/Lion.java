package animals;

import boundaries.Enclosure;
import enums.Food;
import enums.Gender;

import java.util.Set;

public  class Lion extends BigCat{

    public Lion( int age, Gender gender) {
        super("Lion", age, gender);
        setLifeExpectancy(24);
    }

    //Will be added
    @Override
    public void treat() {

    }


}
