package hva.season;

import hva.Hotel;

public class Autumn extends Season {

    public Autumn(Hotel hotel){
        super(hotel, 5, "LARGARFOLHAS",1, "COMFOLHAS");
    }

    @Override
    public void advanceSeason(){
        _hotel.setSeason(new Winter(_hotel));
    }
}
