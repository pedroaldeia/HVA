package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.exceptions.CoreUnknownSpeciesKeyException;
import hva.exceptions.CoreUnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoChangeHabitatInfluence extends Command<Hotel> {

    DoChangeHabitatInfluence(Hotel receiver) {
        super(Label.CHANGE_HABITAT_INFLUENCE, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        String habitatId  = Form.requestString(Prompt.habitatKey());
        String speciesId = Form.requestString(hva.app.animal.Prompt.speciesKey());
        String influence = Form.requestString(Prompt.habitatInfluence());
        try {
            _receiver.setHabitatInfluence(habitatId, speciesId, influence);
        } catch (CoreUnknownHabitatKeyException e) {throw new UnknownHabitatKeyException(habitatId);
        } catch (CoreUnknownSpeciesKeyException e) {throw new UnknownSpeciesKeyException(speciesId);
        } catch (IllegalArgumentException e) {e.printStackTrace();}
    }

}
