package hva.app.employee;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.Hotel;
import hva.app.exceptions.NoResponsibilityException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.exceptions.CoreUnknownEmployeeKeyException;
import hva.exceptions.CoreNoResponsibilityException;
//FIXME import other classes if needed

class DoRemoveResponsibility extends Command<Hotel> {

    DoRemoveResponsibility(Hotel receiver) {
        super(Label.REMOVE_RESPONSABILITY, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.removeResponsibility(Form.requestString(hva.app.employee.Prompt.employeeKey()),
            Form.requestString(hva.app.employee.Prompt.responsibilityKey()));
        } 
        catch (CoreUnknownEmployeeKeyException e) { 
            throw new UnknownEmployeeKeyException(e.getId()); 
        }
        catch (CoreNoResponsibilityException e) { 
            throw new NoResponsibilityException(e.getEmployeeId(), e.getResponsibilityId()); 
        }
    }
}
