package abstract_data_type;

import java.util.Collections;
import java.util.List;

public class AlphabetizerClass implements Alphabetizer {
    private List<String> lines;

    public AlphabetizerClass(List<String> lines) {
        this.lines = alphabetize(lines);
    }


    private List<String> alphabetize(List<String> lines){
        Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
        return lines;
    }

    @Override
    public List<String> getLines() {
        return lines;
    }
}
