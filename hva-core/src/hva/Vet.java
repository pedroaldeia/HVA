package hva;

import java.util.ArrayList;
import java.util.List;

public class Vet extends Employee{
    private List<Species> _responsibilityList = new ArrayList<>();

    // implement addResponsibility and accept

    public Vet(String id, String name) {
        super(id, name);
    }

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

    public String getId(){
        return _id;
    }

    public String getName(){
        return _name;
    }
}
