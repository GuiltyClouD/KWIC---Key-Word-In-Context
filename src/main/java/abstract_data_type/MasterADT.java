package abstract_data_type;

import jdk.nashorn.internal.objects.AccessorPropertyDescriptor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MasterADT {
    private String fileInput;
    private String fileInputIgnored;
    private String fileInputRequired;
    private List<String> searchList;

    public MasterADT(String inputFileName, String fileInputIgnored, String fileInputRequired, List<String> searchListWord){
        this.fileInput = inputFileName;
        this.fileInputIgnored = fileInputIgnored;
        this.fileInputRequired = fileInputRequired;
        this.searchList = searchListWord;
    }

    public void generateKWIC() throws IOException {
        Input inputFile = new FileInput(fileInput);
        Input inputFileIgnored = new FileInput(fileInputIgnored);
        Input inputFileRequired = new FileInput(fileInputRequired);

        Characters charactersFile = new CharactersClass(inputFile.readAllLines());
        Characters charactersFileIgnored = new CharactersClass(inputFileIgnored.readAllLines());
        Characters charactersFileRequired = new CharactersClass(inputFileRequired.readAllLines());
        Characters charactersSearchList = new CharactersClass(searchList);

        if (charactersFile.getLines().get(0).contains("txt")) {
            //System.out.print("Contain text <txt> in the file" + "\n");
            //System.out.print("What is the size: " + charactersFile.getLines().size() + "\n");
            for (int i = 0; i < charactersFile.getLines().size(); i++) {
                String nameOfListOfFiles = charactersFile.getLines().get(i);
                //System.out.print("You are searching from: " + nameOfListOfFiles + "\n");
                //System.out.print("Name of the file checking now " + i + ": " + nameOfListOfFiles + "\n");

                //able to process this
                Input newInputFile = new FileInput(nameOfListOfFiles);

                Characters newCharactersFile = new CharactersClass(newInputFile.readAllLines());

                CircularShift shifter = new ShifterClass(newCharactersFile.getLines(), charactersFileIgnored.getLines(),
                        charactersFileRequired.getLines(), charactersSearchList.getLines());

                Alphabetizer alphabetizer = new AlphabetizerClass(shifter.getShiftedLines());
                if (alphabetizer.getLines().isEmpty() != true) {
                    System.out.print(nameOfListOfFiles + "\n");
                    for(int j = 0; j < alphabetizer.getLines().size(); j++){
                        System.out.println(alphabetizer.getLines().get(j));
                    }
                }

                String fileNameOutput = "Output - " + nameOfListOfFiles;
                //String fileNameOutput = "Output.txt";
                //Output output = (Output) new BufferedWriter(new FileWriter(fileNameOutput));
                System.out.print("Output file " + fileNameOutput + " has been created" + "\n" + "\n");
                Output output = new FileOutput(fileNameOutput);
                //output.writeToFile(Collections.singletonList(nameOfListOfFiles));
                output.writeToFile(alphabetizer.getLines());
                output.close();
            }
        }
        else {
            CircularShift shifter = new ShifterClass(charactersFile.getLines(), charactersFileIgnored.getLines(),
                    charactersFileRequired.getLines(), charactersSearchList.getLines());
            Alphabetizer alphabetizer = new AlphabetizerClass(shifter.getShiftedLines());

            String fileNameOutput = "Output.txt";
            Output output = new FileOutput(fileNameOutput);
            output.writeToFile(alphabetizer.getLines());
            output.close();
        }
    }

    public void generateKWICnoRequiredIgnored() throws IOException {
        Input inputFile = new FileInput(fileInput);

        Characters charactersFile = new CharactersClass(inputFile.readAllLines());
        Characters charactersSearchList = new CharactersClass(searchList);

        //System.out.print("Contain text <txt> in the file" + "\n");
        //System.out.print("What is the size: " + charactersFile.getLines().size() + "\n");
        for (int i = 0; i < charactersFile.getLines().size(); i++) {
            String nameOfListOfFiles = charactersFile.getLines().get(i);
            //System.out.print("You are searching from: " + nameOfListOfFiles + "\n");
            //System.out.print("Name of the file checking now " + i + ": " + nameOfListOfFiles + "\n");

            //able to process this
            Input newInputFile = new FileInput(nameOfListOfFiles);

            Characters newCharactersFile = new CharactersClass(newInputFile.readAllLines());

            CircularShift shifter = new ShifterClassNoRequiredIgnore(newCharactersFile.getLines(), charactersSearchList.getLines());

            Alphabetizer alphabetizer = new AlphabetizerClass(shifter.getShiftedLines());
            if (alphabetizer.getLines().isEmpty() != true) {
                System.out.print(nameOfListOfFiles + "\n");
                for(int j = 0; j < alphabetizer.getLines().size(); j++){
                    System.out.println(alphabetizer.getLines().get(j));
                }
            }

            String fileNameOutput = "Output - " + nameOfListOfFiles;
            //String fileNameOutput = "Output.txt";
            //Output output = (Output) new BufferedWriter(new FileWriter(fileNameOutput));
            System.out.print("Output file " + fileNameOutput + " has been created" + "\n" + "\n");
            Output output = new FileOutput(fileNameOutput);
            //output.writeToFile(Collections.singletonList(nameOfListOfFiles));
            output.writeToFile(alphabetizer.getLines());
            output.close();
        }

    }

    public static void main(String[] args) throws IOException {
        String inputFileName = null;
        String ignoreFileName = null;
        String requiredFileName = null;
        String searchWord = null;
        List<String> searchList = new LinkedList<>();;

        if (args[0].equals("search") || args[0].equals("Search")){
            while (true){
                System.out.print("Please type in your search word (Enter 'q' to exit): " + "\n");
                Scanner inputSearchWord = new Scanner(System.in);
                searchWord = inputSearchWord.nextLine();
                System.out.print("You have entered: " + searchWord + "\n");
                inputFileName = args[1];
                if (searchWord.equals("q")) {
                    break;
                }
                else {
                    searchList.add(searchWord);
                }
                MasterADT adt = new MasterADT(inputFileName, ignoreFileName, requiredFileName, searchList);
                adt.generateKWICnoRequiredIgnored();
            }
        }
        else if ((args[0].equals("search") || args[0].equals("Search")) && !args[2].equals(null)){
            while (true){
                System.out.print("Please type in your search word (Enter 'q' to exit): " + "\n");
                Scanner inputSearchWord = new Scanner(System.in);
                searchWord = inputSearchWord.nextLine();
                System.out.print("You have entered: " + searchWord + "\n");
                inputFileName = args[1];
                ignoreFileName = args[2];
                requiredFileName = args[3];
                if (searchWord.equals("q")) {
                    break;
                }
                else {
                    searchList.add(searchWord);
                }
                MasterADT adt = new MasterADT(inputFileName, ignoreFileName, requiredFileName, searchList);
                adt.generateKWIC();
            }
        }
        //else {
            //inputFileName = args[0];
            //ignoreFileName = args[1];
            //requiredFileName = args[2];
            //System.out.print("What is input list name: " + inputFileName + "\n");

            // adt = new MasterADT(inputFileName, ignoreFileName, requiredFileName, searchWord);
            //adt.generateKWIC();
        //}


        System.out.print("Output created successfully" + "\n");
    }
}
