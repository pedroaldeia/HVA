package hva.search;

import hva.animal.Animal;
import hva.habitat.Habitat;

public class SearchAnimalsInHabitat implements SearchStrategy {
    private Habitat _habitat;

    public SearchAnimalsInHabitat(Habitat habitat){
        _habitat = habitat;
    }

    @Override
    public String search() {
        String animalString = "";
        for (Animal animal : _habitat.getAnimalMap().values()){
            animalString = animalString + animal.toString() + "\n";
        }
        if(!animalString.equals("")){
            animalString = animalString.substring(0, animalString.length() - 1);
        }
        return animalString;
    }
}
