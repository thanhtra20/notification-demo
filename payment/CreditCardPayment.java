package payment;

public class CreditCardPayment implements PaymentMethod  {

    @Override
    public boolean pay(double amount) {
        if (true) {
            System.out.println("Thanh Toan the credit: " + amount);
        }
        return false;
    }
    
}
