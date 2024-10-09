package hva.app.main;

import hva.HotelManager;
import hva.exceptions.MissingFileAssociationException;
import java.io.FileNotFoundException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import java.io.IOException;

class DoNewFile extends Command<HotelManager> {
    DoNewFile(HotelManager receiver) {
        super(Label.NEW_FILE, receiver);
    }

    @Override
    protected final void execute() {
            try {
                _receiver.saveAs(Form.requestString(hva.app.main.Prompt.newSaveAs()));
            }
            catch(MissingFileAssociationException e1){_display.popup(hva.app.main.Message.fileNotFound());
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
    }
}
