package hva.TreeState;

import hva.tree.Tree;

public class EvergreenWinter extends EvergreenState {

    public EvergreenWinter(Tree tree){
        super(tree, 2, "LARGARFOLHAS");
    }

    @Override
    public void advanceState() {
        _tree.setState(new EvergreenSpring(_tree));
    }
}
