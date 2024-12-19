package logicalPrograms;

public class Stringcountchar {

	public static void main(String[] args) {
		
		String str = "The india is a very famous  @ country";
		char[] StrArray = str.toCharArray();
		
		int lower_count = 0;
		int upper_count = 0;
		int space_count = 0;
		int other_count = 0;
		
		for(int i = 0;i< str.length();i++) {
			if(StrArray[i]>=65 &&StrArray[i]<=90) {
				upper_count++;
			}else if(StrArray[i]>=97 && StrArray[i]<=122) {
				lower_count++;
			}else if(StrArray[i]==32) {
				space_count++;
			}else {
				other_count++;
			}
			
			
		}
		
		System.out.println("Count of capital charecter is : "+upper_count);
		System.out.println("Count of lower charecter is : "+lower_count);
		System.out.println("Count of whitespace is : "+space_count);
		System.out.println("Count of other charecter is : "+other_count);

	 }

}
