package hva.app.vaccine;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.app.exceptions.DuplicateVaccineKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
//FIXME import other classes if needed

class DoRegisterVaccine extends Command<Hotel> {

    DoRegisterVaccine(Hotel receiver) {
        super(Label.REGISTER_VACCINE, receiver);
	//FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        String id = Form.requestString(Prompt.vaccineKey());
        String name = Form.requestString(Prompt.vaccineName());
        String speciesIds = Form.requestString(Prompt.listOfSpeciesKeys());

        try{
        _receiver.registerVaccine(id, name, speciesIds);
        }catch(DuplicateVaccineKeyException e){throw e;}
        catch(UnknownSpeciesKeyException e){throw e;}
    }

}
