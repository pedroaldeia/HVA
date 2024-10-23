package hva.animal;

import hva.habitat.Habitat;
import hva.vaccine.Vaccine;
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
          injuryRecordToString() + "|" + _habitat.getId(); 
        //FIXME implement show injury Record
    }

    private String injuryRecordToString(){
        String record = "";
        for(VaccineApplication application : _injuryRecord){
            record += application.getStatus() + ",";
        }
        if(!record.equals("")){
            record = record.substring(0, record.length() - 1);
        }
        return record;
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

    public Habitat getHabitat(){
        return _habitat;
    }

    public Species getSpecies(){
        return _species;
    }

    public String getSpeciesId(){
        return _species.getId();
    }

    public List<VaccineApplication> getInjuryRecord(){
        return _injuryRecord;
    }

    public void getVaccinated(VaccineApplication application, Vaccine vaccine){
        _injuryRecord.add(application);
        if(application.getSuccesfulness() == false){
            int damage = damageCalculator(vaccine);
            application.setStatus(damage);
        }
    }

    private int damageCalculator(Vaccine vaccine){ 
        int max = 0;
        int current;
        String animalName = getName().toLowerCase();
        for(String currentString : vaccine.getSpeciesNames()){
            current = 0;
            currentString = currentString.toLowerCase();
            for(char c1 : animalName.toCharArray()){
                for(char c2 : currentString.toCharArray()){
                    if(c1 == c2){
                        current -= 1;
                    }
                }
            }
            current += animalName.length();
            if(max < current) max = current;
        }
        return max;
    } 

    /* FIXME remove this
    public String vaccinationsToString(){
        String record = "";
        for(VaccineApplication application : _injuryRecord){
            record += application.toString() + "\n";
        }
        if(!record.equals("")){
            record.substring(0, record.length() - 1);
        }
        return record;
    }
    */
    

    public double getAnimalSatisfaction(){
        int sameSpeciesCount = getHabitat().sameSpeciesInHabitat(getId());
        int differentSpeciesCount = getHabitat().differentSpeciesInHabitat(getId());
        int habitatInfluence = getHabitat().getHabitatInfluence(getSpeciesId());
        int habitatArea = getHabitat().getArea();
        int animalCount = getHabitat().getAnimalsNum();
        return 20 + 3*sameSpeciesCount - 2*differentSpeciesCount +
             habitatArea/animalCount + 20*habitatInfluence;
    }
}
