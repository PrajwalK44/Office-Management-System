package Model.Handles;

import Model.Displayable;
import Model.Employee.Employee;
import Model.Employee.manageEmployee;
import Model.Project.Task;
import Model.Project.manageProject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class manageHandles extends FileHandlingHandles implements Displayable {
    //Arraylist for Employee, Task and Handles
    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Task> tasks = new ArrayList<Task>();
    ArrayList<Handles> handles = new ArrayList<Handles>();
    // use of object Mapper is done to convert java objects to and from json format
    ObjectMapper objectMapper = new ObjectMapper();
    //use of HashMapping to store keywords and their respective values as a pair
    ArrayList<Map<String, Object>> handle_data = new ArrayList<>();
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    Employee e_o = null;
    Task t_0 = null;
    String path = "src/Model/Handles/Handles.json";
    //Creation of constructor in which objects of manageEmployee and manageProjects are crated.
    public manageHandles(){
        manageEmployee me1 = new manageEmployee();
        employees = me1.readEmployeeJsonFile("src/Model/Employee/Employee.json");
        manageProject mt1 = new manageProject();
        tasks = mt1.readProjectjsonfile("src/Model/Project/Project.json");
        readHandlesJsonFile(path);
    }
    //implementation of the function "readHandlesJsonFile".
    public ArrayList<Handles>  readHandlesJsonFile(String file_path){
        handles.removeAll(handles);
        try{
            JsonNode rootNode = objectMapper.readTree(new File(file_path));
            if (rootNode.isArray()){
                for(JsonNode node : rootNode){
                    Employee e_temp_obj = new Employee();
                    int e_temp = node.get("e_temp").asInt();
                    for (Employee employee : employees) {
                        if (e_temp == employee.getEmployee_id()) {
                            e_temp_obj = employee;
                        }
                    }
                    int t_temp = node.get("t_temp").asInt();
                    Task t_temp_obj = new Task();
                    for (Task task : tasks) {
                        if (t_temp == task.getProject_ID()) {
                            t_temp_obj = task;
                        }
                    }
                    int man_hours_completed = node.get("man_hours_completed").asInt();
                    String task_assigned = node.get("task_assigned").asText();
                    handles.add(new Handles(e_temp_obj,t_temp_obj,man_hours_completed,task_assigned));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handles;
    }
    //implementation of the function "writeHandlesJsonFile".
    public void writeHandlesJsonFile(String file_path, ArrayList<Handles> handles) throws IOException{
        ArrayList<Map<String, Object>> handles_to_be_written = new ArrayList<>();
        for (int i = 0; i < handles.size(); i++) {
            HashMap <String, Object> data = new HashMap<>();
            data.put("e_temp", handles.get(i).getE_temp().getEmployee_id());
            data.put("t_temp", handles.get(i).getT_temp().getProject_ID());
            data.put("man_hours_completed", handles.get(i).getMan_hours_completed());
            data.put("task_assigned", handles.get(i).getTask_assigned());
            handles_to_be_written.add(data);
        }
        objectMapper.writeValue(Paths.get(file_path).toFile(), handles_to_be_written);
    }
    //Display function to show the value of declared attributes in handles class
    public void Display(){
        for(int i=0; i<handles.size(); i++){
            System.out.print("//nEmployee ID: ");
            System.out.print(handles.get(i).getE_temp().getEmployee_id());
            System.out.print("//nProject ID: ");
            System.out.print(handles.get(i).getT_temp().getProject_ID());
            System.out.print("//nMan Hours completed on the project: ");
            System.out.print(handles.get(i).getMan_hours_completed());
            System.out.print("//nTask Assigned: ");
            System.out.print(handles.get(i).getTask_assigned());
            System.out.print("//n-----------------------------------------------------");
        }
    }
    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Employee ID");
        headers.add("Project ID");
        headers.add("Man Hours Completed");
        headers.add("Task Assigned");
        return headers;
    }
    public ArrayList<String> getLine(int line){
        ArrayList<String> handles_single_line = new ArrayList<String >();
        handles_single_line.add(String.valueOf(handles.get(line).getE_temp().getEmployee_id()));
        handles_single_line.add(String.valueOf(handles.get(line).getT_temp().getProject_ID()));
        handles_single_line.add(String.valueOf(handles.get(line).getMan_hours_completed()));
        handles_single_line.add(handles.get(line).getTask_assigned());
        return handles_single_line;
    }
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> handles_subset = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            handles_subset.add(getLine(i));
        }
        return handles_subset;
    }
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }
    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }
    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }
    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }
    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }
    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }
    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }
    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }
    public ArrayList<Handles> getTable() {
        return handles;
    }

    public void GenerateHandles(int e_temp, int t_temp, int man_hours_completed, String task_assigned) {
        readHandlesJsonFile(path);
        employees = new manageEmployee().readEmployeeJsonFile("src/Model/Employee/Employee.json");
        tasks = new manageProject().readProjectjsonfile("src/Model/Project/Project.json");
        for (int i = 0; i < employees.size(); i++) {

            if (e_temp == employees.get(i).getEmployee_id()) {
                e_o = employees.get(i);
            }
        }
        for (int i = 0; i < tasks.size(); i++) {

            if (t_temp == tasks.get(i).getProject_ID()) {
                t_0 = tasks.get(i);
            }
        }
        handles.add(new Handles(e_o, t_0, man_hours_completed, task_assigned));
        try {
            writeHandlesJsonFile(path, handles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void DeleteHandles(int id){
        readHandlesJsonFile(path);
        handles.remove(id);
        try{
            writeHandlesJsonFile(path, handles);        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void UpdateHandles(int index, int e_temp, int t_temp, int man_hours_completed, String task_assigned){
        readHandlesJsonFile(path);
        for (int i = 0; i < employees.size(); i++) {
            if (e_temp == employees.get(i).getEmployee_id()) {
                e_o = employees.get(i);
            }
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (t_temp == tasks.get(i).getProject_ID()) {
                t_0 = tasks.get(i);
            }
        }
        handles.get(index).setE_temp(e_o);
        handles.get(index).setT_temp(t_0);
        handles.get(index).setMan_hours_completed(man_hours_completed);
        handles.get(index).setTask_assigned(task_assigned);
        try {
            writeHandlesJsonFile(path, handles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void deleteIfProjectGetsDeleted(int id){
        readHandlesJsonFile(path);
        for(int i = 0; i < handles.size(); i++){
            if (id == handles.get(i).getT_temp().getProject_ID()){
                handles.remove(i);
            }
        }
        try {
            writeHandlesJsonFile(path, handles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteIfEmployeeGetsDeleted(int id){
        readHandlesJsonFile(path);
        for(int i = 0; i < handles.size(); i++){
            if (id == handles.get(i).getE_temp().getEmployee_id()){
                handles.remove(i);
            }
        }
        try {
            writeHandlesJsonFile(path, handles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}