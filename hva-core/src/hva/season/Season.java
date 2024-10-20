package hva.season;
import java.io.Serializable;

import hva.tree.Tree;

public abstract class Season implements Serializable{
    protected Tree _tree;

    /**
     * This is the constructor of the Season class. WIP
     * 
     * @param tree
     */
    public Season(Tree tree){
        _tree = tree;
    }

    public abstract int calculateEffort();
    public abstract void advanceSeason();
}
