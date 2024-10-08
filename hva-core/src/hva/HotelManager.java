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
    private int fileChanged = 0;
    // FIXME maybe add more fields if needed

    /**
     * Saves the serialized application's state into the file associated to the current network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be created or opened.
     * @throws MissingFileAssociationException if the current network does not have a file.
     * @throws IOException if there is some error while serializing the state of the network to disk.
     */
    public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
        // FIXME implement serialization method
        if(_filename == null || _filename.equals("")){
            throw new MissingFileAssociationException();
        }
    
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_filename)))) {
            oos.writeObject(_hotel);
            fileChanged = 0;
        }catch(FileNotFoundException e) {e.printStackTrace();}
        catch(IOException e) {e.printStackTrace();} 
    }

    /**
     * Saves the serialized application's state into the file associated to the current network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be created or opened.
     * @throws MissingFileAssociationException if the current network does not have a file.
     * @throws IOException if there is some error while serializing the state of the network to disk.
     */
    public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
        _filename = filename;
        save();
    }

    /**
     * @param filename name of the file containing the serialized application's state
     *        to load.
     * @throws UnavailableFileException if the specified file does not exist or there is
     *         an error while processing this file.
     */
    public void load(String filename) throws UnavailableFileException, IOException, ClassNotFoundException {


        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            _hotel = (Hotel) ois.readObject();
            fileChanged = 0;
        }//esta parte é so para ele parar de se irritar
        //catch(UnavailableFileException e) {e.printStackTrace();}
        catch(IOException e) {e.printStackTrace();}
        catch(ClassNotFoundException e){e.printStackTrace();}
    }

    /**
     * Read text input file.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    public void importFile(String filename) throws ImportFileException {
        _hotel.importFile(filename);
    }
    public Hotel getHotel(){
        return _hotel;
    }

    // All Hotel functions //
    public int registerSpecies(String id, String name){
        return _hotel.registerSpecies(id, name);
    }

    public int registerAnimal(String id, String name, String speciesId, String habitatId){
        return _hotel.registerAnimal(id, name, speciesId, habitatId);
    }

    public int setAnimalHabitat(String animalId, String habitatId){
        return _hotel.setAnimalHabitat(animalId, habitatId);
    }

    public int registerEmployee(String id, String name, String type){
        return _hotel.registerEmployee(id, name, type);
    }

    /*public int registerVaccine(String id, String name, String type){
        return _hotel.registerVaccine(id, name, type);
    }*/



    public String showAllAnimals(){
        return _hotel.showAllAnimals();
    }

    public String showAllEmployees(){
        return _hotel.showAllEmployees();
    }

    public String showAllHabitats(){
        return _hotel.showAllHabitats();
    }

    public String showAllVaccines(){
        return _hotel.showAllVaccines();
    }
}
