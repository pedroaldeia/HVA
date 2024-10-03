package hva;

public abstract class Tree {
    private String _id;
    private String _name;
    private int _age;
    private double _cleaningDifficulty;
    private Season _season;
    private int _seasonCounter;

    public Tree(String id, String name, int age, double cleaningDifficulty){
        _id = id;
        _name = name;
        _age = age;
        _cleaningDifficulty = cleaningDifficulty;
    }

}
