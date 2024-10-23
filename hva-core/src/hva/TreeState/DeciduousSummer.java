package hva.TreeState;

import hva.tree.Tree;

public class DeciduousSummer extends DeciduousState{
    
    public DeciduousSummer(Tree tree){
        super(tree, 2, "COMFOLHAS");
    }

    @Override
    public void advanceState(){
        _tree.setState(new DeciduousAutumn(_tree));
    }
}
