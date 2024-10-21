package hva.season;

import hva.Hotel;
import hva.bioCycle.BioCycle;
import hva.bioCycle.DeciduousSpring;
import hva.bioCycle.EvergreenSpring;
import hva.tree.DeciduousTree;
import hva.tree.EvergreenTree;

public class Spring extends Season {
    public Spring(Hotel hotel) {
        super(hotel);
    }
    @Override
    public void advanceSeason() {
        _hotel.setSeason(new Summer(_hotel));
    }

    @Override
    public BioCycle getDeciduousCycle(DeciduousTree tree) {
        return new DeciduousSpring(tree);
    }

    @Override
    public BioCycle getEvergreenCycle(EvergreenTree tree) {
        return new EvergreenSpring(tree);
    }
}
