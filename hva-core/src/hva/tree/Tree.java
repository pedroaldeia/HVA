package hva.tree;

import java.io.Serializable;

public abstract class Tree implements Serializable{
    protected String _id;
    protected String _name;
    protected  int _age;
    protected int _cleaningDifficulty;
    protected Season _season;
    protected int _seasonCounter;
    protected String _type;
    protected String _biologicCycle;

    /**
     * This is the constructor of the Tree class.
     * 
     * @param id the unique identifier of the tree
     * @param name the name of the tree
     * @param age the age of the tree
     * @param cleaningDifficulty the cleaning difficulty of the tree
     */
    public Tree(String id, String name, int age, int cleaningDifficulty, String type, String biologicCycle){
        _id = id;
        _name = name;
        _age = age;
        _cleaningDifficulty = cleaningDifficulty;
        _type = type;
    }

    /**
     * This method returns the unique identifier of the tree.
     * 
     * @return _id the unique identifier of the tree
     */
    public String getId(){
        return _id;
    }

    /**
     * This method returns the name of the tree.
     * 
     * @return _name the name of the tree
     */
    public String getName() {
        return _name;
    }
}
