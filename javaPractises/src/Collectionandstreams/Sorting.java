package Collectionandstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;





public class Sorting {

	public static void main(String args[]) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		
		employees.add(new Employee(2, "Rajat", 50000));
		employees.add(new Employee(3, "Pratik", 50000));
		employees.add(new Employee(4, "Kushal", 50000));
		employees.add(new Employee(1, "Prathamesh", 50000));
		
		idComparator idComp = new idComparator();		
		Collections.sort(employees, idComp);
		
		employees.forEach(e -> System.out.println(e));
		
		System.out.println("-------------------");
		
		
		int[] arr = {223, 34, 29, 1, 56, 89, 23, 56};
		
		Arrays.sort(arr, 1, 5);
		
		for(int num: arr) {
			System.out.println(num);
		}
		
	}
}
