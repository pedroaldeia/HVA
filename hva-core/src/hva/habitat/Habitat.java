package hva.habitat;

import hva.animal.Animal;
import hva.tree.Tree;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Habitat implements Serializable{
    private String _id;
    private String _name;
    private int _area;
    private int _caretakersNum = 0;
    private int _treeNum = 0;
    private Map<String, Animal> _animals = new TreeMap<>();
    private Map<String, Tree> _trees = new TreeMap<>();
    private Map<String, Integer> _influences = new HashMap<>();

    /**
     * This is the constructor of the Habitat class.
     * 
     * @param id the unique identifier of the habitat
     * @param name the name of the habitat
     * @param area the area of the habitat
     */
    public Habitat(String id, String name, int area){
        _id = id;
        _name = name;
        _area = area;
    }

    public void setArea(int area) {
        _area = area;
    }

    /**
     * This method returns the unique identifier of the habitat.
     * 
     * @return String identifier (_id)
     */
    public String getId(){
        return _id;
    }

    /**
     * This method returns the name of the habitat.
     * 
     * @return String _name
     */
    public String getName(){
        return _name;
    }

    public int getArea(){
        return _area;
    }

    public int getTreesNum(){
        return _trees.size();
    }

    public int getAnimalsNum(){
        return _animals.size();
    }

    public void addCaretakersNum(){
        _caretakersNum++;
    }

    public int getCaretakersNum(){
        return _caretakersNum;
    }

    /**
     * This method returns the map containing the animals in the habitat.
     * 
     * @return Map<String, Animal> _animals in the habitat
     */
    public Map<String, Animal> getAnimalMap(){
        return _animals;
    }

    public Map<String, Tree> getTreesMap(){
        return _trees;
    }

    /**
     * This method returns the details of the habitat.
     * 
     * @return a string with the details of the habitat
     */
    @Override
    public String toString(){
        if(_treeNum == 0){
            return "HABITAT|" + this.getId() + "|" + this.getName() + "|" + _area + "|" + 
          _treeNum;
        }
        else{
            return "HABITAT|" + this.getId() + "|" + this.getName() + "|" + _area + "|" + 
          _treeNum + "\n" + showAllTrees();
        }
    }

    /**
     * Puts a tree in the habitat (the tree must have already been created).
     * 
     * @param tree to put in the habitat
     * @return void
     */
    public void putTree(Tree tree){
        _trees.put(tree.getId(), tree);
        _treeNum++;
    }

    public boolean treeAlreadyExists(String id){
       return  _trees.containsKey(id);
    }

    public String showAllTrees() {
        String treeString = "";
        for (Tree tree : _trees.values()){
            treeString = treeString + tree.toString() + "\n";
        }
        if(!treeString.equals("")){
            treeString = treeString.substring(0, treeString.length() - 1);
        }
        return treeString;
    }

    /* FIXME this can be removed
    public String animalsInHabitatToString(){
        String animalString = "";
        for (Animal animal : _animals.values()){
            animalString = animalString + animal.toString() + "\n";
        }
        if(!animalString.equals("")){
            animalString = animalString.substring(0, animalString.length() - 1);
        }
        return animalString;
    }
    */

    public void putAnimalInHabitat(Animal animal){
        _animals.put(animal.getId(), animal);
    }

    public void removeAnimal(String animalId) {
        _animals.remove(animalId);
    }

    public int sameSpeciesInHabitat(String speciesId){
        int sameSpeciesCount = -1;
        for(Animal animal : _animals.values()){
            if(speciesId.equals(animal.getSpeciesId())) sameSpeciesCount++;
        }
        return sameSpeciesCount;
    }

    public int differentSpeciesInHabitat(String speciesId){
        int differentSpeciesCount = 0;
        for(Animal animal : _animals.values()){
            if(!speciesId.equals(animal.getSpeciesId())) differentSpeciesCount++;
        }
        return differentSpeciesCount;
    }
    public void addInfluence(String speciesId, int influence){
        _influences.put(speciesId, influence);
    }

    public int getHabitatInfluence(String speciesId){ 
        for(String otherSpeciesId : _influences.keySet()){
            if(speciesId.equals(otherSpeciesId)){
                if(_influences.get(otherSpeciesId) != null) return _influences.get(otherSpeciesId);
                else return 0;
            }
        }
        return 0;
    }
}
