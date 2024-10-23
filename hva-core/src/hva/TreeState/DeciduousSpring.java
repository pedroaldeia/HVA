package hva.TreeState;

import hva.tree.Tree;

public class DeciduousSpring extends DeciduousState{
    
    public DeciduousSpring(Tree tree) {
        super(tree, 1, "GERARFOLHAS");
    }

    @Override
    public void advanceState() {
        _tree.setState(new DeciduousSummer(_tree));
    }
}
