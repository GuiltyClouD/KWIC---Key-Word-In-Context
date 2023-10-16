package abstract_data_type;

import java.util.List;

public interface Output {
    void writeToFile(List<String> lines);
    void close();
}
