package hva.animal;

import hva.habitat.Habitat;
import hva.vaccine.VaccineApplication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable{
    private String _id;
    private String _name;
    private Species _species;
    private Habitat _habitat;
    private List<VaccineApplication> _injuryRecord = new ArrayList<>();


    /**
     * This is the constructor of the Animal class.
     * 
     * @param id the unique identifier of the animal
     * @param name the name of the animal 
     * @param species the species of the animal
     * @param habitat the habitat the animal is in
     */
    public Animal(String id, String name, Species species, Habitat habitat){
        _id = id;
        _name = name;
        _species = species;
        _habitat = habitat;
    }

    /**
     * This method returns the details of the animal.
     * 
     * @return a string with the details of the animal
     */
    @Override
    public String toString(){
        //if (_habitat == null){System.out.println("WTF");}
        if(_injuryRecord.isEmpty()){
            return "ANIMAL|" + _id + "|" + _name + "|" +_species.getId() + "|" + "VOID" +
             "|" + _habitat.getId();
        }
        return "ANIMAL|" + _id + "|" + _name + "|" +_species.getId() + "|" + 
          _injuryRecord + "|" + _habitat.getId(); 
        //FIXME implement show injury Record
    }

    /**
     * This method returns the unique identifier of the animal.
     * 
     * @return String identifier (_id)
     */
    public String getId(){
        return _id;
    }

    /**
     * This method returns the name of the animal
     * 
     * @return String _name
     */
    public String getName(){
        return _name;
    }


    /**
     * This method sets the species of the animal
     * 
     * @param species of the animal
     * @return void
     */
    public void setSpecies(Species species){
        _species = species;
    }

    /**
     * This method sets the habitat of the animal
     * 
     * @param habitat of the animal
     */
    public void setHabitat(Habitat habitat){
        _habitat = habitat;
    }

}
