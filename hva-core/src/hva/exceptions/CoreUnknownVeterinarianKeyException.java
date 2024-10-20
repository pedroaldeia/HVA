package hva.exceptions;

import java.io.Serial;

public class CoreUnknownVeterinarianKeyException extends CoreException {
    @Serial
    private static final long serialVersionUID = 202410181959L;

    private String _id = "";

    public CoreUnknownVeterinarianKeyException(String id) {
        _id = id;
    }

    public String getVetKey(){
        return _id;
    }
}
