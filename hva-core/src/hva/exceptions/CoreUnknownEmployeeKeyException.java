package hva.exceptions;

import java.io.Serial;

public class CoreUnknownEmployeeKeyException extends CoreException  {

    @Serial
    private static final long serialVersionUID = 202410131027L;

    private String _id = "";
    
    public CoreUnknownEmployeeKeyException(String id){
        _id = id;
    }

    public String getId(){
        return _id;
    }
}
