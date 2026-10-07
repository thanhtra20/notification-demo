package notification;
public class SMSSender implements SenderNotification {

    @Override
    public void send(String recipient, String message) {
        System.out.println("SMS sending to: " + recipient + message);
    }
}
