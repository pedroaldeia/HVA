package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.DuplicateTreeKeyException;
import hva.exceptions.CoreDuplicateTreeKeyException;
import hva.exceptions.CoreUnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoAddTreeToHabitat extends Command<Hotel> {

    DoAddTreeToHabitat(Hotel receiver) {
        super(Label.ADD_TREE_TO_HABITAT, receiver);
            }

    @Override
    protected void execute() throws CommandException {
        String habitatId  = Form.requestString(Prompt.habitatKey());
        String treeId = Form.requestString(Prompt.treeKey());
        String name = Form.requestString(Prompt.treeName());
        String age = Form.requestString(Prompt.treeAge());
        String difficulty = Form.requestString(Prompt.treeDifficulty());
        String type = Form.requestString(Prompt.treeType());
        try {
            _display.popup(_receiver.registerTree(habitatId, treeId, name, age, difficulty, type));
        } catch (CoreUnknownHabitatKeyException e) {throw new UnknownHabitatKeyException(habitatId);
        } catch (CoreDuplicateTreeKeyException e) {throw new DuplicateTreeKeyException(treeId);
        } catch (IllegalArgumentException e) {e.printStackTrace();
        }

    }

}
