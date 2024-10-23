package hva.TreeState;

import hva.tree.Tree;

public class DeciduousWinter extends DeciduousState{

    public DeciduousWinter(Tree tree){
        super(tree,  0, "SEMFOLHAS");
    }

    @Override
    public void advanceState() {
        _tree.setState(new DeciduousSpring(_tree));
    }
}
