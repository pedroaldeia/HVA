package hva;

import java.io.Serializable;

public abstract class Tree implements Serializable{
    protected String _id;
    protected String _name;
    protected  int _age;
    protected int _cleaningDifficulty;
    protected Season _season;
    protected int _seasonCounter;


    public Tree(String id, String name, int age, int cleaningDifficulty){
        _id = id;
        _name = name;
        _age = age;
        _cleaningDifficulty = cleaningDifficulty;
    }

    public String getId(){
        return _id;
    }

    public String getName() {
        return _name;
    }
}
