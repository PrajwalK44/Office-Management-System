package Model.Project;

import java.util.Scanner;

public class Project {
    Scanner sc = new Scanner(System.in);
    //This is parent class and provides attributes for child
    private static int Project_count;
    //        Here project count is made static as and can be accessed using class name only
    //        It will keep a record of projects
    private  int Project_ID;
    //  This field stores the Project's Id
    private String Project_Name;
    //  This field stores the Project's Name
    private String Project_Start_Date;
    //  This field stores the Project's Start Date

    //        Here Setters and Getters are used to access variables of class
    public static void setProject_count(int project_count) {
        Project_count = project_count;
    }

    public void setProject_Name(String project_Name){
        this.Project_Name = project_Name;
    }

    public  void setProject_ID(int project_ID) {
        this.Project_ID = project_ID;
    }

    public void setProject_Start_Date(String project_Start_Date) {
        this.Project_Start_Date = project_Start_Date;
    }

    public  int getProject_ID() {
        return this.Project_ID;
    }

    public String getProject_Name() {
        return this.Project_Name;
    }

    public static int getProject_count() {
        return Project_count;
    }

    public String getProject_Start_Date() {
        return this.Project_Start_Date;
    }

    //        This is a Default Constructor which is incrementing project count and assigning it to project id
    public Project(){
    }

    //      Here a Parameterized constructor is used were in parameters are passed to differentiate it with other constructors
    //      This is called constructor over-loading

    public Project(int id, String name, String start){
        setProject_count(getProject_count()+1);
        setProject_ID(id);
        setProject_Name(name);
        setProject_Start_Date(start);
    }





}
