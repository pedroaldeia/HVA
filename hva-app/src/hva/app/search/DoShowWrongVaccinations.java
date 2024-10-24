package hva.app.search;

import hva.Hotel;
import hva.exceptions.CoreException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoShowWrongVaccinations extends Command<Hotel> {

    DoShowWrongVaccinations(Hotel receiver) {
        super(Label.WRONG_VACCINATIONS, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _display.popup(_receiver.showWrongVaccinations());
        } catch (CoreException e) {e.printStackTrace();}
        
    }

}
