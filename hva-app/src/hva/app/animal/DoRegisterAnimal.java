package hva.app.animal;

import hva.Hotel;
import hva.app.exceptions.DuplicateAnimalKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
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
    protected final void execute() throws CommandException, DuplicateAnimalKeyException {
        String id = Form.requestString(Prompt.animalKey());
        String name = Form.requestString(Prompt.animalName());
        String speciesId = Form.requestString(Prompt.speciesKey());
        String habitatId = Form.requestString(hva.app.habitat.Prompt.habitatKey());

        //FIXME  levantar excepção
        try{
            if (_receiver.registerAnimal(id, name, speciesId, habitatId) == 1){
                String speciesName = Form.requestString(Prompt.speciesName());
                _receiver.registerSpecies(speciesId, speciesName);
            }
            _receiver.registerAnimal(id, name, speciesId, habitatId);
        }catch (DuplicateAnimalKeyException e) {throw e;}
        catch (UnknownHabitatKeyException e) {throw e;}
        //FIXME implement command
        

    }

}
