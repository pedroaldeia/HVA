package hva.TreeState;

import hva.tree.Tree;

public class EvergreenAutumn extends EvergreenState{
    
    public EvergreenAutumn(Tree tree){
        super(tree, 1, "COMFOLHAS");
    }

    @Override
    public void advanceState() {
        _tree.setState(new EvergreenWinter(_tree));
    }
}
