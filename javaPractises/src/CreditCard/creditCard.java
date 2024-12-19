package CreditCard;
import java.util.*;


public class creditCard{
    private int cardNumber;
    private String cardHolderName;
    private double  creditLimit;
    protected double balance;
    protected Map<String, Double> transactions = new LinkedHashMap<>();

    public creditCard(String cardHolderName, double creditLimit) {
        
        this.setCardHolderName(cardHolderName);
        this.setCardNumber();
        this.setCreditLimit(creditLimit);
        this.balance = this.getCreditLimit();
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber() {
        Random random = new Random();
        this.cardNumber = random.nextInt(1000);
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        if(cardHolderName.isEmpty()){
            System.out.println("Error ... ! Card holder name must not be blank");
        }else
           this.cardHolderName = cardHolderName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        if(creditLimit == 0){
            System.out.println("Error...! Credit must not be 0");
        }else
          this.creditLimit = creditLimit;
    }

    public double getBalance() {
        return balance;
    }

    public void makePayment(double amount, String PaymentHodler){
       if(balance < amount){
        System.out.println("Insufficiant balance in your card");
       }else
           balance -= amount;
           transactions.put(PaymentHodler, amount);
           System.out.println("Payment "+amount+" make successfully to "+ PaymentHodler);

    }

    public double checkDues(){
     double dues = creditLimit - balance;
     return dues;
    }


    public void makeCardPayment(double amount){
        balance += amount;
        transactions.put("Payment", amount);
        System.out.println("Credit card payement "+ amount+" successfully..!");
        System.out.println("Now credit limit is : "+balance);

    }

    public void getTransactions() {
        for (Map.Entry<String, Double> entry : transactions.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
       
    }

   

    



    
}