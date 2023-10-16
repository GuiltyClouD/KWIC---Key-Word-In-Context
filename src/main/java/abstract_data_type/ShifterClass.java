package abstract_data_type;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ShifterClass implements CircularShift{
    private List<String> lines;
    private List<String> ignoredLines = Collections.emptyList();
    private List<String> requiredLines = Collections.emptyList();
    private List<String> searchWord;

    public ShifterClass(List<String> lines, List<String> linesIgnored, List<String> linesRequired, List<String> searchWord) {
        this.lines = circularShift(lines, linesIgnored, linesRequired, searchWord);
    }

    private List<String> circularShift(List<String> lines, List<String> linesIgnored, List<String> linesRequired, List<String> linesSearchWord){
        ignoredLines = linesIgnored;
        requiredLines = linesRequired;
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
                        if (ignoredLines.isEmpty() == true && tempArr.get(0).toLowerCase().trim().equals(searchWord.get(j))) {
                            result.add(tempString.trim());
                        }
                        else {
                            //Convert all element in ignore list to lowercase
                            for (int k = 0; k < ignoredLines.size(); k++) {
                                ignoredLines.set(k, ignoredLines.get(k).toLowerCase());
                            }
                            boolean haveIgnored = ignoredLines.contains(tempArr.get(0).toLowerCase().trim()); //compare the first element to ignore list in all lowercase
                            if (haveIgnored == false) {
                                //add to final list when ignore is false
                                if (requiredLines.isEmpty() == true && (tempArr.get(0).toLowerCase().trim().equals(searchWord.get(j)) || searchWord.get(j).equals(null))) {
                                    result.add(tempString.trim());
                                }
                                else if (tempArr.get(0).toLowerCase().trim().equals(searchWord.get(j))) {
                                    result.add(tempString.trim());
                                }
                                else {
                                    //Convert all element in required list to lowercase
                                    for (int l = 0; l < requiredLines.size(); l++) {
                                        requiredLines.set(l, requiredLines.get(l).toLowerCase());
                                    }
                                    boolean haveRequired = requiredLines.contains(tempArr.get(0).toLowerCase().trim()); //compare the first element to required list in all lowercase
                                    if (haveRequired == true) {
                                        result.add(tempString.trim()); //add to final list when required is true
                                    }
                                }
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
