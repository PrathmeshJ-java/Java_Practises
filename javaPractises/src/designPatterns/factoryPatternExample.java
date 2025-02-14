package designPatterns;

abstract class Product{
	
	abstract void display();
}

class carCreator extends Product{

	@Override
	void display() {
		// TODO Auto-generated method stub
		System.out.println("i am a car creator");
	}
	
}

class bikeCreator extends Product{

	@Override
	void display() {
		// TODO Auto-generated method stub
		System.out.println("i am a bike creator");
	}
	
}

class ProductFactory{
	
	public static Product getProduct(String type) {
		if(type == null) return null;
		
		if(type.equals("CAR")) {
			return new carCreator();
		}else if(type.equals("BIKE")) {
			return new bikeCreator();
		}
		
		return null;
	}
}

public class factoryPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try {
		
		Product obj1 = ProductFactory.getProduct("CAR");
        obj1.display();
        
        Product obj2 = ProductFactory.getProduct("BIKE");
        obj2.display();
        
    }catch(NullPointerException e) {
    	System.out.println("Please provide valid product name" + e.getMessage());
    }
        
	}

}
