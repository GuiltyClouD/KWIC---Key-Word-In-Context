package pipeline;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class PipeAndFilter {
    public static void main(String[] args) throws Exception {
        List<String> lines = Collections.emptyList();
        List<String> ignoredLines = Collections.emptyList();
        List<String> requiredLines = Collections.emptyList();
        List<String> newLines = new ArrayList<>();
        Scanner inputTextFileName= new Scanner(System.in);
        System.out.print("Please enter the text file name with Extension (.txt): ");
        String fileName= inputTextFileName.nextLine();
        System.out.print("You have entered: " + fileName + "\n");

        System.out.print("Please enter the ignore file name with Extension (.txt): ");
        String ignoredFileName= inputTextFileName.nextLine();
        System.out.print("You have entered: " + ignoredFileName + "\n");

        System.out.print("Please enter the required file name with Extension (.txt): ");
        String requiredFileName= inputTextFileName.nextLine();
        System.out.print("You have entered: " + requiredFileName + "\n");

        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            ignoredLines = Files.readAllLines(Paths.get(ignoredFileName), StandardCharsets.UTF_8);
            requiredLines = Files.readAllLines(Paths.get(requiredFileName), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //Print out all combination into Arraylist
        for (int i = 0; i < lines.size(); i++) {
            List<String> arr = List.of(lines.get(i).split(" "));
            List<String> tempArr = new ArrayList<>(arr);


            for (int y = 0; y < arr.size(); y++) {
                String tempString = "";

                for (String s : tempArr) {
                    tempString += s + " ";
                }


                if (ignoredLines.isEmpty() == true) {
                    newLines.add(tempString);
                }
                else {
                    //Convert all element in ignore list to lowercase
                    for (int k = 0; k < ignoredLines.size(); k++)
                    {
                        ignoredLines.set(k, ignoredLines.get(k).toLowerCase());
                    }
                    boolean haveIgnored = ignoredLines.contains(tempArr.get(0).toLowerCase().trim()); //compare the first element to ignore list in all lowercase
                    if (haveIgnored == false) {
                        //add to final list when ignore is false
                        if (requiredLines.isEmpty() == true) {
                            newLines.add(tempString.trim());
                        }
                        else {
                            //Convert all element in required list to lowercase
                            for (int l = 0; l < requiredLines.size(); l++) {
                                requiredLines.set(l, requiredLines.get(l).toLowerCase());
                            }
                            boolean haveRequired = requiredLines.contains(tempArr.get(0).toLowerCase().trim()); //compare the first element to required list in all lowercase
                            if (haveRequired == true) {
                                newLines.add(tempString.trim()); //add to final list when required is true
                            }
                        }
                    }
                }
                String tempFirst = tempArr.get(0); //put first element to last to get next combination
                tempArr.remove(0);
                tempArr.add(tempFirst);
            }
        }



        //Sort the array and ignore case sensitive
        newLines.sort(String.CASE_INSENSITIVE_ORDER);

        //Write into file
        Scanner outputTextFileName= new Scanner(System.in);
        System.out.print("Please enter your output text file name with Extension (.txt): ");
        String fileNameOutput= outputTextFileName.nextLine();
        System.out.print("You have entered: " + fileNameOutput + "\n");

        FileWriter writer = new FileWriter(fileNameOutput);
        for(String str: newLines) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}
