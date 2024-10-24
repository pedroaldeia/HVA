package hva.search;

import hva.employee.Vet;
import hva.vaccine.VaccineApplication;

public class SearchMedicalActsByVeterinarian implements SearchVet{

    public SearchMedicalActsByVeterinarian(){}

    @Override
    public String search(Vet vet){
        String record = "";
        for(VaccineApplication application : vet.getVaccineApplications()){
            record += application.toString() + "\n";
        }
        if(!record.equals("")){
            record = record.substring(0, record.length() - 1);
        }
        return record;
    }
}
