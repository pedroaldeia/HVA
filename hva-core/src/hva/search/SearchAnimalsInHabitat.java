package hva.search;

import hva.animal.Animal;
import hva.habitat.Habitat;

public class SearchAnimalsInHabitat implements SearchHabitat {

    public SearchAnimalsInHabitat(){}

    @Override
    public String search(Habitat habitat){
        String animalString = "";
        for (Animal animal : habitat.getAnimalMap().values()){
            animalString = animalString + animal.toString() + "\n";
        }
        if(!animalString.equals("")){
            animalString = animalString.substring(0, animalString.length() - 1);
        }
        return animalString;
    }
}
