package Assement;

import java.util.*;

//Declare List<String>, assign 10  random numeric string of 2 digit, like "12","21","32", "44" ...
//Using Streams(java 8), group the elements which are having same sum of digits.
// 
//Example : 
//"12", "21", "32",  "44", "55", "23","66","19","98","85"
// 
//Output:
// 
//"12", "21" - sum of digit is 3
// 
//"32", "23" - sum of digit is 5
// 
//"55","19"  - sum of digit is 10

//Declare List<Integer>, assign 10  random numeric Integer , 
//Using Streams(java 8), Find the 3rd, 7th and 9th element, print the filtered list
// 
//Example : 
//17,11,4,3,50,91,82,71,65,10,
 
//Output:
// 
//4, 82, 65

public class streamQuestion {

	public static void main(String[] args) {
		
		List<String> strlist = Arrays.asList("12", "21", "32",  "44", "55", "23","66","19","98","85");
		
//		Map<Integer, List<?>> outputMap = strlist.stream().mapToInt(e-> (int) e).sum().collect	
		
		List<Integer> inputList = Arrays.asList(17,11,4,3,50,91,82,71,65,10);
		
		Integer thirdNO = inputList.stream().sorted((e1,e2)-> Integer.compare(e1, e2)).skip(2).findFirst().get();
		Integer seventhNO = inputList.stream().sorted((e1,e2)-> Integer.compare(e1, e2)).skip(6).findFirst().get();
		Integer ninthNO  = inputList.stream().sorted((e1,e2)-> Integer.compare(e1, e2)).skip(8).findFirst().get();
//		System.out.println(thirdNO);
//		System.out.println(seventhNO);
//		System.out.println(ninthNO);
		
	   List<Integer> lst = new ArrayList<>();
	   lst.add(thirdNO);
	   lst.add(seventhNO);
	   lst.add(ninthNO);
	   System.out.println(lst);
	   
//		inputList.stream().sorted((e1,e2)-> Integer.compare(e1, e2)).forEach(e->
//		      if(e->  )
//				
//				));
//		
//		
//		
}

}
