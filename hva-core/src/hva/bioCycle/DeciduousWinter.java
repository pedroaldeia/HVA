package hva.bioCycle;

import hva.tree.Tree;

public class DeciduousWinter extends DeciduousCycle{

    public DeciduousWinter(Tree tree){
        super(tree,  0, "SEMFOLHAS");
    }

    @Override
    public void advanceSeason() {
        _tree.setCycle(new DeciduousSpring(_tree));
    }
}
