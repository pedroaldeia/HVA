package hva.tree;

import hva.season.Season;

public class EvergreenTree extends Tree{

    /**
     * This is the constructor of the EvergreenTree class.
     * 
     * @param id the unique identifier of the tree
     * @param name the name of the tree
     * @param age the age of the tree
     * @param cleaningDifficulty the difficulty of cleaning the tree
     * @return void
     */
    public EvergreenTree(String id, String name, int age, int cleaningDifficulty, Season season){
        super(id, name, age, cleaningDifficulty, "PERENE");
        _cycle = season.getEvergreenCycle(this);
    }

    /**
     * This method returns the details of the EvergreenTree.
     * 
     * @return a string with the details of the tree
     */
    @Override
    public String toString() {
        return super.toString(); // FIXME idk if this works, its auto generated
    }
}