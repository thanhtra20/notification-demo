package lesson12;

public class OrderNotFoundException extends RuntimeException {

    private final long id;

    public OrderNotFoundException(long id) {
        super("No customer found ...");
        this.id = id;
    }

    public long getId() {
        return id;
    } 
    
}
