package hva.TreeState;

import java.io.Serializable;
import hva.tree.Tree;

public abstract class TreeState implements Serializable{
    protected Tree _tree;
    private int _effort = 0;
    private String _state = "";

    public TreeState(Tree tree, int effort, String state){
        _tree = tree;
        _effort = effort;
        _state = state;
    }

    public int getEffort() {
        return _effort;
    }

    public String getBioCycle() {
        return _state;
    }

    public abstract void advanceState();
}
