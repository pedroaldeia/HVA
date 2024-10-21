package hva.bioCycle;

import hva.tree.Tree;

public class EvergreenSummer extends EvergreenCycle {

    public EvergreenSummer(Tree tree){
        super(tree, 1, "COMFOLHAS");
    }

    @Override
    public void advanceSeason(){
        _tree.setCycle(new EvergreenAutumn(_tree));
    }
}
