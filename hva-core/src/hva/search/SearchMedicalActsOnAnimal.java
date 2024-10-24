package hva.search;

import hva.animal.Animal;
import hva.vaccine.VaccineApplication;

public class SearchMedicalActsOnAnimal implements SearchAnimal {

    public SearchMedicalActsOnAnimal() {}

    @Override
    public String search(Animal animal){
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
