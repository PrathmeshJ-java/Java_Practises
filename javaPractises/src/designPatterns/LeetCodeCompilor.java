package designPatterns;

interface compilor{
	
	public void display();
}

class javaCompilor implements compilor{

	@Override
	public void display() {
		System.out.println("i am a java compilor");
		
	}
	
}

class pythonCompilor implements compilor{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("i am a python compilor");
	}
	
}

class javascriptCompilor implements compilor{

	@Override
	public void display() {
		
		System.out.println("i am a javascript compilor");
	}
	
}

class compilorfactory{
	
	public static compilor getCompilor(String type) {
		if(type == null) return null;
		
		switch (type) {
		case "JAVA": return new javaCompilor();
		case "PYTHON" : return new pythonCompilor();
		case "JAVASCRIPT" : return new javascriptCompilor();
		default: return null;
			
		}
	}
}



public class LeetCodeCompilor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
		compilor obj1 = compilorfactory.getCompilor("JAVA");
		obj1.display();
		
		compilor obj2 = compilorfactory.getCompilor("JAVASCRIPT");
		obj2.display();
		
		compilor obj3 = compilorfactory.getCompilor("Json");
		obj3.display();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("please provide valid compilor type"+ e.getMessage());
		}

	}

}
