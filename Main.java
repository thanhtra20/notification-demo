import java.util.HashMap;
import java.util.Map;

import lesson2.Customer;
import notification.EmailSender;
import notification.OrderService;
import notification.SMSSender;
import notification.SenderNotification;
import payment.CheckOutService;
import payment.CreditCardPayment;
import payment.PaymentMethod;

public class Main {
    public static void main(String[] args) {
        // PaymentMethod payment = new CreditCardPayment();
        // CheckOutService service = new CheckOutService(payment);
        // service.checkOut("NTT", 500000);
        
        //SMS
        // SenderNotification senderNotification = new SMSSender();
        //Email
        // SenderNotification senderNotification = new EmailSender();

        // OrderService service = new OrderService(senderNotification);
        // service.placeOrder("Tea");

        //lesson2: Tạo class Customer làm key HashMap, thử 3 trường hợp (không override / chỉ equals / cả hai)
        
        Map<Customer, String> custMap = new HashMap<>();
        custMap.put(new Customer(1, "KSH"), "VIP");

        System.out.println(custMap.get(new Customer(1, "KSH")));

    }
}
