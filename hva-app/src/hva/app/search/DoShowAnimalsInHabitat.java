package hva.app.search;

import hva.Hotel;
import hva.exceptions.CoreUnknownHabitatKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.app.exceptions.UnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import hva.search.SearchHabitat;
import hva.search.SearchAnimalsInHabitat;

class DoShowAnimalsInHabitat extends Command<Hotel> {

    DoShowAnimalsInHabitat(Hotel receiver) {
        super(Label.ANIMALS_IN_HABITAT, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        SearchHabitat searchStrategy = new SearchAnimalsInHabitat();
        try {
            _display.popup(_receiver.searchInHabitat(
                Form.requestString(hva.app.habitat.Prompt.habitatKey()), searchStrategy));
        } catch(CoreUnknownHabitatKeyException e) {
            throw new UnknownHabitatKeyException(e.getHabitatKey());
        }
    }

}
