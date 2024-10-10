package hva.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import hva.HotelManager;
import hva.app.exceptions.FileOpenFailedException;
import hva.exceptions.UnavailableFileException;
import hva.exceptions.MissingFileAssociationException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoOpenFile extends Command<HotelManager> {
    DoOpenFile(HotelManager receiver) {
        super(Label.OPEN_FILE, receiver);
    }

    @Override
    protected final void execute() throws CommandException {
        
        if(_receiver.getFileChanged() == 1){
            if(Form.confirm(Prompt.saveBeforeExit())){
                /*
                DoSaveAs cmd = new DoSaveAs(_receiver);
                cmd.execute();
                */
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
        try {
            _receiver.load(Form.requestString(Prompt.openFile()));
        } 
        catch (UnavailableFileException e) {
            //System.out.println("AQUI");
            throw new FileOpenFailedException(e);
        }
    }
}

