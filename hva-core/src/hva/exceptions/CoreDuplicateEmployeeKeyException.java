package hva.exceptions;

import java.io.Serial;

public class CoreDuplicateEmployeeKeyException extends CoreException{

    @Serial
    private static final long serialVersionUID = 202410101153L;

    private String _id = "";

    public CoreDuplicateEmployeeKeyException(String id) {
        _id = id;
    }

    public String getEmployeeKey(){
        return _id;
    }
}
