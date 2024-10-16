package hva.vaccine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vaccine implements Serializable{
    private String _name;
    private String _id;
    private int _nApplications = 0;
    private List<String> _speciesIds = new ArrayList<>();
    private List<VaccineApplication> _record = new ArrayList<>();

    /**
     * This is the constructor of the Vaccine class.
     * 
     * @param id the unique identifier of the vaccine
     * @param name the name of the vaccine
     * @param speciesIds a string of comma-separated species IDs this vaccine is meant 
     * for
     */
    /*
    public Vaccine(String id, String name, String speciesIds) {
        _name = name;
        _id = id;
        //_speciesIds = speciesIds.replaceAll("\\s", "");
    } //FIXME idk if this function is needed or not
    */
    public Vaccine(String id, String name, String[] speciesIds) {
        _name = name;
        _id = id;
        addSpecies(speciesIds);
    }
    /**
     * This method returns the unique identifier of the vaccine.
     * 
     * @return _id the unique identifier of the vaccine
     */
    public String getId(){
        return _id;
    }

    /**
     * This method returns the name of the vaccine.
     * 
     * @return _name the name of the vaccine
     */
    public String getName() {
        return _name;
    }

    /**
     * This method returns the details of the Vaccine.
     * 
     * @return a string with the details of the vaccine
     */
    @Override
    public String toString(){
        if(_speciesIds.equals("")){
            return "VACINA|" + this.getId() + "|" + this.getName() + "|" + _nApplications; 
        }
        return "VACINA|" + this.getId() + "|" + this.getName() + "|" + _nApplications + 
          "|" + speciesToString(); 
    }

    public String speciesToString(){
        String out = "";
        for(String id : _speciesIds){
            out += id + ",";
        }
        return out.substring(0, out.length()-1);
    }

    private void addSpecies(String[] species){
        for(String id : species){
            _speciesIds.add(id);
        }
    }
    //FIXME Implement addApplication
}
