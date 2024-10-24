package hva.app.search;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
import hva.app.animal.Prompt;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.exceptions.CoreUnknownAnimalKeyException;
import hva.search.SearchAnimal;
import hva.search.SearchMedicalActsOnAnimal;

class DoShowMedicalActsOnAnimal extends Command<Hotel> {

    DoShowMedicalActsOnAnimal(Hotel receiver) {
        super(Label.MEDICAL_ACTS_ON_ANIMAL, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        SearchAnimal searchStrategy = new SearchMedicalActsOnAnimal();
        try {
            _display.popup(_receiver.searchInAnimal(
                Form.requestString(hva.app.animal.Prompt.animalKey()), searchStrategy));
        } catch (CoreUnknownAnimalKeyException e) {
            throw new UnknownAnimalKeyException(e.getAnimalKey());
        }
        
    }

}
