package hva.search;

import hva.Hotel;
import hva.exceptions.CoreException;
import hva.exceptions.CoreUnknownVaccineKeyException;
import hva.vaccine.VaccineApplication;

public class SearchWrongVaccinations implements SearchStrategy {

    public SearchWrongVaccinations() {}

    @Override
    public String search(Hotel hotel, String nothing) throws CoreException{
        String wrongVaccinationsString = "";
        for (VaccineApplication application : hotel.getVaccineApplications()){
            if(!application.getSuccesfulness()){
                wrongVaccinationsString = wrongVaccinationsString + application.toString() + "\n";
            }
        }
        if(!wrongVaccinationsString.equals("")){
            wrongVaccinationsString = wrongVaccinationsString.substring(0, wrongVaccinationsString.length() - 1);
        }
        if(false) {throw new CoreUnknownVaccineKeyException("");}
        return wrongVaccinationsString;
    }
}
