package hva.season;

import hva.tree.Tree;

public class Winter extends Season {

    private int deciduousEffort = 0;
    private int EvergreenEffort = 2;

    public Winter(Tree tree){
        super(tree);
    }

    @Override
    public int calculateEffort(){
        return _tree.getDifficulty() * 2;
    }
    
    @Override
    public void advanceSeason(){
        _tree.setSeason(new Spring(_tree));
    }
}
