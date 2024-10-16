package hva.employee;

import java.io.Serializable;

public interface SatisfactionCalculator{
    public int visitCaretaker(Caretaker c);
    public int visitVet(Vet v);
}
