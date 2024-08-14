package animals;

import boundaries.Enclosure;
import enums.Gender;

public class Chimpanzee extends Ape{
    public Chimpanzee(int age, Gender gender) {
        super("Chimpanzee", age, gender);
        setLifeExpectancy(24);
    }

    @Override
    public void treat() {

    }


}
