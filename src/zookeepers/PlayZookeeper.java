package zookeepers;

import animals.Animal;
import boundaries.Enclosure;
import stores.FoodStore;
import treats.*;

public class PlayZookeeper extends Zookeeper{

    public PlayZookeeper(Enclosure enclosure, FoodStore foodStore) {
        super(enclosure, foodStore);
    }


    @Override
    public void giveATreat() {
        int numberOfTreats = 0;
        for(Animal animal: getEnclosure().getAnimals()){
            if(numberOfTreats >= 2) break;
            if(animal.getHealth() > 0){
                if(animal instanceof Watchable){
                    ((Watchable)animal).watchAFilm();
                }
                if(animal instanceof Chaseable){
                    ((Chaseable)animal).playChase();
                }
                if(animal instanceof Paintable){
                    ((Paintable)animal).painting();
                }
                numberOfTreats++;
            }
        }
    }
}
