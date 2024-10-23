package hva.app.animal;

import hva.Hotel;
import hva.app.exceptions.DuplicateAnimalKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.app.exceptions.DuplicateSpeciesNameException;
import hva.exceptions.CoreDuplicateAnimalKeyException;
import hva.exceptions.CoreUnknownHabitatKeyException;
import hva.exceptions.CoreUnknownSpeciesKeyException;
import hva.exceptions.CoreDuplicateSpeciesNameException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


/**
* Asks the hotel to register a new animal
*/
class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
        //FIXME add command fields if needed
    }

    /**
     * This method registers an animal in the hotel and it's species
     * if they don't already exist
     * 
     * @param id the unique identifier of the animal
     * @param name the name of the animal 
     * @param speciesID the unique identifier of the species
     * @param habitatId the unique identifier of the habitat
     * @throws DuplicateAnimalKeyException if the animal is already registered 
     * @throws UnknownHabitatKeyException if the habitat doesn't exist
     */
    @Override
    protected final void execute() throws CommandException{
        String id = Form.requestString(Prompt.animalKey());
        String name = Form.requestString(Prompt.animalName());
        String speciesId = Form.requestString(Prompt.speciesKey());
        String habitatId = Form.requestString(hva.app.habitat.Prompt.habitatKey());

        try{
            if (!_receiver.speciesAlreadyExists(speciesId)){
                String speciesName = Form.requestString(Prompt.speciesName());
                _receiver.registerSpecies(speciesId, speciesName);
            }
            _receiver.registerAnimal(id, name, speciesId, habitatId);
        }catch (CoreDuplicateAnimalKeyException e) {
            throw new DuplicateAnimalKeyException(e.getAnimalKey());
        }
        catch (CoreUnknownHabitatKeyException e) {
            throw new UnknownHabitatKeyException(e.getHabitatKey());
        }
        catch (CoreDuplicateSpeciesNameException e) {
            throw new DuplicateSpeciesNameException(e.getSpeciesName());
        }
        catch (CoreUnknownSpeciesKeyException e) { //never gets caught
            throw new UnknownSpeciesKeyException(e.getSpeciesKey()); 
        }
        

    }

}
