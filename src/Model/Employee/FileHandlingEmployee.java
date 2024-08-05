package Model.Employee;
import java.io.IOException;
import java.util.ArrayList;
public abstract class FileHandlingEmployee {
    //This is the abstract class
    //These are abstract functions declared which CAN be implemented by other subclasses
    protected abstract ArrayList<Employee> readEmployeeJsonFile(String file_path);
    protected abstract void writeEmployeeJsonFile(String file_path, ArrayList<Employee> students) throws IOException;

}