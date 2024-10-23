package hva.TreeState;

import hva.tree.Tree;

public class EvergreenSpring extends EvergreenState {

    public EvergreenSpring(Tree tree) {
        super(tree, 1, "GERARFOLHAS");
    }

    @Override
    public void advanceState() {
        _tree.setState(new EvergreenSummer(_tree));
    }
}
