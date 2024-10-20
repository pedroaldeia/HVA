package hva.season;

import hva.Hotel;

public class Winter extends Season {

    public Winter(Hotel hotel){
        super(hotel, 0, "SEMFOLHAS", 2, "LARGARFOLHAS");
    }

    @Override
    public void advanceSeason(){
        _hotel.setSeason(new Spring(_hotel));
    }
}
