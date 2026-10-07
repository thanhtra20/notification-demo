package notification;
/**
 * ABSTRACT CLASS: shares state and code between related senders.
 * Subclasses only need to say which channel they use.
 */
public abstract class AbstractSender implements SenderNotification {

    private final String senderName;

    protected AbstractSender(String senderName) {
        this.senderName = senderName;
    }

    @Override
    public void send(String recipient, String message) {
        System.out.printf("[%s|%s] to %s: %s%n", senderName, recipient, message);
    }
}
