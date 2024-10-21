package hva.bioCycle;

import hva.tree.Tree;

public class EvergreenWinter extends EvergreenCycle {

    public EvergreenWinter(Tree tree){
        super(tree, 2, "LARGARFOLHAS");
    }

    @Override
    public void advanceSeason() {
        _tree.setCycle(new EvergreenSpring(_tree));
    }
}
