package hva;

import hva.animal.Animal;
import hva.animal.Species;
import hva.employee.Caretaker;
import hva.employee.Employee;
import hva.employee.Vet;
import hva.exceptions.*;
import hva.habitat.Habitat;
import hva.tree.DeciduousTree;
import hva.tree.EvergreenTree;
import hva.tree.Tree;
import hva.vaccine.Vaccine;
import java.io.IOException;
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

    private int _fileChanged = 0;


    //FIXME define constructor(s)

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

                    case "HABITAT" -> {if(wordsList.size() == 4) {registerHabitat(wordsList.get(1), wordsList.get(2), Integer.parseInt(wordsList.get(3)));}
                                       /*if(wordsList.size() == 5) {registerHabitat(wordsList.get(1), wordsList.get(2), Integer.parseInt(wordsList.get(3)), wordsList.get(4));*/}

                    case "TRATADOR" -> {if(wordsList.size() == 3) {registerEmployee(wordsList.get(1), wordsList.get(2), "TRT");}
                                        if(wordsList.size() == 4) {/*FIXME implement this function */}}
                                        
                    case "VETERINÁRIO" -> {if(wordsList.size() == 3) {registerEmployee(wordsList.get(1), wordsList.get(2), "VET");}
                                           if(wordsList.size() == 4) {/*FIXME implement this function */}}

                    case "VACINA" -> {if(wordsList.size() == 3) {registerVaccine(wordsList.get(1), wordsList.get(2), "");}
                                      if(wordsList.size() == 4) {registerVaccine(wordsList.get(1), wordsList.get(2), wordsList.get(3));}}

                    case "ÁRVORE" -> registerTree(wordsList.get(1), wordsList.get(2), Integer.parseInt(wordsList.get(3)), Integer.parseInt(wordsList.get(4)), wordsList.get(5));
                    default -> throw new UnrecognizedEntryException(wordsList.get(0));

                }
            }
        } catch (IOException | UnrecognizedEntryException e) {
            throw new ImportFileException(filename, e);}
        catch (Exception e) {} //FIXME isto tem de ir embora ps: deviamos criar uma super classe 
        //para todas as excepções do core para ser mais fácil dar catch aqui

    }

    /**
     * Splits a String of id's separated by a "," character into a List of Strings
     * 
     * @param allIds a String of id's separated by a "," character
     * @return an array of Strings (those separated by a "," character)
    */
    private List<String> splitId(String allIds){
        return(Arrays.asList(allIds.split(",")));
    }

    /**
     * Registers a new Species into the Hotel (puts it into the _species map)
     * 
     * @param id the id of the Species
     * @param name the name of the Species
     * @return an integer indicating the result of the operation
     */
    public int registerSpecies(String id, String name){
        if (_species.containsKey(id)) {
            //DuplicateSpeciesKeyException
            return -1;
        }
        Species newSpecies = new Species(id, name);
        _species.put(id, newSpecies);
        _fileChanged = 1; 
        return 0;
    }

    /**
     * Registers a new Animal into the Hotel (puts it into the _animals map)
     * 
     * @param id the id of the Animal
     * @param name the name of the Animal
     * @param speciesId the id of the Species of the Animal
     * @param habitatId the id of the Habitat of the Animal
     * @return an integer indicating the result of the operation
     */
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
        _fileChanged = 1;
        return 0;
    }

    //FIXME
    /**
     * 
     */
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
        _fileChanged = 1;
        return 0;
    }
    
    /**
     * Returns a String with all animals in hotel
     * 
     * @return a String with all animals in hotel
     */
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

    /**
     * Registers a new employee into the Hotel (puts it into the _employees map)
     * 
     * @param id
     * @param name
     * @param type
     * @return
     * @throws CoreDuplicateEmployeeKeyException
     */
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
        _fileChanged = 1; 
        return 0;
    }
    
    /**
     * Returns a String with all employees in hotel
     * 
     * @return a String with all employees in hotel
     */
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

    /**
     * Registers a new Habitat into the Hotel (puts it into the _habitats map)
     * 
     * @param id the id of the Habitat
     * @param name the name of the Habitat
     * @param area the area of the Habitat
     * @return the result of the operation
     * @throws CoreDuplicateHabitatKeyException
     */
    public int registerHabitat(String id, String name, int area)
            throws CoreDuplicateHabitatKeyException{
        if (_habitats.containsKey(id)) {
            throw new CoreDuplicateHabitatKeyException(id);
        }
        Habitat newHabitat = new Habitat(id, name, area);
        _habitats.put(id, newHabitat);
        _fileChanged = 1;
        return 0;
    }

    /**
     * Registers a new Habitat into the Hotel (puts it into the _habitats map)
     * 
     * @param id the id of the Habitat
     * @param name the name of the Habitat
     * @param area the area of the Habitat
     * @param idTrees the id of the Trees in the Habitat (separated by ",")
     * @return the result of the operation
     * @throws CoreDuplicateHabitatKeyException
     */
    public int registerHabitat(String id, String name, int area, String idTrees) 
            throws CoreUnknownTreeKeyException,
            CoreDuplicateHabitatKeyException{
        List<String> idList = splitId(idTrees);
        for(String i : idList){
            if(!_trees.containsKey(i)){
                throw new CoreUnknownTreeKeyException(i);
            }
        }
        if(_habitats.containsKey(id)){
            throw new CoreDuplicateHabitatKeyException(id);
        }
        Habitat newHabitat = new Habitat(id, name, area);
        _habitats.put(id, newHabitat);
        for(String i : idList){
            newHabitat.putTree(_trees.get(i));
        }
        _fileChanged = 1; 
        return 0;
    } 

    /**
     * Returns a String with all habitats in hotel and corresponding trees
     * 
     * @return a String with all habitats in hotel and corresponding trees
     */
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

    /**
     * Registers a new Vaccine into the Hotel (puts it into the _vaccines map)
     * 
     * @param id the id of the Vaccine
     * @param name the name of the Vaccine
     * @param speciesIds the ids of the Species the Vaccine is for (separated by ",")
     */
    public int registerVaccine(String id, String name, String speciesIds)
            throws CoreDuplicateVaccineKeyException,
            CoreUnknownSpeciesKeyException{
        if (_vaccines.containsKey(id)) {
            throw new CoreDuplicateVaccineKeyException(id);
        }
        if(!speciesIds.equals("")){
            String[] idsArray = speciesIds.split(",");
            for (String speciesId : idsArray){
                if (_species.containsKey(speciesId) == false) {
                    throw new CoreUnknownSpeciesKeyException(speciesId);
                }
            }
        }
        Vaccine newVaccine = new Vaccine(id, name, speciesIds);
        _vaccines.put(id, newVaccine);
        _fileChanged = 1; 
        return 0;
    }

    /**
     * Returns a String with all vaccines in hotel
     * 
     * @return a String with all vaccines in hotel
     */
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

    /**
     * Registers a new Tree into the Hotel (puts it into the _trees map)
     * 
     * @param id the id of the Tree
     * @param name the name of the Tree
     * @param age the age of the Tree  
     * @param difficulty the difficulty of cleaning the Tree
     * @param type the type of the Tree (CADUCA or PERENE)
     * @return the result of the operation
     */
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
        _fileChanged = 1;
        return -1;
    }


    /**
     * Returns current status of the file (saved or not) (in variable _fileChanged)
     * (0-> saved, 1-> not saved)
     * 
     * @return int _fileChanged
     */
    public int getFileChanged(){ 
        return _fileChanged;
    }

    /**
     * Sets the status of the file (saved or not) (in variable _fileChanged)
     * (0-> saved, 1-> not saved)
     * 
     * @param fileChanged
     * @return void
     */
    public void setFileChanged(int fileChanged){
        _fileChanged = fileChanged;
    }

}