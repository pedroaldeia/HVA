package hva;

import hva.exceptions.ImportFileException;
import java.io.Serial;
import java.io.Serializable;

import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class Hotel implements Serializable {

    //indexados pelo id
    private Map<String, Habitat> _habitats = new HashMap<String, Habitat>();
    private Map<String, Employee> _employees = new HashMap<String, Employee>();
    private Map<String, Vaccine> _vaccines = new HashMap<String, Vaccine>();

    public Hotel(){};

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
    //public int registerAnimal(){}
    //public String displayAnimals(){}


    //Menu de Gestão de Funcionários
    /*public int registerEmployee(String... fields){
        if (_employees.containsKey(id)) {
            //throw DuplicateHabitatKeyException
            return -1;
        }
        Employee newEmployee = new Employee();
        _employees.put(id, newEmployee);e);
        return 0;
    }*/
    //public String displayEmployees(){}


    //Menu de Gestão de Habitats 
    public int registerHabitat(String id, String name, int area){
        if (_habitats.containsKey(id)) {
            //throw DuplicateHabitatKeyException
            return -1;
        }
        Habitat newHabitat = new Habitat(id, name, area);
        _habitats.put(id, newHabitat);
        return 0;

    }
    //public String displayHabitats(){}


    //Menu de Gestão de Vacinas
    public int registerVaccine(String id, String name, List<String> speciesId){
        if (_vaccines.containsKey(id)) {
            //throw DuplicateVaccineKeyException
            return -1;
        }
        Vaccine newVaccine = new Vaccine(id, name, speciesId);
        _vaccines.put(id, newVaccine);
        return 0;
    }

    //public String displayVaccines(){}
    

}