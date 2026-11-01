package lesson13;

public class Session implements AutoCloseable {

    private final String name;

    public Session(String name) {
        this.name = name;
    }

    void doWork() {
        System.out.println("Working with " + name);
    }

    public String getName() {
        return name;
    }

    @Override
    public void close() {
         System.out.println(">>> close() called: closing " + name);
    }

    

}
