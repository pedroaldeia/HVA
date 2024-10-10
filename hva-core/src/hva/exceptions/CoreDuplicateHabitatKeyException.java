package hva.exceptions;

import java.io.Serial;

public class CoreDuplicateHabitatKeyException extends CoreException {

    @Serial
    private static final long serialVersionUID = 202410101154L;

    private String _id = "";

    public CoreDuplicateHabitatKeyException(String id) {
        _id = id;
    }

    public String getHabitatKey(){
        return _id;
    }
    
}
