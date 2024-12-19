package logicalPrograms;

import java.util.HashMap;

public class assessment {
	
public static void main(String args[]) {
	
	int arr[] = {10,5,20,6,10,15,20};
	HashMap<Integer, Integer> arrcount = new HashMap();
	for(int i=0; i< arr.length; i++) {
		int value = arr[i];
		int count = 0;
		for(int j=0; j< arr.length; j++) {
			if(value==arr[j]) {
				count++;
			}
			
			
		}
		
		arrcount.put(arr[i], count);
			
		
		
	}
	
	
	System.out.println(arrcount);



}

}
