package hva.exceptions;

import java.io.Serial;

public class CoreUnknownHabitatKeyException extends CoreException{

    @Serial
    private static final long serialVersionUID = 202410101157L;

    private String _id = "";

    public CoreUnknownHabitatKeyException(String id){
        _id = id;
    }
    
    public String getHabitatKey(){
        return _id;
    }
}
