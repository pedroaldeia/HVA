package hva;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String _id;
    private String _name;
    private Species _species;
    private Habitat _habitat;
    private List<Integer> _injuryRecord = new ArrayList<>();

    public Animal(String id, String name, Species species, Habitat habitat){
        _id = id;
        _name = name;
        _species = species;
        _habitat = habitat;
    }

    @Override
    public String toString(){
        if(_injuryRecord.isEmpty()){
            return "ANIMAL|" + _id + "|" + _name + "|" +_species.getId() + "|" + "VOID" + "|" + _habitat.getId();
        }
        return "ANIMAL|" + _id + "|" + _name + "|" +_species.getId() + "|" + _injuryRecord + "|" + _habitat.getId(); 
        //FIXME implement show injury Record
    }


    public String getId(){
        return _id;
    }

    public String getName(){
        return _name;
    }

    public void setSpecies(Species species){
        _species = species;
    }

    public void setHabitat(Habitat habitat){
        _habitat = habitat;
    }

}
