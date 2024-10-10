package hva.app.vaccine;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
* Displays all the vaccines in the hotel
*/
class DoShowAllVaccines extends Command<Hotel> {

    DoShowAllVaccines(Hotel receiver) {
        super(Label.SHOW_ALL_VACCINES, receiver);
    }

    /**
    * Displays all the vaccines in the hotel
    */
    @Override
    protected final void execute() {
        String allVaccines = (String)_receiver.showAllVaccines();
        _display.popup(allVaccines);
    }
}
