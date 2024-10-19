package hva.app.search;

import hva.Hotel;
import hva.exceptions.CoreUnknownHabitatKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.app.exceptions.UnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
//FIXME import other classes if needed

class DoShowAnimalsInHabitat extends Command<Hotel> {

    DoShowAnimalsInHabitat(Hotel receiver) {
        super(Label.ANIMALS_IN_HABITAT, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _display.popup(_receiver.showAnimalsInHabitat(
                Form.requestString(hva.app.habitat.Prompt.habitatKey())));
        } catch(CoreUnknownHabitatKeyException e) {
            throw new UnknownHabitatKeyException(e.getHabitatKey());
        }
    }

}
