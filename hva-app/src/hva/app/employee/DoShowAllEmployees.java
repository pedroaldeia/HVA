package hva.app.employee;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
* Displays all the employees in the hotel
*/
class DoShowAllEmployees extends Command<Hotel> {

    DoShowAllEmployees(Hotel receiver) {
        super(Label.SHOW_ALL_EMPLOYEES, receiver);
    }

    /**
    * Displays all the employees in the hotel
    */
    @Override
    protected void execute() throws CommandException {
        String allEmployees = (String)_receiver.showAllEmployees();
        _display.popup(allEmployees);
    }

}
