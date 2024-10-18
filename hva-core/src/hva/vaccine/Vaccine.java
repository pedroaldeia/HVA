package hva.vaccine;

import hva.animal.Animal;
import hva.animal.Species;
import hva.employee.Vet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import hva.exceptions.CoreVeterinarianNotAuthorizedException;

public class Vaccine implements Serializable{
    private String _name;
    private String _id;
    private int _nApplications = 0;
    private Map<String, String> _speciesIds = new TreeMap<>(); //key = species ID, value = species name FIXME change attribute name
    private List<VaccineApplication> _record = new ArrayList<>();

    /**
     * This is the constructor of the Vaccine class.
     * 
     * @param id the unique identifier of the vaccine
     * @param name the name of the vaccine
     * @param speciesIds a string of comma-separated species IDs this vaccine is meant 
     * for
     */
    /*
    public Vaccine(String id, String name, String speciesIds) {
        _name = name;
        _id = id;
        //_speciesIds = speciesIds.replaceAll("\\s", "");
    } //FIXME idk if this function is needed or not
    */
    public Vaccine(String id, String name, List<Species> speciesIds) {
        _name = name;
        _id = id;
        addSpecies(speciesIds);
    }
    /**
     * This method returns the unique identifier of the vaccine.
     * 
     * @return _id the unique identifier of the vaccine
     */
    public String getId(){
        return _id;
    }

    /**
     * This method returns the name of the vaccine.
     * 
     * @return _name the name of the vaccine
     */
    public String getName() {
        return _name;
    }

    /**
     * This method returns the details of the Vaccine.
     * 
     * @return a string with the details of the vaccine
     */
    @Override
    public String toString(){
        if(_speciesIds.isEmpty()){
            return "VACINA|" + this.getId() + "|" + this.getName() + "|" + _nApplications; 
        }
        return "VACINA|" + this.getId() + "|" + this.getName() + "|" + _nApplications + 
          "|" + speciesToString(); 
    }

    public String speciesToString(){
        if(_speciesIds.isEmpty()) return "";
        String out = "";
        for(String id : _speciesIds.keySet()){
            out += id + ",";
        }
        return out.substring(0, out.length()-1);
    }

    private void addSpecies(List<Species> species){
        if(species == null) return;
        for(Species s : species){
            _speciesIds.put(s.getId(), s.getName());
        }
    }

    public VaccineApplication vaccinateAnimal(Vet vet, Animal animal) throws 
       CoreVeterinarianNotAuthorizedException{
        VaccineApplication application = new VaccineApplication(this, vet, animal);
        if(!_speciesIds.containsKey(animal.getSpeciesId())){
            application.setSuccesfulness(false);
        }
        animal.getVaccinated(application, this);
        vet.newApplication(application);
        _record.add(application);
        _nApplications++;
        return application;
    }

    public String getSpeciesName(String id){
        return _speciesIds.get(id);
    }

    public List<String> getSpeciesNames(){
        List<String> namesList = new ArrayList<>();
        for(String id: _speciesIds.keySet()){
            namesList.add(_speciesIds.get(id));
        }
        return namesList;
    }
}
