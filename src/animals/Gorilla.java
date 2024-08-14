package animals;

import boundaries.Enclosure;
import enums.Gender;

public class Gorilla extends Ape{

    public Gorilla(int age, Gender gender) {
        super("Gorilla", age, gender);
        setLifeExpectancy(32);
    }

    @Override
    public void treat() {

    }


}
