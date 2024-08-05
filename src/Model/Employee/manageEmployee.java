package Model.Employee;

import Model.Displayable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class manageEmployee extends FileHandlingEmployee implements Displayable {
    //This class manages the employees data and extends the FileHandlingEmployee and implements Displayable
    ArrayList<Employee> employees=new ArrayList<Employee>();
    // use of object Mapper is done to convert java objects to and from json format
    ObjectMapper objectMapper = new ObjectMapper();
    Employee e1 = new Employee();
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    String file_path="src/Model/Employee/Employee.json";

    public manageEmployee(){ readEmployeeJsonFile(file_path);}
    //This function reads the content in the json file and stores it in the Arraylist
    public ArrayList<Employee> readEmployeeJsonFile(String file_path){
        employees.removeAll(employees);
        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int employee_id = node.get("employee_id").asInt();
                    String name = node.get("name").asText();
                    String position = node.get("position").asText();
                    String dept = node.get("dept").asText();
                    String salary = node.get("salary").asText();
                    String contact_num = node.get("contact_num").asText();
                    String lang = node.get("lang").asText();
                    Employee emp = new Employee(employee_id, name, position, dept, salary, contact_num, lang);
                    employees.add(emp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
    //This function writes the arraylist to a json file
    public void writeEmployeeJsonFile(String file_path, ArrayList<Employee> employees) throws IOException {
        // Clear the existing content of the JSON file
        // Write the updated list of employees to the JSON file
        ArrayList<Map<String, Object>> employees_to_be_written = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("employee_id", employees.get(i).getEmployee_id());
            data.put("name", employees.get(i).getName());
            data.put("position", employees.get(i).getPosition());
            data.put("dept", employees.get(i).getDept());
            data.put("salary", employees.get(i).getSalary());
            data.put("contact_num", employees.get(i).getContact_num());
            data.put("lang", employees.get(i).getLang());
            employees_to_be_written.add(data);
        }
        objectMapper.writeValue(Paths.get(file_path).toFile(), employees_to_be_written);
    }

    public void setEmployeeTable(ArrayList<Employee> e) {
        this.employees = e;
    }
    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Position");
        headers.add("Department");
        headers.add("Salary");
        headers.add("Mobile");
        headers.add("Preferred Language");
        return headers;
    }
    //This is the getLine function which gets a certain line from arraylist
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> employee_details = new ArrayList<String>();
        employee_details.add(String.valueOf(employees.get(line).getEmployee_id()));
        employee_details.add(employees.get(line).getName());
        employee_details.add(employees.get(line).getPosition());
        employee_details.add(employees.get(line).getDept());
        employee_details.add(String.valueOf(employees.get(line).getSalary()));
        employee_details.add(employees.get(line).getContact_num());
        employee_details.add(employees.get(line).getLang());
        return employee_details;
    }
    //This is the getLines function which gets all lines from arraylist
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> employees_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            employees_subset.add(getLine(i));
        }
        return employees_subset;
    }
    @Override
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
    public ArrayList<Employee> getTable() {
        return employees;
    }

    public int GenerateEmployee(int id, String name, String position, String dept, String sal, String cont, String lang){
        readEmployeeJsonFile(file_path);
        for (Employee employee : employees){
            if(id == employee.getEmployee_id()){
                return 0;
            }
        }
        employees.add(new Employee( id,  name, position,  dept,  sal,  cont,  lang));
        try {
            writeEmployeeJsonFile(file_path, employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
    int c =0;
    public void DeleteEmployee(int id){
        readEmployeeJsonFile(file_path);
        for(int i = 0; i < employees.size(); i++){
            c++;
            if(id == employees.get(i).getEmployee_id()){
                employees.remove(i);
                c++;
                break;
            }
        }
        for (Employee employee : employees){
            if (c == employee.getEmployee_id()){
                employee.setEmployee_id(c-1);
                c++;
            }
        }
        try{
            writeEmployeeJsonFile(file_path,employees);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void UpdateEmployee(int epid, int empid, String name, String position, String dept, String sal, String cout, String lang){
        readEmployeeJsonFile(file_path);
        for(Employee employee : employees){
            if (epid == employee.getEmployee_id()){
                employee.setEmployee_id(empid);
                employee.setName(name);
                employee.setPosition(position);
                employee.setDept(dept);
                employee.setSalary(sal);
                employee.setContact_num(cout);
                employee.setLang(lang);
            }
        }
        try {
            writeEmployeeJsonFile(file_path, employees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> employeeGetter(int id){
        ArrayList<String> eG = new ArrayList<>();
        readEmployeeJsonFile(file_path);
        for (Employee employee : employees) {
            if (id == employee.getEmployee_id()) {
                eG.add(String.valueOf(employee.getEmployee_id()));
                eG.add(employee.getName());
                eG.add(employee.getPosition());
                eG.add(employee.getDept());
                eG.add(employee.getSalary());
                eG.add(employee.getContact_num());
                eG.add(employee.getLang());
            }
        }
        return eG;
    }

}
