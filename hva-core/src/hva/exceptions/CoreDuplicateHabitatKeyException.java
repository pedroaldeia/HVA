package hva.exceptions;

public class CoreDuplicateHabitatKeyException extends Exception {
    private String _id = "";

    public CoreDuplicateHabitatKeyException(String id) {
        _id = id;
    }

    public String getHabitatKey(){
        return _id;
    }
    
}
