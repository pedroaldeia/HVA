package hva;

import java.util.ArrayList;
import java.util.List;

public class Vaccine {
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
        return "VACINA|" + this.getId() + "|" + this.getName() + "|" + _nApplications + "|" + _species.toString(); 
        //FIXME implement show species array
    }
    
    //FIXME Implement addApplication
}
