package hva.app.employee;

import hva.Hotel;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.exceptions.CoreUnknownEmployeeKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoShowSatisfactionOfEmployee extends Command<Hotel> {

    DoShowSatisfactionOfEmployee(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_EMPLOYEE, receiver);
            }

    @Override
    protected void execute() throws CommandException {
        String id = Form.requestString(Prompt.employeeKey());
        try{
            int satisfaction = _receiver.calculateEmployeeSatisfaction(id);
            _display.popup(satisfaction);
        } catch (CoreUnknownEmployeeKeyException e) {throw new UnknownEmployeeKeyException(id);}
    }

}
