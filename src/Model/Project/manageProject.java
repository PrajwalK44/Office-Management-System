package Model.Project;

import Model.Displayable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class manageProject extends FileHandlingProject implements Displayable {
    //this class extends abstract class FileHandling and implements Interface Displayable
    ArrayList<Task> projects = new ArrayList<Task>();
    ObjectMapper objectMapper = new ObjectMapper();
    // use of object Mapper is done to convert java objects to and from json format
    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    String p = "src/Model/Project/Project.json";

    //This is the default constructor
    public manageProject() {
        readProjectjsonfile(p);
    }

    //This function reads the content in the json file and stores it in the Arraylist
    public ArrayList<Task> readProjectjsonfile(String file_path) {
        projects.removeAll(projects);
        try {

            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int project_id = node.get("project_ID").asInt();
                    String project_name = node.get("project_Name").asText();
                    String start_date = node.get("project_Start_Date").asText();
                    int budget = node.get("budget").asInt();
                    String res = node.get("resources").asText();
                    int hours = node.get("hours_Completed").asInt();

                    projects.add(new Task(project_id, project_name, start_date, budget, res, hours));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projects;
    }

    //This function writes the arraylist to a json file
    public void writeProjectJsonFile(String file_path, ArrayList<Task> students) throws IOException {
        //objectMapper.writeValue(Paths.get("src/Model/Students/students.json").toFile(), students);
        objectMapper.writeValue(Paths.get(p).toFile(), projects);
    }

    public void setProjectTable(ArrayList<Task> p) {
        this.projects = p;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Start Date");
        headers.add("budget");
        headers.add("Resources");
        headers.add("Hours");
        return headers;
    }

    //This is the getLine function which gets a certain line from arraylist
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> TaskDetails = new ArrayList<String>();
        TaskDetails.add(String.valueOf(projects.get(line).getProject_ID()));
        TaskDetails.add(projects.get(line).getProject_Name());
        TaskDetails.add(projects.get(line).getProject_Start_Date());
        TaskDetails.add(String.valueOf(projects.get(line).getBudget()));
        TaskDetails.add(projects.get(line).getResources());
        TaskDetails.add(String.valueOf(projects.get(line).getHours_Completed()));
        return TaskDetails;
    }

    //This is the getLines function which gets all lines from arraylist
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> Task_Subset = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            Task_Subset.add(getLine(i));
        }
        return Task_Subset;
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

    public ArrayList<Task> getTable() {
        return projects;
    }

    public int GenerateProject(int id, String name, String start, int bud, String res, int hrs) {
        readProjectjsonfile(p);
        for (Task p : projects){
            if (id == p.getProject_ID()){
                return 0;
            }
        }
        projects.add(new Task(id, name, start, bud, res, hrs));
        try {
            writeProjectJsonFile(p, projects);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    int c = 0;
    public void DeleteProject(int id) {
        readProjectjsonfile(p);
        for(int i = 0; i < projects.size(); i++){
            c++;
            if(id == projects.get(i).getProject_ID()){
                projects.remove(i);
                c++;
                break;

            }
        }
        for(int i = 0; i < projects.size(); i++){
            if(c == projects.get(i).getProject_ID()){
                projects.get(i).setProject_ID(c-1);
                c++;
            }
        }
        try {
            writeProjectJsonFile(p, projects);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void UpdateProject(int pindex, int id, String name, String start, int bud, String res, int hrs) {
        readProjectjsonfile(p);
        for (Task project : projects){
            if (pindex == project.getProject_ID()){
                project.setProject_ID(id);
                project.setProject_Name(name);
                project.setProject_Start_Date(start);
                project.setBudget(bud);
                project.setResources(res);
                project.setHours_Completed(hrs);
            }
        }
        try {
            writeProjectJsonFile(p, projects);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> projectGetter(int id){
        ArrayList<String> pG = new ArrayList<>();
        readProjectjsonfile(p);
        for (Task task : projects) {
            if (id == task.getProject_ID()) {
                pG.add(String.valueOf(task.getProject_ID()));
                pG.add(task.getProject_Name());
                pG.add(task.getProject_Start_Date());
                pG.add(String.valueOf(task.getBudget()));
                pG.add(task.getResources());
                pG.add(String.valueOf(task.getHours_Completed()));
            }
        }
        return pG;
    }
}

