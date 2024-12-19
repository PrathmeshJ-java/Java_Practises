package versioning;

public class TextBlocks {

	public static void main(String[] args) {
		
		int findonNO = 2;
		
		String dayOfWeek = switch (findonNO) {
		case 1 -> {
		
			yield "Sunday";
		}
		case 2 -> "Monday";
		case 3 -> "Tuesday";
		case 4 -> "Wednusday";
		case 5 -> "Thursday";
		case 6 -> "Friday";
		case 7 -> "Saturday";
		
		default->
			throw new IllegalArgumentException("Unexpected value: " + findonNO);
		};
		
		System.out.println(dayOfWeek);

	}

}
