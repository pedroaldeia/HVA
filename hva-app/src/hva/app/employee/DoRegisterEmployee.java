package hva.app.employee;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.app.exceptions.DuplicateEmployeeKeyException;
import hva.exceptions.CoreDuplicateEmployeeKeyException;
//FIXME import other classes if needed

class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        String id = Form.requestString(Prompt.employeeKey());
        String name = Form.requestString(Prompt.employeeName());
        String type = Form.requestString(Prompt.employeeType());

        //FIXME add validation and error handling for inputs
        try{
            while (_receiver.registerEmployee(id, name, type) == -2){
                type = Form.requestString(Prompt.employeeType());
            };
            _receiver.registerEmployee(id, name, type);
        }catch (CoreDuplicateEmployeeKeyException e){throw new DuplicateEmployeeKeyException(e.getEmployeeKey());}

    }

}
