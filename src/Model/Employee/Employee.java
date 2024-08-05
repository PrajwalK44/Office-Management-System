package Model.Employee;
import java.util.Scanner;
public class Employee extends Person {
    // Employee class is the child class and Person class is Parent class
    Scanner sc = new Scanner(System.in);

    //Some variables are declared private following data encapsulation
    private String Contact_num;
    private int Employee_id;
    private static int employee_count = 0;

    // Setters and Getters are used to access the variables
    public void setEmployee_count(int employee_count) {
        Employee.employee_count = employee_count;
    }

    public int getEmployee_count() {
        return employee_count;
    }

    public void setContact_num(String contact_num) {
        this.Contact_num = contact_num;
    }

    public void setEmployee_id(int employee_id) {
        this.Employee_id = employee_id;
    }

    public String getContact_num() {
        return this.Contact_num;
    }

    public int getEmployee_id() {

        return this.Employee_id;
    }

    //this is the default constructor which has no parameters
    public Employee() {
    }
    //This is parameterized constructor which is being called from main class to carry out set of operations

    public Employee(int id, String name, String position, String dept, String sal, String cont, String lang) {
        //Invoking parent class constructor
        super(name, dept, position, lang, sal);
        setEmployee_count(getEmployee_count() + 1);
        this.setEmployee_id(id);
        setContact_num(cont);
    }
}



