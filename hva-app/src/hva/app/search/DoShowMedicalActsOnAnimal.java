package hva.app.search;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
import hva.app.animal.Prompt;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.exceptions.CoreUnknownAnimalKeyException;
//FIXME import other classes if needed

class DoShowMedicalActsOnAnimal extends Command<Hotel> {

    DoShowMedicalActsOnAnimal(Hotel receiver) {
        super(Label.MEDICAL_ACTS_ON_ANIMAL, receiver);
	//FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _display.popup(_receiver.showMedicalActsOnAnimal(
                Form.requestString(hva.app.animal.Prompt.animalKey())));
        } catch (CoreUnknownAnimalKeyException e) {
            throw new UnknownAnimalKeyException(e.getAnimalKey());
        }
        
    }

}
