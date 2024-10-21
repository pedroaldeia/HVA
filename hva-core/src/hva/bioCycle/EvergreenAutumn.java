package hva.bioCycle;

import hva.tree.Tree;

public class EvergreenAutumn extends EvergreenCycle{
    
    public EvergreenAutumn(Tree tree){
        super(tree, 1, "COMFOLHAS");
    }

    @Override
    public void advanceSeason() {
        _tree.setCycle(new EvergreenWinter(_tree));
    }
}
