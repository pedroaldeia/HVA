package hva.app.employee;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.app.exceptions.DuplicateEmployeeKeyException;
import hva.exceptions.CoreDuplicateEmployeeKeyException;


/**
* Asks the hotel to register a new employee
*/
class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
        //FIXME add command fields if needed
    }

    /**
     * Registers a new employee in the hotel
     * 
     * @throws DuplicateEmployeeKeyException if the employee already exists
     */
    @Override
    protected void execute() throws CommandException {
        String id = Form.requestString(Prompt.employeeKey());
        String name = Form.requestString(Prompt.employeeName());
        String type = Form.requestString(Prompt.employeeType());

        try{
            while (_receiver.registerEmployee(id, name, type) == -2){
                type = Form.requestString(Prompt.employeeType());
            };
            _receiver.registerEmployee(id, name, type);
        }catch (CoreDuplicateEmployeeKeyException e){throw new DuplicateEmployeeKeyException(e.getEmployeeKey());}

    }

}
