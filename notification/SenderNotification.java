package notification;
/**
 * INTERFACE: a contract describing WHAT a sender can do, not HOW.
 */
public interface SenderNotification {

    void send(String recipient, String message);

}
