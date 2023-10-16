package abstract_data_type;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class FileOutput implements Output{
    private PrintWriter output;

    public FileOutput(String filename) throws FileNotFoundException {
        output = new PrintWriter(filename.trim());
    }

    @Override
    public void writeToFile(List<String> lines) {
        lines.forEach(output::println);
    }

    @Override
    public void close() {
        output.close();
    }
}
