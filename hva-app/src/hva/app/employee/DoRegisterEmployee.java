package hva.app.employee;

import hva.Hotel;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.app.exceptions.DuplicateEmployeeKeyException;
import hva.exceptions.CoreDuplicateEmployeeKeyException;
import hva.exceptions.CoreNoResponsibilityException;
import hva.exceptions.CoreUnknownEmployeeKeyException;
import hva.exceptions.CoreUnknownHabitatKeyException;
import hva.exceptions.CoreUnknownSpeciesKeyException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.app.exceptions.NoResponsibilityException;

/**
* Asks the hotel to register a new employee
*/
class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
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
            while (!_receiver.isValidEmployeeType(type)){
                type = Form.requestString(Prompt.employeeType());
            }
            _receiver.registerEmployee(id, name, type);
        }
        catch (CoreDuplicateEmployeeKeyException e){
            throw new DuplicateEmployeeKeyException(e.getEmployeeKey());
        }
        catch (CoreNoResponsibilityException e){
            throw new NoResponsibilityException(e.getEmployeeId(), e.getResponsibilityId());
        }
        catch (CoreUnknownEmployeeKeyException e){
            throw new UnknownEmployeeKeyException(e.getId());
        }
        catch (CoreUnknownHabitatKeyException e){
            throw new UnknownHabitatKeyException(e.getHabitatKey());
        }
        catch (CoreUnknownSpeciesKeyException e){
            throw new UnknownSpeciesKeyException(e.getSpeciesKey());
        }
    }

}
