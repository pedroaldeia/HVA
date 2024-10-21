package hva.season;

import hva.bioCycle.BioCycle;
import hva.tree.DeciduousTree;
import hva.tree.EvergreenTree;
import hva.Hotel;

public abstract class Season {
    protected Hotel _hotel;

    public Season(Hotel hotel) {
        _hotel = hotel;
    }
    public abstract void advanceSeason();
    public abstract BioCycle getDeciduousCycle(DeciduousTree tree);
    public abstract BioCycle getEvergreenCycle(EvergreenTree tree);
}
