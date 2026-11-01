package lesson13;

public class Demo {

    public static void main(String[] args) {
        // Case 1: runs normally
        try (Session s = new Session("session 1")) {
            s.doWork();
        }
        System.out.println("Done 1\n");

        // Case 2: exception in the middle
        try (Session s = new Session("session 2")) {
            s.doWork();
            throw new RuntimeException("something went wrong");
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println();

        // Case 3: two resources, see the closing order
        try (Session a = new Session("A");
            Session b = new Session("B")) {
            a.doWork();
            b.doWork();
        }
    }

}
