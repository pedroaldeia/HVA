package hva.search;

import hva.Hotel;
import hva.employee.Vet;
import hva.exceptions.CoreUnknownVeterinarianKeyException;
import hva.vaccine.VaccineApplication;

public class SearchMedicalActsByVeterinarian implements SearchStrategy{

    public SearchMedicalActsByVeterinarian(){}

    @Override
    public String search(Hotel hotel, String id) throws CoreUnknownVeterinarianKeyException{
        
        Vet vet = hotel.getVeterinarian(id);
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
