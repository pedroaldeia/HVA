package hva.season;

import hva.Hotel;
import hva.bioCycle.BioCycle;
import hva.bioCycle.DeciduousAutumn;
import hva.bioCycle.EvergreenAutumn;
import hva.tree.DeciduousTree;
import hva.tree.EvergreenTree;

public class Autumn extends Season {
    public Autumn(Hotel hotel) {
        super(hotel);
    }
    @Override
    public void advanceSeason() {
        _hotel.setSeason(new Winter(_hotel));
    }

    @Override
    public BioCycle getDeciduousCycle(DeciduousTree tree) {
        return new DeciduousAutumn(tree);
    }

    @Override
    public BioCycle getEvergreenCycle(EvergreenTree tree) {
        return new EvergreenAutumn(tree);
    }
}
