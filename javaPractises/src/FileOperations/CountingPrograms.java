package FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class CountingPrograms {

    public static void main(String[] args) {
       
         
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        
        try (BufferedReader reader = new BufferedReader(new FileReader(Path.of("./src/input.txt").toFile()))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
            	String[] words = line.trim().split("\\s");
            	wordCount = wordCount + words.length;
            	charCount = charCount + line.replace(" ", "").length();
                lineCount++;
            }
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        
        System.out.println("Number of lines in the file: " + lineCount);
        System.out.println("Number of words in the file: " + wordCount);
        System.out.println("Number of characters in the file: " + charCount);
    }
}
