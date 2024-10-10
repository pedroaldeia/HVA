package hva.exceptions;

import java.io.Serial;

public class CoreDuplicateAnimalKeyException extends CoreException {

    @Serial
    private static final long serialVersionUID = 202410101152L;

    private String _id = "";

    public CoreDuplicateAnimalKeyException(String id){
        _id = id;
    }

    public String getAnimalKey(){
        return _id;
    }
}
