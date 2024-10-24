package hva.app.search;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
import hva.exceptions.CoreUnknownVeterinarianKeyException;
import hva.search.SearchMedicalActsByVeterinarian;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.app.vaccine.Prompt;
import hva.search.SearchVet;
import hva.search.SearchMedicalActsByVeterinarian;


class DoShowMedicalActsByVeterinarian extends Command<Hotel> {

    DoShowMedicalActsByVeterinarian(Hotel receiver) {
        super(Label.MEDICAL_ACTS_BY_VET, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        try {
            SearchVet searchStrategy = new SearchMedicalActsByVeterinarian();
            _display.popup(_receiver.searchInVet(
                Form.requestString(hva.app.employee.Prompt.employeeKey()), searchStrategy)); 
        } 
        catch (CoreUnknownVeterinarianKeyException e) {
            throw new UnknownVeterinarianKeyException(e.getVetKey());
        }
    }

}
