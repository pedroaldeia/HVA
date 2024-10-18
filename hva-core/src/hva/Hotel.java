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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Hotel implements Serializable {

    //FIXME adicionar javadoc
    private Map<String, Habitat> _habitats = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private Map<String, Employee> _employees = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private Map<String, Vaccine> _vaccines = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private Map<String, Species> _species = new HashMap<>();
    private Map<String, Animal> _animals = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private Map<String, Tree> _trees = new HashMap<>();

    public Hotel(){};    
    
    @Serial
    private static final long serialVersionUID = 202407081733L;
    
    private boolean _fileChanged = false;
    
    
    /**
     * Read text input file and create domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    void importFile(String filename) throws ImportFileException{ 
    BufferedReader reader;    
	try {
            // Read the first line from the file
            //List<String> file = Files.readAllLines(Paths.get(filename));

            reader = new BufferedReader(new FileReader(filename));

            String line = reader.readLine();

            // Split the line
            while (line != null){
                //System.out.println(line);
                List<String> wordsList = Arrays.asList(line.split("\\|"));
                switch(wordsList.get(0)){
                    case "ANIMAL" -> registerAnimal(wordsList.get(1), wordsList.get(2), 
                                      wordsList.get(3), wordsList.get(4));

                    case "ESPÉCIE" -> registerSpecies(wordsList.get(1), 
                                        wordsList.get(2));

                    case "HABITAT" -> {if(wordsList.size() == 4) {registerHabitat(
                                        wordsList.get(1), wordsList.get(2), 
                                        Integer.parseInt(wordsList.get(3)), "");}
                                       if(wordsList.size() == 5) {registerHabitat(
                                        wordsList.get(1), wordsList.get(2),
                                         Integer.parseInt(wordsList.get(3)), 
                                         wordsList.get(4));}}

                    case "TRATADOR" -> {if(wordsList.size() == 3) {registerEmployee(
                                        wordsList.get(1), wordsList.get(2), "TRT");}
                                        if(wordsList.size() == 4) {registerEmployee(
                                        wordsList.get(1), wordsList.get(2), "TRT", wordsList.get(3));}}
                                        
                    case "VETERINÁRIO" -> {if(wordsList.size() == 3) {registerEmployee(
                                           wordsList.get(1), wordsList.get(2), "VET");}
                                           if(wordsList.size() == 4) {registerEmployee(
                                            wordsList.get(1), wordsList.get(2), "VET", wordsList.get(3));}}

                    case "VACINA" -> {if(wordsList.size() == 3) {registerVaccine(
                                        wordsList.get(1), wordsList.get(2), "");}
                                      if(wordsList.size() == 4) {registerVaccine(
                                        wordsList.get(1), wordsList.get(2), 
                                        wordsList.get(3));}}

                    case "ÁRVORE" -> addTree(wordsList.get(1), wordsList.get(2), 
                                      Integer.parseInt(wordsList.get(3)), 
                                      Integer.parseInt(wordsList.get(4)), 
                                      wordsList.get(5));
                    default -> throw new UnrecognizedEntryException(wordsList.get(0));
                }
                line = reader.readLine();
            }
        } catch (IOException | UnrecognizedEntryException e) {
            throw new ImportFileException(filename, e);
        } catch (CoreException e) {e.printStackTrace();}


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
        _fileChanged = true; 
        return 0;
    }

    private Species getSpecies(String id) throws CoreUnknownSpeciesKeyException  {
        Species species = _species.get(id);
        if(species == null) {
            throw new CoreUnknownSpeciesKeyException(id);
        }
        return species;
    }

    public boolean speciesAlreadyExists(String id){
        return _species.containsKey(id);
    }
    public boolean animalAlreadyExists(String id){
        return _animals.containsKey(id);
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
    public void registerAnimal(String id, String name, 
            String speciesId, String habitatId) 
            throws CoreDuplicateAnimalKeyException,
            CoreUnknownHabitatKeyException{

        if (animalAlreadyExists(id)){
            throw new CoreDuplicateAnimalKeyException(id);
        }
        Species species = _species.get(speciesId);
        Habitat habitat = _habitats.get(habitatId);
        if (habitat == null) {
            throw new CoreUnknownHabitatKeyException(habitatId);
        }
        Animal newAnimal = new Animal(id, name, species, habitat);
        _animals.put(id, newAnimal);
        //habitat.getAnimalMap().put(id, newAnimal);
        _fileChanged = true;
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

    public boolean isValidEmployeeType(String type){
        return type.equals("TRT") || type.equals("VET");
    }

    /**
     * Registers a new employee into the Hotel (puts it into the _employees map)
     * 
     * @param id
     * @param name
     * @param type
     * @throws CoreDuplicateEmployeeKeyException
     *@returns true if suceeded, false otherwise
     */
    public boolean registerEmployee(String id, String name, String type, String idResponsibility)
            throws CoreDuplicateEmployeeKeyException, CoreUnknownHabitatKeyException, 
            CoreUnknownSpeciesKeyException, CoreUnknownEmployeeKeyException, CoreNoResponsibilityException{

        if (_employees.containsKey(id)) {
            throw new CoreDuplicateEmployeeKeyException(id);
        }
        Employee newEmployee;
        List<String> idList = splitId(idResponsibility);

        if (type.equals("TRT")){
            newEmployee = new Caretaker(id, name);
            if (!idResponsibility.equals("")){
                for(String i : idList){
                    if(!_habitats.containsKey(i)){
                        throw new CoreUnknownHabitatKeyException(i);
                    }
                }
            }
        }
        else if(type.equals("VET")){ 
            newEmployee = new Vet(id, name);
            if (!idResponsibility.equals("")){
                for(String i : idList){
                    if(!_species.containsKey(i)){
                        throw new CoreUnknownSpeciesKeyException(i);
                    }
                }
            }
        }
        else return false;
        _employees.put(id, newEmployee);

        try {
            if(!idResponsibility.equals("")){
                for(String i : idList){
                addResponsibility(id, i);
            }
        }
        } catch (CoreUnknownEmployeeKeyException e) {
            throw e;
        }
        catch (CoreNoResponsibilityException e) {
            throw e; 
            //nao sei como mandar o id da responsabilidade aqui
        }
        
        _fileChanged = true; 
        return true;
    }

    public boolean registerEmployee(String id, String name, String type) throws 
        CoreUnknownEmployeeKeyException, CoreNoResponsibilityException, 
        CoreUnknownHabitatKeyException,CoreUnknownSpeciesKeyException, 
        CoreDuplicateEmployeeKeyException{
        try {
           return registerEmployee(id, name, type, ""); 
        }  
        catch (CoreUnknownEmployeeKeyException e) {throw e;}
        catch (CoreNoResponsibilityException e) {throw e; }
        catch (CoreUnknownHabitatKeyException e) {throw e; }
        catch (CoreUnknownSpeciesKeyException e) {throw e; }
        catch (CoreDuplicateEmployeeKeyException e) {throw e; }
        
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
     * Returns the Employee with the given id
     * 
     * @param id
     * @return employee with the given id, or null if not found
     */
    private Employee getEmployee(String id) throws CoreUnknownEmployeeKeyException {
        Employee employee = _employees.get(id);
        if(employee == null){
            throw new CoreUnknownEmployeeKeyException(id);
        }
        return employee;
    }

    public void addResponsibility(String employeeId, String responsibilityId) throws 
                                    CoreUnknownEmployeeKeyException, 
                                    CoreNoResponsibilityException, IllegalArgumentException
                                    {
        try {
            Employee employee = getEmployee(employeeId);
            String type = employee.getType();
            if(type.equals("VET")){
                Vet vet = (Vet) employee;
                if(vet.getResponsibility(responsibilityId) == null){
                    Species species = getSpecies(responsibilityId);
                    vet.addResponsibility(species);
                    species.addVetsNum();
                }
            }
            else if(type.equals("TRT")){
                Caretaker caretaker = (Caretaker) employee;
                if(caretaker.getResponsibility(responsibilityId) == null){
                    Habitat habitat = getHabitat(responsibilityId);
                    caretaker.addResponsibility(habitat);
                    habitat.addCaretakersNum();
                }
            }
            else throw new IllegalArgumentException("Invalid employee type");
        }
        catch (CoreUnknownEmployeeKeyException e) {
            throw e;
        }
        catch (CoreUnknownSpeciesKeyException e) {
            throw new CoreNoResponsibilityException(employeeId, responsibilityId);
        }
        catch (CoreUnknownHabitatKeyException e) {
            throw new CoreNoResponsibilityException(employeeId, responsibilityId);
        }
    }

    public void removeResponsibility(String employeeId, String responsibilityId) throws 
        CoreUnknownEmployeeKeyException, CoreNoResponsibilityException{
        try {
            Employee employee = getEmployee(employeeId);
            if(employee.getType().equals("VET")){
                Vet vet = (Vet) employee;
                if(vet.getResponsibility(responsibilityId) != null){
                vet.removeResponsibility(responsibilityId);
                }
                else{
                    throw new CoreNoResponsibilityException(employeeId, responsibilityId);
                }
            }
            else{
                Caretaker caretaker = (Caretaker) employee;
                caretaker.removeResponsibility(responsibilityId);
            }
        }
        catch (CoreUnknownEmployeeKeyException e) {
            throw e;
        }
        catch (CoreUnknownSpeciesKeyException e) {
            throw new CoreNoResponsibilityException(employeeId, responsibilityId);
        }
        catch (CoreUnknownHabitatKeyException e) {
            throw new CoreNoResponsibilityException(employeeId, responsibilityId);
        }
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
    public void registerHabitat(String id, String name, int area, String idTrees) 
                                    throws CoreUnknownTreeKeyException,
                                    CoreDuplicateHabitatKeyException{
        if(habitatAlreadyExists(id)){
            throw new CoreDuplicateHabitatKeyException(id);
        }
        List<String> idList = new ArrayList<String>();
        if (!idTrees.equals("")){
            idList = splitId(idTrees);
            for(String i : idList){
                if(!_trees.containsKey(i)){
                    throw new CoreUnknownTreeKeyException(i);
                }
            }
        }
        Habitat newHabitat = new Habitat(id, name, area);
        _habitats.put(id, newHabitat);
        for(String i : idList){
            newHabitat.putTree(_trees.get(i));
        }
        _fileChanged = true; 
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

    private Habitat getHabitat(String id) throws CoreUnknownHabitatKeyException {
        Habitat habitat = _habitats.get(id);
        if(habitat == null){
            throw new CoreUnknownHabitatKeyException(id);
        }
        return habitat;
    }

    public void changeHabitatArea(String id, String area) 
            throws CoreUnknownHabitatKeyException {
        int intArea = Integer.parseInt(area);
        getHabitat(id).setArea(intArea);
    }

    public boolean isValidTreeType(String type){
        return type.equals("PERENE") || type.equals("CADUCA");
    }

    public boolean treeAlreadyExists(String id){
        return _trees.containsKey(id);
    }

    public boolean habitatAlreadyExists(String id){
            return _habitats.containsKey(id);
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
    public void addTree(String id, String name, int age, 
            int difficulty, String type) 
            throws CoreDuplicateTreeKeyException{
        if(treeAlreadyExists(id)){
            throw new CoreDuplicateTreeKeyException(id);
        }
        if(type.equals("CADUCA")){
            Tree newTree = new DeciduousTree(id, name, age, difficulty);
            _trees.put(id, newTree);
        }
        else if(type.equals("PERENE")){
            Tree newTree = new EvergreenTree(id, name, age, difficulty);
            _trees.put(id, newTree);
        }
        else {
            throw new IllegalArgumentException("Invalid tree type");
        }
        _fileChanged = true;
    }

    public Tree getTree(String id) { return _trees.get(id);}
    public void plantTree(String habitatId, String id, String name, 
                            int age, int dif, String type)
                            throws CoreUnknownHabitatKeyException,
                            IllegalArgumentException{
        Habitat h = getHabitat(habitatId);
        if (h == null) {
            throw new CoreUnknownHabitatKeyException(habitatId);
        }
        Tree tree = getTree(id);
        h.putTree(tree);
        _fileChanged = true;
    } 

    public void registerTree(String habitatId, String id, String name, 
                                String age, String dif, String type)
                                throws CoreUnknownHabitatKeyException,
                                CoreDuplicateTreeKeyException,
                                IllegalArgumentException{
        int intAge = Integer.parseInt(age);
        int intDif = Integer.parseInt(dif);
        addTree(id, name, intAge, intDif, type);
        plantTree(habitatId, id, name, intAge, intDif, type);
    }
                                
    public String showAllHabitatTrees(String id)
            throws CoreUnknownHabitatKeyException{
        Habitat h = getHabitat(id);
        return h.showAllTrees();
    }

    public boolean isValidInfluence(String inf){
        return inf.equals("POS") || inf.equals("NEG") || inf.equals("NEU");
    }

    public void setHabitatInfluence(String habitatId, String speciesId, String influence)
                throws IllegalArgumentException,
                CoreUnknownHabitatKeyException,
                CoreUnknownSpeciesKeyException{
        Habitat h = getHabitat(habitatId);
        if (!speciesAlreadyExists(speciesId)){
            throw new CoreUnknownSpeciesKeyException(speciesId);
        }
        int i = 0;
        if (influence.equals("POS")){i = 1;}
        else if (influence.equals("NEG")){i = -1;}
        else if (influence.equals("NEU")){i = 0;}
        else{
            throw new IllegalArgumentException("Invalid influence");
        }
        h.getInfluenceMap().put(speciesId, i); 
        _fileChanged = true;
    }

    /**
     * Registers a new Vaccine into the Hotel (puts it into the _vaccines map)
     * 
     * @param id the id of the Vaccine
     * @param name the name of the Vaccine
     * @param speciesIds the ids of the Species the Vaccine is for (separated by ",")
     */
    public void registerVaccine(String id, String name, String speciesIds)
            throws CoreDuplicateVaccineKeyException,
            CoreUnknownSpeciesKeyException{
        if (_vaccines.containsKey(id)) {
            throw new CoreDuplicateVaccineKeyException(id);
        }
        String[] idsArray = speciesIds.split(",");
        List<Species> speciesArray = new ArrayList<>();
        if(!speciesIds.equals("")){
            for (String speciesId : idsArray){
                Species species = _species.get(speciesId);
                if (species == null) {
                    throw new CoreUnknownSpeciesKeyException(speciesId);
                }
                speciesArray.add(species);
            }
        }
        if(speciesIds.equals("")){
            speciesArray = null;
        }
        Vaccine newVaccine = new Vaccine(id, name, speciesArray);
        _vaccines.put(id, newVaccine);
        _fileChanged = true; 
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

    public void vaccinateAnimal(String vaccineId, String animalId, String vetId){
        Vaccine vaccine = _vaccines.get(vaccineId);
        Animal animal = _animals.get(animalId);
        Vet vet = (Vet) _employees.get(vetId);
        if(vaccine!= null && animal!= null){
            vaccine.vaccinateAnimal(vet, animal);
            _fileChanged = true;
        }
    }


    /**
     * Returns current status of the file (saved or not) (in variable _fileChanged)
     * (0-> saved, 1-> not saved)
     * 
     * @return int _fileChanged
     */
    public boolean getFileChanged(){ 
        return _fileChanged;
    }

    /**
     * Sets the status of the file (saved or not) (in variable _fileChanged)
     * (0-> saved, 1-> not saved)
     * 
     * @param fileChanged
     * @return void
     */
    public void setFileChanged(boolean fileChanged){
        _fileChanged = fileChanged;
    }
}