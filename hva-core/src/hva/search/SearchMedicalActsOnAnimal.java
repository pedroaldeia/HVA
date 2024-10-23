package hva.search;

import hva.animal.Animal;
import hva.vaccine.VaccineApplication;

public class SearchMedicalActsOnAnimal implements SearchStrategy {

    private Animal _animal;

    public SearchMedicalActsOnAnimal(Animal animal) {
        _animal = animal;
    }

    @Override
    public String search(){
        String record = "";
        for(VaccineApplication application : _animal.getInjuryRecord()){
            record += application.toString() + "\n";
        }
        if(!record.equals("")){
            record = record.substring(0, record.length() - 1);
        }
        return record;
    }
}
