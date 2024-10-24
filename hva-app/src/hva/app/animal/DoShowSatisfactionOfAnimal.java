package hva.app.animal;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
import hva.exceptions.CoreUnknownAnimalKeyException;
import hva.app.exceptions.UnknownAnimalKeyException;

class DoShowSatisfactionOfAnimal extends Command<Hotel> {

    DoShowSatisfactionOfAnimal(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
            }

    @Override
    protected final void execute() throws CommandException {
        try{
            _display.popup(_receiver.showSatisfactionOfAnimal(Form.requestString(Prompt.animalKey())));
        }
        catch(CoreUnknownAnimalKeyException e) { 
            throw new UnknownAnimalKeyException(e.getAnimalKey());
        }
    }
}
