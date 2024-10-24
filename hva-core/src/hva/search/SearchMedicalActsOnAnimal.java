package hva.search;

import hva.Hotel;
import hva.animal.Animal;
import hva.exceptions.CoreUnknownAnimalKeyException;
import hva.vaccine.VaccineApplication;

public class SearchMedicalActsOnAnimal implements SearchStrategy {

    public SearchMedicalActsOnAnimal() {}

    @Override
    public String search(Hotel hotel, String id) throws CoreUnknownAnimalKeyException{
        Animal animal = hotel.getAnimal(id);
        String record = "";
        for(VaccineApplication application : animal.getInjuryRecord()){
            record += application.toString() + "\n";
        }
        if(!record.equals("")){
            record = record.substring(0, record.length() - 1);
        }
        return record;
    }
}
