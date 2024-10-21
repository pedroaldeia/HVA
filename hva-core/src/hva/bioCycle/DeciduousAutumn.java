package hva.bioCycle;

import hva.tree.Tree;

public class DeciduousAutumn extends DeciduousCycle{
    
    public DeciduousAutumn(Tree tree){
        super(tree, 5, "LARGARFOLHAS");
    }

    @Override
    public void advanceSeason() {
        _tree.setCycle(new DeciduousWinter(_tree));
    }
}
