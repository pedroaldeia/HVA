package hva.app.search;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
import hva.exceptions.CoreUnknownVeterinarianKeyException;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.app.vaccine.Prompt;
//FIXME import other classes if needed

class DoShowMedicalActsByVeterinarian extends Command<Hotel> {

    DoShowMedicalActsByVeterinarian(Hotel receiver) {
        super(Label.MEDICAL_ACTS_BY_VET, receiver);
	//FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _display.popup(_receiver.showMedicalActsByVeterinarian(
                Form.requestString(hva.app.employee.Prompt.employeeKey()))); 
        } 
        catch (CoreUnknownVeterinarianKeyException e) {
            throw new UnknownVeterinarianKeyException(e.getVetKey());
        }
    }

}
