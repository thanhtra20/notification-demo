package payment;

public class CheckOutService {
    //Gọi payment.pay(amount).
//Nếu true: in Đơn hàng của <customer> đã thanh toán thành công.
//Nếu false: in Thanh toán thất bại, đơn hàng bị hủy.

    private final PaymentMethod paymentMethod;

    public CheckOutService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    } 

    public void checkOut(String customer, double amount) {
        paymentMethod.pay(amount);
        if (true) {
            System.out.println("The order of " + customer + "successfully purchased");  
        } 
        System.out.println("Failed to process.");

    }

    
    
}
