package hva;

import java.io.IOException;
import hva.exceptions.*;
import java.io.Serial;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Hotel implements Serializable {

    //indexados pelo id
    private Map<String, Habitat> _habitats = new TreeMap<>();
    private Map<String, Employee> _employees = new TreeMap<>();
    private Map<String, Vaccine> _vaccines = new TreeMap<>();
    private Map<String, Species> _species = new HashMap<>();
    private Map<String, Animal> _animals = new TreeMap<>();
    private Map<String, Tree> _trees = new HashMap<>();

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
    void importFile(String filename) throws ImportFileException { //FIXME implement cases where habitat has no treeId's, and employee has no extras
	try {
            // Read the first line from the file
            List<String> file = Files.readAllLines(Paths.get(filename));

            // Split the line
            for(String line : file){
                //System.out.println(line);
                List<String> wordsList = Arrays.asList(line.split("\\|"));
                switch(wordsList.get(0)){
                    case "ANIMAL" -> registerAnimal(wordsList.get(1), wordsList.get(2), wordsList.get(3), wordsList.get(4));
                    case "ESPÉCIE" -> registerSpecies(wordsList.get(1), wordsList.get(2));
                    case "HABITAT" -> registerHabitat(wordsList.get(1), wordsList.get(2), Integer.parseInt(wordsList.get(3)));
                    case "TRATADOR" -> registerEmployee(wordsList.get(1), wordsList.get(2), "TRT");
                    case "VETERINÁRIO" -> registerEmployee(wordsList.get(1), wordsList.get(2), "VET");
                    case "VACINA" -> registerVaccine(wordsList.get(1), wordsList.get(2), wordsList.get(3));
                    case "ÁRVORE" -> registerTree(wordsList.get(1), wordsList.get(2), Integer.parseInt(wordsList.get(3)), Integer.parseInt(wordsList.get(4)), wordsList.get(5));
                    default -> throw new UnrecognizedEntryException(wordsList.get(0));

                }
            }
        } catch (IOException | UnrecognizedEntryException e) {
            throw new ImportFileException(filename, e);}
        catch (Exception e) {}

    }

    //Splits a String of id's separated by a "," character into a List of Strings
    private List<String> splitId(String allIds){
        return(Arrays.asList(allIds.split(",")));
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
    public int registerAnimal(String id, String name, 
            String speciesId, String habitatId) 
            throws CoreDuplicateAnimalKeyException,
            CoreUnknownHabitatKeyException{

        if (_animals.containsKey(id)){
            throw new CoreDuplicateAnimalKeyException(id);
        }
        Species species = _species.get(speciesId);
        if (species == null) {
                //ask for new species name in the app
                return 1;
        }
        Habitat habitat = _habitats.get(habitatId);
        if (habitat == null) {
            throw new CoreUnknownHabitatKeyException(habitatId);
        }
        Animal newAnimal = new Animal(id, name, species, habitat);
        _animals.put(id, newAnimal);
        //habitat.getAnimalMap().put(id, newAnimal);
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
        for (Animal animal : _animals.values()){
            animalString = animalString + animal.toString() + "\n";
        }
        if(!animalString.equals("")){
            animalString = animalString.substring(0, animalString.length() - 1);
        }
        return animalString;
    }


    //Menu de Gestão de Funcionários
    public int registerEmployee(String id, String name, String type)
            throws CoreDuplicateEmployeeKeyException{
        if (_employees.containsKey(id)) {
            throw new CoreDuplicateEmployeeKeyException(id);
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
            return 1;
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
        if(!employeeString.equals("")){
            employeeString = employeeString.substring(0, employeeString.length() - 1);
        }
        return employeeString;
    }


    //Menu de Gestão de Habitats 
    public int registerHabitat(String id, String name, int area)
            throws CoreDuplicateHabitatKeyException{
        if (_habitats.containsKey(id)) {
            throw new CoreDuplicateHabitatKeyException(id);
        }
        Habitat newHabitat = new Habitat(id, name, area);
        _habitats.put(id, newHabitat);
        return 0;
    }

    //FIXME isto não devia existir!!!
    /*public int registerHabitat(String id, String name, int area, String idTrees) {
        List<String> idList = splitId(idTrees);
        for(String i : idList){
            if(!_trees.containsKey(i)){
                //FIXME throw no such tree exception
                return -1;
            }
        }
        if(_habitats.containsKey(id)){
            //FIXME throw DuplicateHabitatIdException
            return -1;
        }
        Habitat newHabitat = new Habitat(id, name, area);
        _habitats.put(id, newHabitat);
        for(String i : idList){
            newHabitat.putTree(_trees.get(i));
        }
        return 0;
    } */

    //Returns a String with all habitats in hotel and corresponding trees
    public String showAllHabitats(){
        String habitatString = "";
        for (Habitat habitat : _habitats.values()){
            habitatString = habitatString + habitat.toString() + "\n";
        }
        if(!habitatString.equals("")){
            habitatString = habitatString.substring(0, habitatString.length() - 1);
        }
        return habitatString;
    }

    //Menu de Gestão de Vacinas
    public int registerVaccine(String id, String name, String speciesIds)
            throws CoreDuplicateVaccineKeyException,
            CoreUnknownSpeciesKeyException{
        if (_vaccines.containsKey(id)) {
            throw new CoreDuplicateVaccineKeyException(id);
        }
        String[] idsArray = speciesIds.split(",");
        for (String speciesId : idsArray){
            if (_species.containsKey(speciesId) == false) {
                throw new CoreUnknownSpeciesKeyException(speciesId);
            }
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
        if(!vaccineString.equals("")){
            vaccineString = vaccineString.substring(0, vaccineString.length() - 1);
        }
        return vaccineString;
    }

    public int registerTree(String id, String name, int age, int difficulty, String type) {
        if(_trees.containsKey(id)){
            //throw DuplicateTreeKeyException
            return -1;
        }
        if(type.equals("CADUCA")){
            Tree newTree = new DeciduousTree(id, name, age, difficulty);
            _trees.put(id, newTree);
            return 0;
        }
        if(type.equals("PERENE")){
            Tree newTree = new EvergreenTree(id, name, age, difficulty);
            _trees.put(id, newTree);
            return 0;
        }
        //FIXME throw some exception for infalid identifier
        return -1;

    }
    

}