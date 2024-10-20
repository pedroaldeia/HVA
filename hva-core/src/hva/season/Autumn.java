package hva.season;

import hva.tree.Tree;

public class Autumn extends Season {

    private int deciduousEffort = 5;
    private int EvergreenEffort = 1;

    public Autumn(Tree tree){
        super(tree);
    }

    @Override
    public int calculateEffort(){
        return _tree.getDifficulty() * 2;
    }

    @Override
    public void advanceSeason(){
        _tree.setSeason(new Winter(_tree));
    }
}
