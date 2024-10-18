package hva.exceptions;

import java.io.Serial;

public class CoreVeterinarianNotAuthorizedException extends CoreException  {
    @Serial
    private static final long serialVersionUID = 202410182001L;

    private String _vetId = "";
    private String _speciesId = "";

    public CoreVeterinarianNotAuthorizedException(String vetId, String speciesId) {
        _vetId = vetId;
        _speciesId = speciesId;
    }

    public String getVetKey(){
        return _vetId;
    }

    public String getSpecieskey(){
        return _speciesId;
    }
}
