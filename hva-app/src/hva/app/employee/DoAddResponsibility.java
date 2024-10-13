package hva.app.employee;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
import hva.exceptions.CoreUnknownEmployeeKeyException;
import hva.exceptions.CoreNoResponsibilityException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.app.exceptions.NoResponsibilityException;
//FIXME import other classes if needed

class DoAddResponsibility extends Command<Hotel> {

    DoAddResponsibility(Hotel receiver) {
        super(Label.ADD_RESPONSABILITY, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.addResponsibility(Form.requestString(hva.app.employee.Prompt.employeeKey()),
            Form.requestString(hva.app.employee.Prompt.responsibilityKey()));
        } 
        catch (CoreUnknownEmployeeKeyException e) { throw new UnknownEmployeeKeyException(e.getId()); }
        catch (CoreNoResponsibilityException e) { throw new NoResponsibilityException(e.getEmployeeId(), e.getResponsibilityId()); }
    }

}
