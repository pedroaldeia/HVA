package hva.bioCycle;

import hva.tree.Tree;

public class DeciduousSummer extends DeciduousCycle{
    
    public DeciduousSummer(Tree tree){
        super(tree, 2, "COMFOLHAS");
    }

    @Override
    public void advanceSeason(){
        _tree.setCycle(new DeciduousAutumn(_tree));
    }
}
