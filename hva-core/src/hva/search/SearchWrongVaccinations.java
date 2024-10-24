package hva.search;

import hva.Hotel;
import hva.vaccine.VaccineApplication;

public class SearchWrongVaccinations implements SearchStrategy {

    public SearchWrongVaccinations() {}

    @Override
    public String search(Hotel hotel, String nothing){
        String wrongVaccinationsString = "";
        for (VaccineApplication application : hotel.getVaccineApplications()){
            if(!application.getSuccesfulness()){
                wrongVaccinationsString = wrongVaccinationsString + application.toString() + "\n";
            }
        }
        if(!wrongVaccinationsString.equals("")){
            wrongVaccinationsString = wrongVaccinationsString.substring(0, wrongVaccinationsString.length() - 1);
        }
        return wrongVaccinationsString;
    }
}
