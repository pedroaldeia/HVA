package hva.exceptions;

import java.io.Serial;

public class CoreUnknownSpeciesKeyException extends CoreException {

    @Serial
    private static final long serialVersionUID = 202410101158L;

    private String _id = "";

    public CoreUnknownSpeciesKeyException(String id) {
        _id = id;
    }

    public String getSpeciesKey() {
        return _id;
    }
}
