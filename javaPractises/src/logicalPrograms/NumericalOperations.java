package logicalPrograms;

import java.text.DecimalFormat;

public class NumericalOperations {

	public static void main(String[] args) {
		
		Double a = 1244.1515;
		Double b = 1455.7778;
		
		System.out.println(add(a,b));

	}
	
	public static String add(Double a, Double b) {
		Double num = a + b;
		DecimalFormat dt = new DecimalFormat("#.00");
		String formatter = dt.format(num);
		return formatter;
	}

}
