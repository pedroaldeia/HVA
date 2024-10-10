package hva.exceptions;

public class CoreDuplicateVaccineKeyException extends CoreException {
    private String _id = "";

    public CoreDuplicateVaccineKeyException(String id){
        _id = id;
    }
    
    public String getVaccineKey(){
        return _id;
    }
}
