package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.CoreUnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoShowAllTreesInHabitat extends Command<Hotel> {

    DoShowAllTreesInHabitat(Hotel receiver) {
        super(Label.SHOW_TREES_IN_HABITAT, receiver);
            }

    @Override
    protected void execute() throws CommandException {
        String id  = Form.requestString(Prompt.habitatKey());
        try {
        String allTrees = (String)_receiver.showAllHabitatTrees(id);
        _display.popup(allTrees);
        } catch (CoreUnknownHabitatKeyException e) {
            throw new UnknownHabitatKeyException(id);}
    }

}
