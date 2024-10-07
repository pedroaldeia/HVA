package hva;

import java.util.ArrayList;
import java.util.List;

public class Vaccine {
    private String _name;
    private String _id;
    private int _nApplications = 0;
    private List<Species> _species = new ArrayList<>();
    private List<VaccineApplication> _record = new ArrayList<>();

    public Vaccine(String id, String name, List<Species> species) {
        _name = name;
        _id = id;
        _species = species;
    }

    public String getId(){
        return _id;
    }

    public String getName() {
        return _name;
    }


    @Override
    public String toString(){
        return "VACINA|" + this.getId() + "|" + this.getName() + "|" + _nApplications + "|" + speciesString(); 
    }

    private String speciesString(){
        String sString = "";
        for(Species s : _species){
            sString = sString + s.getId() + ",";
        }
        if(!sString.equals("")){
            sString = sString.substring(0, sString.length() - 2);
        }
        return sString;
    }
    
    //FIXME Implement addApplication
}
