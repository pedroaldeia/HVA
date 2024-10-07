package hva;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Vaccine implements Serializable{
    private String _name;
    private String _id;
    private int _nApplications = 0;
    private List<String> _species = new ArrayList<String>();
    private List<VaccineApplication> _record = new ArrayList<>();

    public Vaccine(String id, String name, List<String> speciesIds) {
        _name = name;
        _id = id;
        _species = speciesIds;
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
        for(String s : _species){
            sString = sString + s + ",";
        }
        if(!sString.equals("")){
            sString = sString.substring(0, sString.length() - 2);
        }
        return sString;
    }
    
    //FIXME Implement addApplication
}
