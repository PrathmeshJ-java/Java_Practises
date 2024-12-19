package logicalPrograms;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniquecharIndex {

	public static void main(String[] args) {
		String str = "abcsbbaaddfdd";
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for(char ch: str.toCharArray()) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			}else {
				map.put(ch, 1);
			}
			
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				System.out.println(entry.getKey());
				return;
				
			}
		}
	}

}
