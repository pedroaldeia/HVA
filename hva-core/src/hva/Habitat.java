package hva;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;


public class Habitat implements Serializable{
    private String _id;
    private String _name;
    private int _area;
    private int _population;
    private int _caretakersNum = 0;
    private int _treeNum = 0;
    private Map<String, Animal> _animals = new HashMap<String, Animal>();
    private Map<String, Tree> _trees = new HashMap<String, Tree>();
    private Map<String, Integer> _compatibilities = new HashMap<String, Integer>();

    public Habitat(String id, String name, int area){
        _id = id;
        _name = name;
        _area = area;
    }

    public String getId(){
        return _id;
    }

    public String getName(){
        return _name;
    }

    public Map<String, Animal> getAnimalMap(){
        return _animals;
    }

    @Override
    public String toString(){
        return "HABITAT|" + this.getId() + "|" + this.getName() + "|" + _area + "|" + _treeNum; 
        //FIXME implement print all trees in habitat
    }
}
