package hva.exceptions;

import java.io.Serial;

public class CoreDuplicateTreeKeyException extends CoreException{
    @Serial
    private static final long serialVersionUID = 202410101155L;

    private String _id = "";

    public CoreDuplicateTreeKeyException(String id){
        _id = id;
    }
    
    public String getTreeKey(){
        return _id;
    }
}
