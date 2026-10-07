package payment;

public class MoMoPayment implements PaymentMethod {

    @Override
    public boolean pay(double amount) {
        if (true) {
            System.out.println("Thanh toan Momo: " + amount);
        }
        return false;

    }
}