package hva;

import hva.exceptions.ImportFileException;
import java.io.Serial;
import java.io.Serializable;

import java.util.Map;
import java.util.HashMap;


public class Hotel implements Serializable {

    private Map _habitat = new HashMap<String, Habitat>();
    private Map _employees = new HashMap<String, Employee>();


    @Serial
    private static final long serialVersionUID = 202407081733L;

    //FIXME define attributes
    //FIXME define constructor(s)
    //FIXME define methods

    /**
     * Read text input file and create domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    void importFile(String filename) throws ImportFileException {
	/*try {
            // FIXME open import file and create the associated objects
	    // ....
        } catch (IOException | UnrecognizedEntryException / FIXME maybe other exceptions / e) {
            throw new ImportFileException(filename, e);
        }*/
    }

    //Menu de Gestão de Animais
    public String registerAnimal(){}
    public String displayAnimals(){}


    //Menu de Gestão de Funcionários
    public String registerEmployee(){}
    public String displayEmployee(){}


    //Menu de Gestão de Habitats 
    public String registerHabitats(){}
    public String displayHabitats(){}


    //Menu de Gestão de Vacinas
    public String registerVaccines(){}
    public String displayVaccine(){}
    

}