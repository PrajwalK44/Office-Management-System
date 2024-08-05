package Model.Employee;

public class Person {
    private String name;
    private String position;
    private String dept;
    private String lang;
    private String salary;
    public Person() {
    }

    public Person(String name, String position, String dept, String lang, String salary) {
        this.setName(name);
        this.setPosition(position);
        this.setDept(dept);
        this.setLang(lang);
        this.setSalary(salary);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public String getDept() {
        return this.dept;
    }

    public String getLang() {
        return this.lang;
    }

    public String getSalary() {
        return this.salary;
    }
}
