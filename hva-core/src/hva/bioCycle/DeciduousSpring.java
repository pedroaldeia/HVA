package hva.bioCycle;

import hva.tree.Tree;

public class DeciduousSpring extends DeciduousCycle{
    
    public DeciduousSpring(Tree tree) {
        super(tree, 1, "GERARFOLHAS");
    }

    @Override
    public void advanceSeason() {
        _tree.setCycle(new DeciduousSummer(_tree));
    }
}
