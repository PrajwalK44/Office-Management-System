package Model.Handles;
import java.io.IOException;
import java.util.ArrayList;
public abstract class FileHandlingHandles {
    protected abstract ArrayList<Handles> readHandlesJsonFile(String file_path);
    protected abstract void writeHandlesJsonFile(String file_path, ArrayList<Handles> handles) throws IOException;
}
