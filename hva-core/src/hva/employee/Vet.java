package hva.employee;

import hva.animal.Species;
import hva.exceptions.CoreUnknownSpeciesKeyException;
import java.util.Map;
import java.util.TreeMap;

public class Vet extends Employee{
    private Map<String,Species> _responsibilityList = new TreeMap<>();

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
        if (_responsibilityList.isEmpty()){
            return "VET|" + _id + "|" + _name; 
        }
        else{
            return "VET|" + _id + "|" + _name + "|" + responsibilityToString(); 
        }
    }

    private String responsibilityToString(){
        String responsibility = "";
        for(String key : _responsibilityList.keySet()){
            responsibility += _responsibilityList.get(key).getId() + ",";
        }
        return responsibility.substring(0, responsibility.length()-1);
    }


    /**
     * This method returns the unique identifier of the vet.
     * 
     * @return String identifier (_id)
     */
    public String getId(){
        return _id;
    }

    /**
     * This method returns the name of the vet.
     * 
     * @return String _name
     */
    public String getName(){
        return _name;
    }

    public void addResponsibility(Species species){
        _responsibilityList.put(species.getId(), species);
    }

    public void removeResponsibility(String id) throws CoreUnknownSpeciesKeyException{
        Species removed = _responsibilityList.remove(id);
        if(removed == null){
            throw new CoreUnknownSpeciesKeyException(id);
        }
    }
}
