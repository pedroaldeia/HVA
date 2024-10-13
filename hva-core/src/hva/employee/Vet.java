package hva.employee;

import hva.animal.Species;
import java.util.ArrayList;
import java.util.List;

public class Vet extends Employee{
    private List<Species> _responsibilityList = new ArrayList<>();

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
            return "VET|" + _id + "|" + _name + "|" + _responsibilityList; 
            //FIXME implement how to print the list
        }
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
        _responsibilityList.add(species);
    }
    
}
