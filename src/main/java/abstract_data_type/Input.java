package abstract_data_type;

import java.io.IOException;
import java.util.List;

public interface Input {
    List<String> readAllLines() throws IOException;
}
