package hva.exceptions;

import java.io.Serial;

public class CoreNoResponsibilityException extends CoreException  {
    @Serial
    private static final long serialVersionUID = 202410131123L;

    private String _employeeKey = "";
    private String _responsibilityKey = "";

    public CoreNoResponsibilityException(String employeeKey, String responsibilityKey) {
        _employeeKey = employeeKey;
        _responsibilityKey = responsibilityKey;
    }

    public String getEmployeeId() {
        return _employeeKey;
    }

    public String getResponsibilityId() {
        return _responsibilityKey;
    }
}
