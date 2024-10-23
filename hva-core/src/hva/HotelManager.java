package hva;

import hva.exceptions.*;
import java.io.*;
//FIXME import other Java classes
//FIXME import other project classes

/**
 * Class that represents the hotel application.
 */
public class HotelManager {

    /** This is the current hotel. */
    private Hotel _hotel = new Hotel();

    private String _filename = "";

    /**
     * Saves the serialized application's state into the file associated to the current 
     * network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be created or 
     *  opened.
     * @throws MissingFileAssociationException if the current network does not have a 
     *  file.
     * @throws IOException if there is some error while serializing the state of the 
     * network to disk.
     */
    public void save() throws FileNotFoundException, MissingFileAssociationException, 
        IOException {
        if(_filename == null || _filename.equals("")){
            throw new MissingFileAssociationException();
        }
        if(_hotel.getFileChanged() == true){ 
            try (ObjectOutputStream oos = new ObjectOutputStream(
                 new BufferedOutputStream(new FileOutputStream(_filename)))) {
                oos.writeObject(_hotel);
                _hotel.setFileChanged(false); 
            }
            catch(FileNotFoundException e) {throw e;}
            catch(IOException e) {throw e;} 
        }
    }

    /**
     * Saves the serialized application's state into the file associated to the current 
     * network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be created or 
     * opened.
     * @throws MissingFileAssociationException if the current network does not have a 
     * file.
     * @throws IOException if there is some error while serializing the state of the 
     * network to disk.
     */
    public void saveAs(String filename) throws FileNotFoundException, 
       MissingFileAssociationException, IOException {
        _filename = filename;
        save();
    }

    /**
     * @param filename name of the file containing the serialized application's state
     *        to load.
     * @throws UnavailableFileException if the specified file does not exist or there is
     *         an error while processing this file.
     */
    public void load(String filename) throws UnavailableFileException {

        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
            new FileInputStream(filename)))) {
            _hotel = (Hotel) ois.readObject();
            _hotel.setFileChanged(false);
            _filename = filename;
        }
        catch(FileNotFoundException e) {throw new UnavailableFileException(filename);}
        catch(IOException e) {;throw new UnavailableFileException(filename);}
        catch(ClassNotFoundException e){throw new UnavailableFileException(filename);}
    }


    /**
     * Read text input file.
     *
     * @param filename name of the text input file
     * @throws ImportFileException if an error occurs while importing the file
     */
    public void importFile(String filename) throws ImportFileException{
        _hotel.importFile(filename);
    }

    /**
     * This method returns the current hotel.
     * 
     * @return _hotel the current hotel
     */
    public Hotel getHotel(){
        return _hotel;
    }

    /**
     * This method returns the current filename associated with the hotel.
     * 
     * @return _filename the current filename associated with the hotel
     */
    public String getFilename() {
        return _filename;
    }

    /**
     * This method returns the current state of the hotel's file (changed or not).
     * 
     * @return int the current state of the hotel's file (changed or not)
     */
    public boolean getFileChanged(){
        return _hotel.getFileChanged();
    }

    public int advanceSeason(){
        return _hotel.advanceSeason();
    }
    
}
