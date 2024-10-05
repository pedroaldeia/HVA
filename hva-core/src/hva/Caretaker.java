package hva;

import java.util.ArrayList;
import java.util.List;

public class Caretaker extends Employee{
    private List<Habitat> _responsibilityList = new ArrayList<>();

    // implement addResponsibility and accept

    public Caretaker(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString(){
        if (_responsibilityList.isEmpty()){
            return "TRT|" + _id + "|" + _name; 
        }
        else{
            return "TRT|" + _id + "|" + _name + "|" + _responsibilityList; //FIXME implement how to print the list
        }
    }

    public String getId(){
        return _id;
    }

    public String getName(){
        return _name;
    }
}