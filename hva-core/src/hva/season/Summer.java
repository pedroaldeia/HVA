package hva.season;

import hva.Hotel;
import hva.bioCycle.BioCycle;
import hva.bioCycle.DeciduousSummer;
import hva.bioCycle.EvergreenSummer;
import hva.tree.DeciduousTree;
import hva.tree.EvergreenTree;

public class Summer extends Season {
    public Summer(Hotel hotel) {
        super(hotel);
    }
    @Override
    public void advanceSeason() {
        _hotel.setSeason(new Autumn(_hotel));
    }

    @Override
    public BioCycle getDeciduousCycle(DeciduousTree tree) {
        return new DeciduousSummer(tree);
    }

    @Override
    public BioCycle getEvergreenCycle(EvergreenTree tree) {
       return new EvergreenSummer(tree);
    }
}
