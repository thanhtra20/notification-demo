package notification;
public class OrderService {

    private  SenderNotification notification = new EmailSender();

    public OrderService(SenderNotification notification) {
        this.notification = notification;
    }

    public void placeOrder(String customer) {
        System.out.println("Order of " + customer + "has been created.");
        notification.send(customer, " successfully created.");
    }
}
