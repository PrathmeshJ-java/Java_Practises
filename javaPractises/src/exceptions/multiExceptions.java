package exceptions;

public class multiExceptions {

	public static void main(String[] args) throws NullPointerException {
		
		try {
		    String str = null;
		    String concetationString = str.substring(5);
		} catch (NullPointerException e) {
		    System.out.println("null pointer exception catch block");
		} catch (ArithmeticException e) {
		    System.out.println("arithmatic exception catch block");
		} catch (Exception e) {
			System.out.println("exception catch block");
		}

	}

}
