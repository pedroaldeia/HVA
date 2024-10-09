package hva.vaccine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vaccine implements Serializable{
    private String _name;
    private String _id;
    private int _nApplications = 0;
    private String _speciesIds = "";
    private List<VaccineApplication> _record = new ArrayList<>();

    public Vaccine(String id, String name, String speciesIds) {
        _name = name;
        _id = id;
        _speciesIds = speciesIds.replaceAll("\\s", "");
    }

    public String getId(){
        return _id;
    }

    public String getName() {
        return _name;
    }


    @Override
    public String toString(){
        return "VACINA|" + this.getId() + "|" + this.getName() + "|" + _nApplications + "|" + _speciesIds; 
    }

    
    //FIXME Implement addApplication
}
