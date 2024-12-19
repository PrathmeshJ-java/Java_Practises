package Sorting;

public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {58, 25, 45, 14, 88, 9};
		int swap = 0;
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap = 1;
				}
				
				if(swap != 1) {
					break;
				}
			}
		}
		
		for(int i: arr) {
			System.out.println(i);
		}

	}

}
