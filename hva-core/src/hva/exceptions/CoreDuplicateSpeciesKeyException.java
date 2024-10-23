package hva.exceptions;


import java.io.Serial;

public class CoreDuplicateSpeciesKeyException extends CoreException{

    @Serial
    private static final long serialVersionUID = 202410231612L;

    private String _id = "";

    public CoreDuplicateSpeciesKeyException(String id) {
        _id = id;
    }

    public String getSpeciesKey(){
        return _id;
    }
}