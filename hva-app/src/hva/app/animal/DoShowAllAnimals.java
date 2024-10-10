package hva.app.animal;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
//FIXME import other classes if needed


/**
* Displays all the animals in the hotel
*/
class DoShowAllAnimals extends Command<Hotel> {

    DoShowAllAnimals(Hotel receiver) {
        super(Label.SHOW_ALL_ANIMALS, receiver);
    }

    /**
     * Display all the animals in the hotel
     * @param allAnimals String with the animals to display
     */
    @Override
    protected final void execute() {
        //FIXME implement command
        String allAnimals = (String)_receiver.showAllAnimals();
        _display.popup(allAnimals);
    }

}
