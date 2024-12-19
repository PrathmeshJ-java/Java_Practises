package FileOperations;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteOperation {

	public static void main(String[] args) {
		
		try {
			FileWriter writer = new FileWriter("D:\\myfile.txt");
			writer.write("This is my most important content");
			writer.close();
			System.out.println("Successfully wrote on the file..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
