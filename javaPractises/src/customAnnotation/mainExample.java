package customAnnotation;

public class mainExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Demo d = new Demo();
		
		Class c = d.getClass();
		
		System.out.println(c.getName());
		
		myAnno an = (myAnno) c.getAnnotation(myAnno.class);
		
		System.out.println(an.name());
		System.out.println(an.city());

	}

}
