package Model.Handles;
//This is a class which involves both Employee and Task class common attributes
// which are stored with their data values in  a json file.
import Model.Employee.Employee;
import Model.Project.Task;

public class Handles {
    //Creating instances of Employee and Task class
    Employee e_temp;
    Task t_temp;
    //Declaration of attributes
    private int man_hours_completed;
    private String task_assigned;
    //Setters and getters for above 4 data entities
    public void setE_temp(Employee e_temp) {
        this.e_temp = e_temp;
    }
    public void setT_temp(Task t_temp) {
        this.t_temp = t_temp;
    }
    public void setMan_hours_completed(int man_hours_completed) {
        this.man_hours_completed = man_hours_completed;
    }
    public void setTask_assigned(String task_assigned) {
        this.task_assigned = task_assigned;
    }
    public Employee getE_temp() {
        return e_temp;
    }
    public Task getT_temp() {
        return t_temp;
    }
    public int getMan_hours_completed() {
        return this.man_hours_completed;
    }
    public String getTask_assigned() {
        return this.task_assigned;
    }
    //Creation of a constructor to initialize variables present as parameter whenever an
    //object of "Handles" class is created.

    public Handles (Employee e_temp, Task t_temp, int man_hours_completed, String task_assigned){
        setE_temp(e_temp);
        setT_temp(t_temp);
        setTask_assigned(task_assigned);
        setMan_hours_completed(man_hours_completed);
    }

}
