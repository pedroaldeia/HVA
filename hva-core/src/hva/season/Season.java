package hva.season;
import java.io.Serializable;

import hva.Hotel;
import hva.tree.DeciduousTree;
import hva.tree.EvergreenTree;

public abstract class Season implements Serializable{
    protected Hotel _hotel;
    private int _deciduousEffort = 0;
    private String _deciduousBioCycle = "";
    private int _evergreenEffort = 0;
    private String _evergreenBioCycle = "";

    /**
     * This is the constructor of the Season class. WIP
     * 
     * @param tree
     */
    public Season(Hotel hotel, int deciduousEffort, String deciduousBioCylce, 
                    int evergreenEffort, String  evergreenBioCyle) {
        _hotel = hotel;
        _deciduousEffort = deciduousEffort;
        _evergreenEffort = evergreenEffort;
        _evergreenBioCycle = evergreenBioCyle;
        _deciduousBioCycle = deciduousBioCylce;
    }

    public int getDeciduousEffort(DeciduousTree tree) {
        return _deciduousEffort;
    }

    public int getEvergreenEffort(EvergreenTree tree) {
        return _evergreenEffort;
    }

    public String getDeciduousBioCycle(DeciduousTree tree) {
        return _deciduousBioCycle;
    }

    public String getEvergreenBioCycle(EvergreenTree tree) {
        return _evergreenBioCycle;
    }

    public abstract void advanceSeason();
}
