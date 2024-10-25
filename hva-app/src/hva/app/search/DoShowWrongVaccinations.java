package hva.app.search;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.search.SearchHotel;
import hva.search.SearchWrongVaccinations;

class DoShowWrongVaccinations extends Command<Hotel> {

    DoShowWrongVaccinations(Hotel receiver) {
        super(Label.WRONG_VACCINATIONS, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        SearchHotel searchStrategy = new SearchWrongVaccinations();
        _display.popup(_receiver.searchHotel(searchStrategy));
    }

}
