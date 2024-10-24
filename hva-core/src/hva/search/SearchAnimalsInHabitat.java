package hva.search;

import hva.animal.Animal;
import hva.habitat.Habitat;
import hva.Hotel;
import hva.exceptions.CoreUnknownHabitatKeyException;

public class SearchAnimalsInHabitat implements SearchStrategy {

    public SearchAnimalsInHabitat(){}

    @Override
    public String search(Hotel hotel, String id) throws CoreUnknownHabitatKeyException{
        Habitat _habitat = hotel.getHabitat(id);
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
