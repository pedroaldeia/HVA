package hva.animal;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Species implements Serializable{
    private  String _id;
    private String _name;
    private int _vetsNum = 0;
    private List<Animal> _animals = new ArrayList<Animal>();


    /**
     * This is the constructor of the Species class.
     * 
     * @param id of the species
     * @param name of the species
     */
    public Species(String id, String name){
        _id = id;
        _name = name;
    }

    /**
     * This method returns the unique identifier of the species.
     * 
     * @return identifier (_id)
     */
    public String getId() {
        return _id;
    }

    /**
     * This method returns the name of the species.
     * 
     * @return _name
     */
    public String getName() {
        return _name;
    }

    public void addVetsNum(){
        _vetsNum++;
    }

    public void addAnimal(Animal animal){
            _animals.add(animal);
    }

    public int getVetsNum(){
        return _vetsNum;
    }

    public int getAnimalsNum(){
        return _animals.size();
    }
}
