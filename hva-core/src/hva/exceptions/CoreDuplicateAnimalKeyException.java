package hva.exceptions;

public class CoreDuplicateAnimalKeyException extends CoreException {
    private String _id = "";

    public CoreDuplicateAnimalKeyException(String id){
        _id = id;
    }

    public String getAnimalKey(){
        return _id;
    }
}
