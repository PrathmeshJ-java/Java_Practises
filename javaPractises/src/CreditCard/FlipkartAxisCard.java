package CreditCard;

public class FlipkartAxisCard extends creditCard {

	public FlipkartAxisCard(String cardHolderName, double creditLimit) {
		super(cardHolderName, creditLimit);
		// TODO Auto-generated constructor stub
	}
	
	public void makePayment(double amount, String PaymentHodler){
	       if(balance < amount){
	        System.out.println("Insufficiant balance in your card");
	       }else {
	    	   if(PaymentHodler.equals("FLIPKART")) {
	    		   amount = amount * 0.95;
	    	   }
	           balance -= amount;
	           transactions.put(PaymentHodler, amount);
	           System.out.println("Payment "+amount+" make successfully to "+ PaymentHodler);
	       }

	    }

}
