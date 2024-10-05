package hva;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class Habitat {
    private String _id;
    private String _name;
    private int _area;
    private int _population;
    private int _caretakersNum = 0;
    private int _treeNum = 0;
    private List<Animal> animals = new ArrayList<Animal>();
    private Map<String, Tree> trees = new HashMap<String, Tree>();
    private Map<String, Integer> compatibilities = new HashMap<String, Integer>();

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

    @Override
    public String toString(){
        return "HABITAT|" + this.getId() + this.getName() + _area + _treeNum; //implement print all trees in habitat
    }
}
