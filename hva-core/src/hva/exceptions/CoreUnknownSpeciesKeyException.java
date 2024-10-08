package hva.exceptions;

public class CoreUnknownSpeciesKeyException extends Exception {
    private String _id = "";

    public CoreUnknownSpeciesKeyException(String id) {
        _id = id;
    }

    public String getSpeciesKey() {
        return _id;
    }
}
