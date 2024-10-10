package hva.exceptions;

public class CoreUnknownTreeKeyException extends CoreException{
    String _id = "";

    public CoreUnknownTreeKeyException(String id) {
        _id = id;
    }
}
