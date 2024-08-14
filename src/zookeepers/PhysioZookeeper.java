package zookeepers;

import animals.Animal;
import boundaries.Enclosure;
import stores.FoodStore;
import treats.Bathable;
import treats.Hugable;
import treats.Massageable;
import treats.Strokeable;

public class PhysioZookeeper extends Zookeeper {

    public PhysioZookeeper(Enclosure enclosure, FoodStore foodStore) {
        super(enclosure, foodStore);
    }

    @Override
    public void giveATreat() {
        int numberOfTreats = 0;
        for(Animal animal: getEnclosure().getAnimals()){
            if(numberOfTreats >= 2) break;
            if(animal.getHealth() > 0){
                if(animal instanceof Massageable){
                    ((Massageable)animal).neckMassage();
                }
                if(animal instanceof Bathable){
                    ((Bathable)animal).bath();
                }
                numberOfTreats++;
            }
        }
    }
}
