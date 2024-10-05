package hva;

import java.util.ArrayList;
import java.util.List;

public class Vaccine {
    private String _name;
    private String _id;
    private int _nApplications;
    private List<Species> _species = new ArrayList();
    private List<VaccineApplication> _record = new ArrayList<>();

    public Vaccine(String name) {
        _name = name;
    }

    public String getId(){
        return _id;
    }

    public String getName() {
        return _name;
    }


    @Override
    public String toString(){
        return "VACINA|" + this.getId() + this.getName() + _nApplications + _species; //FIXME implement show species array
    }
    
    //FIXME Implement addapplication
}
