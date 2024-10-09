package hva.animal;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Species implements Serializable{
    private  String _id;
    private String _name;
    private int _vetsNum = 0;
    private List<Animal> _animals = new ArrayList<Animal>();

    public Species(String id, String name){
        _id = id;
        _name = name;
    }


    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }
}
