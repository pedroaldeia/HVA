package hva.app.habitat;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.app.exceptions.DuplicateHabitatKeyException;
//FIXME import other classes if needed
import hva.exceptions.CoreDuplicateHabitatKeyException;

/**
* Asks the hotel to register a new habitat
*/
class DoRegisterHabitat extends Command<Hotel> {

    DoRegisterHabitat(Hotel receiver) {
        super(Label.REGISTER_HABITAT, receiver);
        //FIXME add command fields if needed
    }

    /**
    * Registers a new habitat in the hotel
    *
    * @throws DuplicateHabitatKeyException if the habitat already exists
    */
    @Override
    protected void execute() throws CommandException {
        String id  = Form.requestString(Prompt.habitatKey());
        String name = Form.requestString(Prompt.habitatName());
        int area = Form.requestInteger(Prompt.habitatArea());

        try{
            _receiver.registerHabitat(id, name, area);
        }catch(CoreDuplicateHabitatKeyException e){throw new DuplicateHabitatKeyException(e.getHabitatKey());}
    };
    
}
