package hva.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

public class DuplicateSpeciesNameException extends CommandException{
    @Serial
    private static final long serialVersionUID = 202410231226L;

    public DuplicateSpeciesNameException(String id) {
        super("A espécie " + id + " já existe."  );
    }

}
