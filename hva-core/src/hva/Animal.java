package hva;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String _id;
    private String _name;
    private Species _species;
    private Habitat _habitat;
    private List<Integer> injuryRecord = new ArrayList<>();

    public Animal(String id, String name, Species species){
        _id = id;
        _name = name;
        _species = species;
    }

}
