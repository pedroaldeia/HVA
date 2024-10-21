package hva.season;

import hva.Hotel;
import hva.bioCycle.BioCycle;
import hva.bioCycle.DeciduousWinter;
import hva.bioCycle.EvergreenWinter;
import hva.tree.DeciduousTree;
import hva.tree.EvergreenTree;

public class Winter extends Season {
    public Winter(Hotel hotel) {
        super(hotel);
    }
    @Override
    public void advanceSeason() {
        _hotel.setSeason(new Spring(_hotel));
    }

    @Override
    public BioCycle getDeciduousCycle(DeciduousTree tree) {
        return new DeciduousWinter(tree);
    }

    @Override
    public BioCycle getEvergreenCycle(EvergreenTree tree) {
        return new EvergreenWinter(tree);
    }
}
