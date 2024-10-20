package hva.season;

import hva.Hotel;

public class Spring extends Season{

    public Spring(Hotel hotel){
        super(hotel, 1, "GERARFOLHAS", 1, "GERARFOLHAS");
    }

    @Override
    public void advanceSeason(){
        _hotel.setSeason(new Summer(_hotel));
    }
}
