package hva;

import java.io.Serializable;

public class VaccineApplication implements Serializable{
    private Vet _vet;
    private Animal _animal;

    public VaccineApplication(Vet vet, Animal animal){
        _vet = vet;
        _animal = animal;
    }
}
