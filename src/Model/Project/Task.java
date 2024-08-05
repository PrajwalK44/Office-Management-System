package Model.Project;

public class Task extends Project {
    //This is Child class for Project which can access all the data members and methods of Task

    //  This field stores the Project's Description
    private String Resources;
    //  This field stores the Resources used in Project
    private int Budget;
    //  This field stores the Project's Budget
    private int Hours_Completed;
    //  This field stores the Project's Hours Completed
    //  This field stores the Project's Domain

    //        Here Setters and Getters are used to access variables of class
    public void setResources(String resources) {
        this.Resources = resources;
    }

    public void setBudget(int budget) {
        this.Budget = budget;
    }

    public void setHours_Completed(int hours_Completed) {
        this.Hours_Completed = hours_Completed;
    }

    public String getResources() {
        return this.Resources;
    }
    public int getBudget() {
        return this.Budget;
    }

    public int getHours_Completed() {
        return this.Hours_Completed;
    }
    //        This is a Default Constructor which is calling parent constructor using 'super' keyword
    public Task(){
    }
    //      Here a Parameterized constructor is used were in parameters are passed to differentiate it with other constructors
    //      This is called constructor over-loading
    public Task(int id,String name, String start, int bud, String res, int hrs){
        super(id,name, start );
        setBudget(bud);
        setResources(res);
        setHours_Completed(hrs);
    }
}
