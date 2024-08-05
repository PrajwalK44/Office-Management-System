package Model.Project;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingProject {
    //This is the abstract class
    protected abstract ArrayList<Task> readProjectjsonfile(String file_path);
    protected abstract void writeProjectJsonFile(String file_path, ArrayList<Task> projects) throws IOException;
}
