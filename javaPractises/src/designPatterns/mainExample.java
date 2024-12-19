package designPatterns;

import designPatterns.User.userBuilder;

public class mainExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user = new User.userBuilder().setId(121).setName("Prathamesh").setAddress("Pune").build();
		
		
		System.out.println(user.toString());

	}

}
