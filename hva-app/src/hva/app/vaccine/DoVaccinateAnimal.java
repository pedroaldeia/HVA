package hva.app.vaccine;

import hva.Hotel;
import hva.exceptions.CoreUnknownAnimalKeyException;
import hva.exceptions.CoreUnknownVaccineKeyException;
import hva.exceptions.CoreUnknownVeterinarianKeyException;
import hva.exceptions.CoreVeterinarianNotAuthorizedException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.app.exceptions.VeterinarianNotAuthorizedException;
import hva.app.exceptions.UnknownVaccineKeyException;

class DoVaccinateAnimal extends Command<Hotel> {

    DoVaccinateAnimal(Hotel receiver) {
        super(Label.VACCINATE_ANIMAL, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        try {
            String[] rightSpecies = _receiver.vaccinateAnimal(Form.requestString(hva.app.vaccine.Prompt.vaccineKey()),
             Form.requestString(hva.app.animal.Prompt.animalKey()),
             Form.requestString(hva.app.vaccine.Prompt.veterinarianKey()));
             if(!Boolean.parseBoolean(rightSpecies[0])) {_display.popup(hva.app.vaccine.Message.wrongVaccine(rightSpecies[1], rightSpecies[2]));}
        } catch (CoreUnknownVaccineKeyException e){throw new UnknownVaccineKeyException(e.getVaccineKey());} 
        catch(CoreUnknownAnimalKeyException e) {throw new UnknownAnimalKeyException(e.getAnimalKey());} 
        catch(CoreUnknownVeterinarianKeyException e){throw new UnknownVeterinarianKeyException(e.getVetKey());} 
        catch(CoreVeterinarianNotAuthorizedException e){throw new VeterinarianNotAuthorizedException(e.getVetKey(), e.getSpecieskey());}
        
    }

}
