package hva;

import java.util.ArrayList;
import java.util.List;
import hva.Animal;

public class Species {
    private  String _id;
    private String _name;
    private int _vetsNum = 0;
    private List<Animal> _animals = new ArrayList<Animal>();

    public Species(String id, String name, int vetsNum){
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
