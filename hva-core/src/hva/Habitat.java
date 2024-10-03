package hva;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class Habitat {
    private String _id;
    private String _name;
    private int area;
    private int poopulation;
    private int caretakersNum = 0;
    private List<Animal> animals = new ArrayList<Animal>();
    private Map<String, Tree> trees = new HashMap<String, Tree>();
    private Map<String, Integer> compatibilities = new HashMap<String, Integer>();

    public Habitat(String id, String name, int area, int caretakersNum){
        _id = id;
        _name = name;
        this.area = area;
    }
}
