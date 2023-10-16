package abstract_data_type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShifterClassNoRequiredIgnore implements CircularShift{
    private List<String> lines;
    private List<String> searchWord;

    public ShifterClassNoRequiredIgnore(List<String> lines, List<String> searchWord) {
        this.lines = circularShift(lines, searchWord);
    }

    private List<String> circularShift(List<String> lines, List<String> linesSearchWord){
        searchWord = linesSearchWord;

        List<String> result = new LinkedList<>();

        for (int j = 0; j < searchWord.size(); j++){
            if (searchWord.get(j).equals("q")) {
                break;
            }
            else {
                for (int i = 0; i < lines.size(); i++) {
                    List<String> arr = List.of(lines.get(i).split(" "));
                    List<String> tempArr = new ArrayList<>(arr);

                    for (int y = 0; y < arr.size(); y++) {
                        String tempString = "";

                        for (String s : tempArr) {
                            tempString += s + " ";
                        }
                        if (tempArr.get(0).toLowerCase().trim().equals(searchWord.get(j))) {
                            result.add(tempString.trim());
                        }
                        else {
                                if ((tempArr.get(0).toLowerCase().trim().equals(searchWord.get(j)) || searchWord.get(j).equals(null))) {
                                    result.add(tempString.trim());
                                }
                                else if (tempArr.get(0).toLowerCase().trim().equals(searchWord.get(j))) {
                                    result.add(tempString.trim());
                                }
                        }
                        String tempFirst = tempArr.get(0); //put first element to last to get next combination
                        tempArr.remove(0);
                        tempArr.add(tempFirst);
                    }
                }
            }
        }
        return result;
    }

    private String arrayToString(List<String> array){
        StringBuilder builder = new StringBuilder();
        for (String word: array) {
            builder.append(word);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    @Override
    public List<String> getShiftedLines() {
        return lines;
    }
}
