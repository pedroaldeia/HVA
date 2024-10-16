package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.CoreUnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

//FIXME import other classes if needed

class DoChangeHabitatArea extends Command<Hotel> {

    DoChangeHabitatArea(Hotel receiver) {
        super(Label.CHANGE_HABITAT_AREA, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        String id  = Form.requestString(Prompt.habitatKey());
        String area = Form.requestString(Prompt.habitatArea());
        try {
            _receiver.changeHabitatArea(id, area);
        } catch (CoreUnknownHabitatKeyException e) {throw new UnknownHabitatKeyException(id);}
    }

}
