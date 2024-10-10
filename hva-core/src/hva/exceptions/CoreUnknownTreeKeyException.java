package hva.exceptions;

import java.io.Serial;

public class CoreUnknownTreeKeyException extends CoreException{

    @Serial
    private static final long serialVersionUID = 202410101159L;

    String _id = "";

    public CoreUnknownTreeKeyException(String id) {
        _id = id;
    }
}
