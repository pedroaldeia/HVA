package hva.app.animal;

import hva.Hotel;
import hva.HotelManager;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoRegisterAnimal extends Command<Hotel> {
    private Hotel _hotel;
    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
        this._hotel = receiver;
        //FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        //_hotel.registerAnimal(null, null, null, null);
        //FIXME implement command
        

    }

}
