package hva;

public abstract class Employee {
    private String _id;
    private String _name;
    private SatisfactionCalculator _satisfactionCalc;

    public Employee(String id, String name) {
        _id = id;
        _name = name;
    }

    //implement setSatisfactionCalc, getSatisfaction, accept
}
