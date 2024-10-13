package hva.employee;

import hva.habitat.Habitat;
import java.util.ArrayList;
import java.util.List;

public class Caretaker extends Employee{
    private List<Habitat> _responsibilityList = new ArrayList<>();

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
            return "TRT|" + _id + "|" + _name; 
        }
        else{
            return "TRT|" + _id + "|" + _name + "|" + _responsibilityList; 
            //FIXME implement how to print the list
        }
    }

    /**
     * This method returns the unique identifier of the caretaker.
     * 
     * @return String identifier (_id)
     */
    public String getId(){
        return _id;
    }

    /**
     * This method returns the name of the caretaker.
     * 
     * @return String _name
     */
    public String getName(){
        return _name;
    }

    public void addResponsibility(Habitat habitat){
        _responsibilityList.add(habitat);
    }

    public void removeResponsibility(String id){
        _responsibilityList.removeIf(habitat -> habitat.getId().equals(id));
    }
}