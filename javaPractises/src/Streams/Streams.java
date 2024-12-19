package Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> lst = Arrays.asList(43,56,78,45,45,67,67,88,93);
		
		List<Integer> sortedlst = lst.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		
		sortedlst.forEach((e)->System.out.println(e));
		
		Integer minElement = lst.stream().min((x,y)->x.compareTo(y)).get();
		System.out.println("min : " + minElement);
		
		Integer maxElement = lst.stream().max((x,y)->x.compareTo(y)).get();
		System.out.println("min : " + maxElement);
		
		List<Integer> disIntegers = lst.stream().distinct().collect(Collectors.toList());
		
		System.out.println(disIntegers);
	}

}
