package hva.app.animal;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        /*String id = Form.requestString(Prompt.animalKey());
        String name = Form.requestString(Prompt.animalName());
        String speciesId = Form.requestString(Prompt.speciesKey());
        String habitatId = Form.requestString(Prompt.habitatKey());

        //FIXME  levantar excepção
        if (_receiver.registerAnimal(id, name, speciesId, habitatId) == 1){
            String speciesName = Form.requestString(Prompt.speciesName());
            _receiver.registerSpecies(speciesId, speciesName);
        }
        _receiver.registerAnimal(id, name, speciesId, habitatId);
        //FIXME implement command*/
        

    }

}
