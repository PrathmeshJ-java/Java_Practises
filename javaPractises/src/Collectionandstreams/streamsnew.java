package Collectionandstreams;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamsnew {
	
	public static void main(String args[]) {
		
		List<Integer> numbers = Stream.of(2,2,3,2,3,45,4).distinct().filter(i->(i%2==0)).collect(Collectors.toList());
		
		for (Integer i : numbers) {
			
			System.out.println(i);
			
		}
	}

}
