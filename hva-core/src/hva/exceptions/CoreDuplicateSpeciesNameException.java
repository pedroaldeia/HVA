package hva.exceptions;

import java.io.Serial;

public class CoreDuplicateSpeciesNameException extends CoreException{
    
    @Serial
    private static final long serialVersionUID = 202410231226L;

    private String _name = "";

    public CoreDuplicateSpeciesNameException(String name) {
        _name = name;
    }

    public String getSpeciesName(){
        return _name;
    }
}
