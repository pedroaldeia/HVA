package hva.season;

import hva.tree.Tree;

public class Summer extends Season{

    private int deciduousEffort = 2;
    private int EvergreenEffort = 1;

    public Summer(Tree tree){
        super(tree);
    }
    
    @Override
    public int calculateEffort(){
        return _tree.getDifficulty() * 2;
    }

    @Override
    public void advanceSeason(){
        _tree.setSeason(new Autumn(_tree));
    }
}
