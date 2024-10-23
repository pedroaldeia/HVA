package hva.search;

import hva.Hotel;
import hva.vaccine.VaccineApplication;
import org.w3c.dom.html.HTMLOListElement;
import org.w3c.dom.html.HTMLOListElement;

public class SearchWrongVaccinations implements SearchStrategy {
    private Hotel _hotel;

    public SearchWrongVaccinations(Hotel hotel) {
        _hotel = hotel;
    }

    @Override
    public String search() {
        String wrongVaccinationsString = "";
        for (VaccineApplication application : _hotel.getVaccineApplications()){
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
