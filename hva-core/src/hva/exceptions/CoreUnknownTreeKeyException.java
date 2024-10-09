package hva.exceptions;

public class CoreUnknownTreeKeyException extends Exception{
    String _id = "";

    public CoreUnknownTreeKeyException(String id) {
        _id = id;
    }
}
