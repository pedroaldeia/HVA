package hva.exceptions;

public class CoreDuplicateEmployeeKeyException extends CoreException{
    private String _id = "";

    public CoreDuplicateEmployeeKeyException(String id) {
        _id = id;
    }

    public String getEmployeeKey(){
        return _id;
    }
}
