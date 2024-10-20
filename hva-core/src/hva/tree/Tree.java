package hva.tree;

import java.io.Serializable;

import hva.season.Season;

public abstract class Tree implements Serializable{
    private String _id;
    private String _name;
    private  int _age;
    private int _cleaningDifficulty;
    private Season _season;
    private int _seasonCounter;
    private String _type;

    /**
     * This is the constructor of the Tree class.
     * 
     * @param id the unique identifier of the tree
     * @param name the name of the tree
     * @param age the age of the tree
     * @param cleaningDifficulty the cleaning difficulty of the tree
     */
    public Tree(String id, String name, int age, int cleaningDifficulty, String type, Season season, String biologicCycle){
        _id = id;
        _name = name;
        _age = age;
        _cleaningDifficulty = cleaningDifficulty;
        _season = season;
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

    /**
     * This method returns the difficulty of cleaning the tree.
     * 
     * @return _cleaningDifficulty the difficulty of cleaning the tree
     */
    public int getDifficulty() {
        return _cleaningDifficulty;
    }

    /**
     * This method returns the age of the tree.
     * 
     * @return _age the age of the tree
     */
    public String getAge() {
        return "" + _age;
    }

    /**
     * This method returns the biologic cycle state of the tree.
     * 
     * @return _biologicCycle the biologic cycle state of the tree
     */
    public abstract String getCycle(Season season);

    /**
     * This method returns the type of the tree.
     * 
     * @return _type the type of the tree (CADUCA)
     */
    public String getType() {
        return _type;
    }

    /**
     * This method returns the details of the DeciduousTree.
     * 
     * @return a string with the details of the tree
     */
    @Override
    public String toString() {
        return "ÁRVORE|" + this.getId() + "|" + this.getName() + "|" + this.getAge() + 
          "|" + this.getDifficulty() + "|" + this.getType() + "|" + this.getCycle(_season);
    }

    public void age() {
        _seasonCounter++;
        if (_seasonCounter == 4) {
            _seasonCounter = 0;
            _age ++;
        }
    }

    public abstract int getEffort(Season season);

    //esforço_limpeza(a) = dificuldade_limpeza(a) * esforço_sazonal(a) * log(idade(a) + 1)
    public double calculateCleaningDifficulty() {
        return _cleaningDifficulty * this.getEffort(_season) * Math.log(_age + 1);
    }

}
