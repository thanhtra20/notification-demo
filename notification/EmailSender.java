package notification;
public class EmailSender implements SenderNotification {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Email sending to ~~ " + recipient + message);   
    }
}
