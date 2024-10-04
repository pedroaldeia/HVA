package hva;

import java.util.ArrayList;
import java.util.List;

public class Vet extends Employee{
    private List<Species> _responsibilityList = new ArrayList<>();
    // implement addResponsibility and accept
    public Vet(String id, String name) {
        super(id, name);
}
