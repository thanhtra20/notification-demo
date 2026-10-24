import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lesson2.Customer;
import lesson8.OrderWithStream;
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

        // SMS
        // SenderNotification senderNotification = new SMSSender();
        // Email
        // SenderNotification senderNotification = new EmailSender();

        // OrderService service = new OrderService(senderNotification);
        // service.placeOrder("Tea");

        // lesson2: Tạo class Customer làm key HashMap, thử 3 trường hợp (không override
        // / chỉ equals / cả hai)

        // Map<Customer, String> custMap = new HashMap<>();
        // custMap.put(new Customer(1, "KSH"), "VIP");

        // System.out.println(custMap.get(new Customer(1, "KSH")));

        // lesson8
        List<OrderWithStream> orders = List.of(
                new OrderWithStream(1, 10, 150.0, "COMPLETED"),
                new OrderWithStream(2, 11, 80.0, "COMPLETED"),
                new OrderWithStream(3, 10, 200.0, "CANCELLED"),
                new OrderWithStream(4, 12, 300.0, "COMPLETED"),
                new OrderWithStream(5, 16, 305.0, "COMPLETED"),
                new OrderWithStream(7, 20, 700.0, "COMPLETED"),
                new OrderWithStream(6, 14, 340.0, "COMPLETED"));

        Map<Long, Double> totals = orders.stream()
                .filter(o -> "COMPLETED".equals(o.getStatus()))
                .collect(Collectors.groupingBy(
                        OrderWithStream::getCustomerId,
                        Collectors.summingDouble(OrderWithStream::getAmount)));

        // Lay danh sach don da huy, sap xep theo amount giam dan
        List<Long> b2List = orders.stream()
                .filter(o -> "CANCELLED".equals(o.getStatus()))
                .sorted(Comparator.comparing(OrderWithStream::getAmount).reversed())
                .map(OrderWithStream::getId)
                .collect(Collectors.toList());

        System.out.println(totals);
        System.out.println(b2List);

        List<Map.Entry<Long, Double>> sorted = totals.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        List<Map.Entry<Long, Double>> top3 = sorted.stream()
        .limit(3)
        .collect(Collectors.toList());

        System.out.println(top3);
    }

}
