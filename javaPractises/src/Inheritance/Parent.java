package Inheritance;

public class Parent {
	
	
	
	public void display() {
		System.out.println("i am parent class");
	}
	
	
	

}

class son extends Parent{
	
	public void display() {
		System.out.println("i am a son class");
	}
	
	public static void main(String args[]) {
		Parent obj = new son();
		obj.display();
	}
}
