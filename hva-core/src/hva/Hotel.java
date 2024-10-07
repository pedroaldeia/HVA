package hva;

import hva.exceptions.ImportFileException;
import java.io.Serial;
import java.io.Serializable;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Hotel implements Serializable {

    //indexados pelo id
    private Map<String, Habitat> _habitats = new HashMap<String, Habitat>();
    private Map<String, Employee> _employees = new HashMap<String, Employee>();
    private Map<String, Vaccine> _vaccines = new HashMap<String, Vaccine>();
    private Map<String, Species> _species = new HashMap<String, Species>();
    private ArrayList<String> _animalIds = new ArrayList<String>();

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

    public int registerSpecies(String id, String name){
        if (_species.containsKey(id)) {
            //DuplicateSpeciesKeyException
            return -1;
        }
        Species newSpecies = new Species(id, name);
        _species.put(id, newSpecies);
        return 0;
    }

    //Menu de Gestão de Animais
    public int registerAnimal(String id, String name, String speciesId, String habitatId){
        if (_animalIds.contains(id)){
            //DuplicateAnimalKeyException
            return -1;
        }
        Species species = _species.get(speciesId);
        if (species == null) {
                //ask for new species name in the app
                return 1;
        }
        Habitat habitat = _habitats.get(habitatId);
        Animal newAnimal = new Animal(id, name, species, habitat);
        _animalIds.add(id);
        habitat.getAnimalMap().put(id, newAnimal);
        return 0;
    }

    public int setAnimalHabitat(String animalId, String habitatId){
        for (Habitat habitat : _habitats.values()){
            for (Animal animal : habitat.getAnimalMap().values()){
                if (animal.getId().equals(animalId)){
                    habitat.getAnimalMap().remove(animalId);
                    _habitats.get(habitatId).getAnimalMap().put(animalId, animal);
                    return 1;
                }
            }
        }
        return 0;
    }
    
    //Returns a String with all employees in hotel
    public String showAllAnimals(){
        String animalString = "";
        for (Habitat habitat : _habitats.values()){
            for (Animal animal : habitat.getAnimalMap().values()){
                animalString = animalString + animal.toString() + "\n";
            }
        }
        return animalString;
    }


    //Menu de Gestão de Funcionários
    public int registerEmployee(String id, String name, String type){
        if (_employees.containsKey(id)) {
            //throw DuplicateHabitatKeyException
            return -1;
        }
        Employee newEmployee;
        if (type.equals("TRT")){
            newEmployee = new Caretaker(id, name);
        }
        else if(type.equals("VET")){ 
            newEmployee = new Vet(id, name);
        }
        else {
            //pedir novo tipo de employee
            return -2;
        }
        _employees.put(id, newEmployee);
        return 0;
    }
    

    //Returns a String with all employees in hotel
    public String showAllEmployees(){
        String employeeString = "";
        for (Employee employee : _employees.values()){
            employeeString = employeeString + employee.toString() + "\n";
        }
        return employeeString;
    }


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

    //Returns a String with all habitats in hotel and corresponding trees
    public String showAllHabitats(){
        String habitatString = "";
        for (Habitat habitat : _habitats.values()){
            habitatString = habitatString + habitat.toString() + "\n";
        }
        return habitatString;
    }

    //Menu de Gestão de Vacinas
    public int registerVaccine(String id, String name, List<String> speciesIds){
        if (_vaccines.containsKey(id)) {
            //throw DuplicateVaccineKeyException
            return -1;
        }
        Vaccine newVaccine = new Vaccine(id, name, speciesIds);
        _vaccines.put(id, newVaccine);
        return 0;
    }

    //Returns a String with all vaccines
    public String showAllVaccines(){
        String vaccineString = "";
        for (Vaccine vaccine : _vaccines.values()){
            vaccineString = vaccineString + vaccine.toString() + "\n";
        }
        return vaccineString;
    }
    

}