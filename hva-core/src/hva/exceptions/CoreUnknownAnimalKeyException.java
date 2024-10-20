package hva.exceptions;

import java.io.Serial;

public class CoreUnknownAnimalKeyException extends CoreException {
    @Serial
    private static final long serialVersionUID = 202410181951L;

    private String _id = "";

    public CoreUnknownAnimalKeyException(String id) {
        _id = id;
    }

    public String getAnimalKey(){
        return _id;
    }
}
