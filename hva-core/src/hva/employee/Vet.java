package hva.employee;

import hva.animal.Species;
import hva.exceptions.CoreUnknownSpeciesKeyException;
import hva.exceptions.CoreVeterinarianNotAuthorizedException;
import hva.vaccine.VaccineApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Vet extends Employee{
    private Map<String, Species> _responsibilityMap = new TreeMap<>();
    private List<VaccineApplication> _vaccineApplications = new ArrayList<>();

    // implement addResponsibility and accept

    /**
     * This is the constructor of the Vet class.
     * 
     * @param id the unique identifier of the vet
     * @param name the name of the vet
     */
    public Vet(String id, String name) {
        super(id, name, "VET");
    }

    /**
     * This method returns the details of the vet.
     * 
     * @return a string with the details of the vet
     */
    @Override
    public String toString(){
        if (_responsibilityMap.isEmpty()){
            return "VET|" + getId() + "|" + getName(); 
        }
        else{
            return "VET|" + getId() + "|" + getName() + "|" + responsibilityToString(); 
        }
    }

    private String responsibilityToString(){
        String responsibility = "";
        for(String key : _responsibilityMap.keySet()){
            responsibility += _responsibilityMap.get(key).getId() + ",";
        }
        return responsibility.substring(0, responsibility.length()-1);
    }


    /**
     * This method returns the unique identifier of the vet.
     * 
     * @return String identifier (_id)
     */
    @Override
    public String getId(){
        return super.getId();
    }

    /**
     * This method returns the name of the vet.
     * 
     * @return String _name
     */
    @Override
    public String getName(){
        return super.getName();
    }

    public void addResponsibility(Species species){
        _responsibilityMap.put(species.getId(), species);
    }

    public void removeResponsibility(String id) throws CoreUnknownSpeciesKeyException{
        Species removed = _responsibilityMap.remove(id);
        if(removed == null){
            throw new CoreUnknownSpeciesKeyException(id);
        }
    }

    @Override
    public int accept(SatisfactionCalculator sc){
        return sc.visitVet(this);
    }

    public Map<String, Species> getResponsibilityMap(){
        return _responsibilityMap;
    }

    public Species getResponsibility(String id){
        return _responsibilityMap.get(id);
    }

    public void newApplication(VaccineApplication application) throws 
        CoreVeterinarianNotAuthorizedException{
        if(_responsibilityMap.get(application.getSpeciesId()) == null){
            throw new CoreVeterinarianNotAuthorizedException(getId(), application.getSpeciesId());
        }
        _vaccineApplications.add(application);
    }

    public String medicalActsToString(){
        String record = "";
        for(VaccineApplication application : _vaccineApplications){
            record += application.toString() + "\n";
        }
        if(!record.equals("")){
            record.substring(0, record.length() - 1);
        }
        return record;
    }
}
