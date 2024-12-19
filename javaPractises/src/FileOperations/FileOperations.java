package FileOperations;

import java.io.File;

public class FileOperations {
	
	public static void main(String args[]) {
	try {
		File myObj = new File("D:\\myfile.txt");
		if(myObj.createNewFile()) {
			System.out.println("file created successfully.");
		}else {
			System.out.println("file already exists..");
		}
		
		
		
	}catch (Exception e) {
		System.out.println(e);
	}
		
	}

}
