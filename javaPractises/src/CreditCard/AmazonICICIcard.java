package CreditCard;

public class AmazonICICIcard extends creditCard {

	public AmazonICICIcard(String cardHolderName, double creditLimit) {
		super(cardHolderName, creditLimit);
		// TODO Auto-generated constructor stub
	}
	
	public void makePayment(double amount, String PaymentHodler){
	       if(balance < amount){
	        System.out.println("Insufficiant balance in your card");
	       }else {
	    	   if(PaymentHodler.equals("AMAZON")) {
	    		   amount = amount * 0.9;
	    	   }
	           balance -= amount;
	           transactions.put(PaymentHodler, amount);
	           System.out.println("Payment "+amount+" make successfully to "+ PaymentHodler);
	       }

	    }

}
