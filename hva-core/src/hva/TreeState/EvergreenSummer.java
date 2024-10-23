package hva.TreeState;

import hva.tree.Tree;

public class EvergreenSummer extends EvergreenState {

    public EvergreenSummer(Tree tree){
        super(tree, 1, "COMFOLHAS");
    }

    @Override
    public void advanceState(){
        _tree.setState(new EvergreenAutumn(_tree));
    }
}
