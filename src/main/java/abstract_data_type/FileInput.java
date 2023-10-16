package abstract_data_type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileInput implements Input {
    private String fileName;

    public FileInput(String fName) {
        fileName =  fName;
    }

    @Override
    public List<String> readAllLines() throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }
}
