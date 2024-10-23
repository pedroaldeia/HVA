package hva.TreeState;

import hva.tree.Tree;

public class DeciduousAutumn extends DeciduousState{
    
    public DeciduousAutumn(Tree tree){
        super(tree, 5, "LARGARFOLHAS");
    }

    @Override
    public void advanceState() {
        _tree.setState(new DeciduousWinter(_tree));
    }
}
