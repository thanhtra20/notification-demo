package lesson16;

public class DeadlockDemo {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lockA) { 
                System.out.println("T1: locked A");
                sleep(1000); 
                System.out.println("T1: waiting for B...");
                synchronized (lockB) { 
                    System.out.println("T1: Done"); 
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) { 
                System.out.println("T2: hold B");
                sleep(1000); 
                System.out.println("T2: waiting for A...");
                synchronized (lockA) { 
                    System.out.println("T2: done"); 
                }
            }
        });

        t1.start();
        t2.start();

    }


    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
