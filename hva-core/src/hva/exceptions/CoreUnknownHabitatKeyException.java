package hva.exceptions;

public class CoreUnknownHabitatKeyException extends CoreException{
    private String _id = "";

    public CoreUnknownHabitatKeyException(String id){
        _id = id;
    }
    
    public String getHabitatKey(){
        return _id;
    }
}
