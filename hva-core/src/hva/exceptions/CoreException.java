package hva.exceptions;

import java.io.Serial;
import java.io.Serializable;

public abstract class CoreException extends Exception implements Serializable  {

    @Serial
    private static final long serialVersionUID = 202410101156L;
    // Constructors defined in the subclasses
}
