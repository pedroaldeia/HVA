package hva.bioCycle;

import java.io.Serializable;
import hva.tree.Tree;

public abstract class BioCycle implements Serializable{
    protected Tree _tree;
    private int _effort = 0;
    private String _state = "";

    public BioCycle(Tree tree, int effort, String state){
        _tree = tree;
        _effort = effort;
        _state = state;
    }

    public int getEffort() {
        return _effort;
    }

    public String getState() {
        return _state;
    }

    public abstract void advanceSeason();
}
