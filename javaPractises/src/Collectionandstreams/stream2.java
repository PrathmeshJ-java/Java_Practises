package Collectionandstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class stream2 {

	public static void main(String[] args) {
		
		ArrayList<Integer> marks = new ArrayList<Integer>();
		
		marks.add(56);
		marks.add(34);
		marks.add(67);
		marks.add(71);
		
		List<Integer> updatemarkIntegers = marks.stream().map(mark -> mark < 35 ? mark + 6 : mark).collect(Collectors.toList());
		
		System.out.println(updatemarkIntegers);

	}

}
