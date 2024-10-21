package hva.bioCycle;

import hva.tree.Tree;

public class EvergreenSpring extends EvergreenCycle {

    public EvergreenSpring(Tree tree) {
        super(tree, 1, "GERARFOLHAS");
    }

    @Override
    public void advanceSeason() {
        _tree.setCycle(new EvergreenSummer(_tree));
    }
}
