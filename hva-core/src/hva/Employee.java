package hva;

import java.io.Serializable;

public abstract class Employee implements Serializable{
    protected String _id; //switched to protected to be able to access through classes Vet and Caretaker
    protected String _name;
    //private SatisfactionCalculator _satisfactionCalc;

    public Employee(String id, String name) {
        _id = id;
        _name = name;

    }


    //implement setSatisfactionCalc, getSatisfaction, accept
}
