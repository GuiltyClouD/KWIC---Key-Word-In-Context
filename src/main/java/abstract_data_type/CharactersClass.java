package abstract_data_type;

import java.util.List;

public class CharactersClass implements Characters {
    private List<String> lines;

    public CharactersClass(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public List<String> getLines() {
        return lines;
    }
}
