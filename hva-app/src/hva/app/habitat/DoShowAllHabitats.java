package hva.app.habitat;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
* Displays all the habitats in the hotel
*/
class DoShowAllHabitats extends Command<Hotel> {

    DoShowAllHabitats(Hotel receiver) {
        super(Label.SHOW_ALL_HABITATS, receiver);
    }

    /**
    * Displays all the employees in the hotel
    */
    @Override
    protected void execute() {
        String allHabitats = (String)_receiver.showAllHabitats();
        _display.popup(allHabitats);
    }
}
