package logicalPrograms;

public class logical1 {

	public static void main(String[] args) {
		
		String str = "Prathamesh";
		String newstr = "";
		
		for(int i =0;i< str.length();i++) {
			newstr = str.charAt(i) + newstr;
		}
		
		if(str.equals(newstr)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}

	}

}
