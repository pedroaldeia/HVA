package hva.vaccine;

import hva.animal.Animal;
import hva.employee.Vet;
import java.io.Serializable;

public class VaccineApplication implements Serializable{
    private Vaccine _vaccine;
    private Vet _vet;
    private Animal _animal;
    private boolean _successful = true; //states if the vaccine was intended for the animal
    private String _status = "NORMAL";

    /**
     * This is the constructor of the VaccineApplication class.
     * 
     * @param vet the vet who administered the vaccine
     * @param animal the animal who received the vaccine
     */
    public VaccineApplication(Vaccine vaccine,Vet vet, Animal animal){
        _vaccine = vaccine;
        _vet = vet;
        _animal = animal;
    }

    public boolean getSuccesfulness(){
        return _successful;
    }

    public void setSuccesfulness(boolean success){
        _successful = success;
    }

    public void setStatus(int damage){
        if(damage == 0){
            if(getSuccesfulness()){
                _status = "NORMAL";
            }
            else{
                _status = "CONFUSÃO";
            }
        }
        else if(damage > 0 && damage < 5){
            _status = "ACIDENTE";
        }
        else{
            _status = "ERRO";
        }
    }
    
    public String getStatus(){
        return _status;
    }
}
