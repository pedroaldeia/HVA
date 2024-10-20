package hva.app.animal;

import hva.Hotel;
import java.text.Normalizer;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.exceptions.CoreUnknownAnimalKeyException;
import hva.exceptions.CoreUnknownHabitatKeyException;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;

class DoTransferToHabitat extends Command<Hotel> {

    DoTransferToHabitat(Hotel hotel) {
        super(Label.TRANSFER_ANIMAL_TO_HABITAT, hotel);
        //FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        try {
            _receiver.transferToHabitat(Form.requestString(hva.app.animal.Prompt.animalKey()),
              Form.requestString(hva.app.habitat.Prompt.habitatKey()));
        } 
        catch (CoreUnknownAnimalKeyException e) {
            throw new UnknownAnimalKeyException(e.getAnimalKey());
        }
        catch (CoreUnknownHabitatKeyException e) {
            throw new UnknownHabitatKeyException(e.getHabitatKey());
        }
    }

}
