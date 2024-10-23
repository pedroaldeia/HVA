package hva.search;

import hva.animal.Animal;
import hva.employee.Vet;
import hva.vaccine.VaccineApplication;

public class SearchMedicalActsByVeterinarian implements SearchStrategy{

    private Vet _vet;

    public SearchMedicalActsByVeterinarian(Vet vet){
        _vet = vet;
    }

    @Override
    public String search(){
        String record = "";
        for(VaccineApplication application : _vet.getVaccineApplications()){
            record += application.toString() + "\n";
        }
        if(!record.equals("")){
            record = record.substring(0, record.length() - 1);
        }
        return record;
    }
}
