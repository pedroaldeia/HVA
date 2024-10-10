package hva.app.main;

import hva.HotelManager;
import hva.exceptions.MissingFileAssociationException;
import java.io.FileNotFoundException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import java.io.IOException;
//FIXME import other classes if needed

class DoSaveFile extends Command<HotelManager> {
    DoSaveFile(HotelManager receiver) {
        super(Label.SAVE_FILE, receiver, r -> r.getHotel() != null);
    }

    @Override
    protected final void execute(){
        try {
            _receiver.save();
          } 
          catch(MissingFileAssociationException e){
            try {
                _receiver.saveAs(Form.requestString(hva.app.main.Prompt.newSaveAs()));
            }
            catch(MissingFileAssociationException e1){_display.popup(hva.app.main.
                    Message.fileNotFound());
            }
            catch(FileNotFoundException e1){
                _display.popup(hva.app.main.Message.fileNotFound());
              }
            catch (IOException e1) {
                e.printStackTrace();
              }
          }
          catch(FileNotFoundException e){
            _display.popup(hva.app.main.Message.fileNotFound());
          }
          catch (IOException e) {
            e.printStackTrace();
          }
    }
}
