package hva.exceptions;

import java.io.Serial;

public class CoreDuplicateVaccineKeyException extends CoreException {

    @Serial
    private static final long serialVersionUID = 202410101155L;

    private String _id = "";

    public CoreDuplicateVaccineKeyException(String id){
        _id = id;
    }
    
    public String getVaccineKey(){
        return _id;
    }
}
