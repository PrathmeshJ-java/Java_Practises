package Sorting;

public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {58, 25, 45, 14, 88, 9, 91};
		
		for(int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
		
		for(int i: arr) {
			System.out.println(i);
		}

	}

}
