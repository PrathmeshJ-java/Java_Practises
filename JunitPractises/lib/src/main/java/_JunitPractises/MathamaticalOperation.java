package _JunitPractises;

import com.google.errorprone.annotations.Var;

public class MathamaticalOperation {
	
	
	public int addition(int a, int b) {
		return a+b;
	}
	
	public int subtraction(int a, int b) {
		return a-b;
	}
	
	public int multiplication(int a, int b) {
		return a*b;
	}
	
	public int division(int a, int b) {
		if (b == 0) {
	        throw new ArithmeticException("Division by zero is not allowed");
	    }
		int result = a/b;
		return result;	
	}
	
	public int findMax(int[] arr) {
		int max = 0;
		
		for(var i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		return max;
	}
	
	public boolean isEven(int number) {
		return number % 2 == 0;
	}

}
