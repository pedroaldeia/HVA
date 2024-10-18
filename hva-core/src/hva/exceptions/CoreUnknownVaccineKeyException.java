package hva.exceptions;

import java.io.Serial;

public class CoreUnknownVaccineKeyException extends CoreException{
    @Serial
    private static final long serialVersionUID = 202410181952L;

    private String _id = "";

    public CoreUnknownVaccineKeyException(String id) {
        _id = id;
    }

    public String getVaccineKey(){
        return _id;
    }
    
}
