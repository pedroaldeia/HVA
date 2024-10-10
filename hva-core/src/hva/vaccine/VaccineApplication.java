package hva.vaccine;

import hva.animal.Animal;
import hva.employee.Vet;
import java.io.Serializable;

public class VaccineApplication implements Serializable{
    private Vet _vet;
    private Animal _animal;

    /**
     * This is the constructor of the VaccineApplication class.
     * 
     * @param vet the vet who administered the vaccine
     * @param animal the animal who received the vaccine
     */
    public VaccineApplication(Vet vet, Animal animal){
        _vet = vet;
        _animal = animal;
    }
}
