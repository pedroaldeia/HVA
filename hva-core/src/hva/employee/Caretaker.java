package hva.employee;

import hva.exceptions.CoreUnknownHabitatKeyException;
import hva.habitat.Habitat;
import java.util.Map;
import java.util.TreeMap;

public class Caretaker extends Employee{
    private Map<String, Habitat> _responsibilityList = new TreeMap<>();

    //FIXME implement addResponsibility and accept
    /**
     * This is the constructor of the Caretaker class.
     * 
     * @param id the unique identifier of the caretaker
     * @param name the name of the caretaker
     */
    public Caretaker(String id, String name) {
        super(id, name, "TRT");
    }

    /**
     * This method returns the details of the caretaker.
     * 
     * @return a string with the details of the caretaker
     */
    @Override
    public String toString(){
        if (_responsibilityList.isEmpty()){
            return "TRT|" + getId() + "|" + getName(); 
        }
        else{
            return "TRT|" + getId() + "|" + getName() + "|" + responsibilityToString(); 
            //FIXME implement how to print the list
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
     * This method returns the unique identifier of the caretaker.
     * 
     * @return String identifier (_id)
     */
    @Override
    public String getId(){
        return super.getId();
    }

    /**
     * This method returns the name of the caretaker.
     * 
     * @return String _name
     */
    @Override
    public String getName(){
        return super.getName();
    }

    public void addResponsibility(Habitat habitat){
        _responsibilityList.put(habitat.getId(), habitat);
    }

    public void removeResponsibility(String id) throws CoreUnknownHabitatKeyException{
        Habitat removed = _responsibilityList.remove(id);
        if(removed == null){
            throw new CoreUnknownHabitatKeyException(id);
        }
    }
}