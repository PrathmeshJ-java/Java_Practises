package CreditCard;

class Main{
    public static void main(String args[]){
       
    	creditCard generalCard = new creditCard("Prathamesh", 30000.0);
        System.out.println(generalCard.getBalance());
        generalCard.makePayment(15000.0, "DOMINOS");
        System.out.println(generalCard.checkDues());
        generalCard.getTransactions();
        generalCard.makeCardPayment(5000);
        generalCard.getTransactions();
    	
        
        System.out.println("--------------------------------------");
        
       creditCard flipkarCard = new FlipkartAxisCard("Prathamesh", 30000.0);
       System.out.println(flipkarCard.getBalance());
       flipkarCard.makePayment(15000.0, "FLIPKART");
       System.out.println(flipkarCard.checkDues());
       flipkarCard.getTransactions();
       flipkarCard.makeCardPayment(5000);
       flipkarCard.getTransactions();
       
       System.out.println("--------------------------------------");
       
       creditCard amazonCard = new AmazonICICIcard("Krushna", 50000.0);
       System.out.println(amazonCard.getBalance());
       amazonCard.makePayment(15000.0, "AMAZON");
       System.out.println(amazonCard.checkDues());
       amazonCard.getTransactions();
       amazonCard.makeCardPayment(5000);
       amazonCard.getTransactions();
    }
}