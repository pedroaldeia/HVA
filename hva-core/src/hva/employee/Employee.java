package hva.employee;

import java.io.Serializable;

public abstract class Employee implements Serializable{
    private String _id; 
    private String _name;
    private String _type; //VET or TRT

    /**
     * This is the constructor of the Employee class.
     * 
     * @param id the id of the employee
     * @param name the name of the employee
     */
    public Employee(String id, String name, String type) {
        _id = id;
        _name = name;
        _type = type;
    }

    public String getType(){
        return _type;
    }
    //implement setSatisfactionCalc, getSatisfaction, accept
    public abstract double accept(SatisfactionCalculator sc);

    public String getId(){
        return _id;
    }

    public String getName(){
        return _name;
    }
}
