package FileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	
	public static void main(String args[]) {
		
		Scanner reader;
		try {
			File myObj = new File("D:\\myfile.txt");
			reader = new Scanner(myObj);
			while (reader.hasNextLine()) {
				
				String data = reader.nextLine();
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
