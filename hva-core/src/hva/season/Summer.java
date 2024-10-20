package hva.season;

import hva.Hotel;

public class Summer extends Season{

    public Summer(Hotel hotel){
        super(hotel, 2, "COMFOLHAS", 1, "COMFOLHAS");
    }

    @Override
    public void advanceSeason(){
        _hotel.setSeason(new Autumn(_hotel));
    }
}
