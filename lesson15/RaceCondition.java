package lesson15;

public class RaceCondition {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        final int THREADS = 10;
        final int INCREMENTS = 1000;

        for (int run = 1; run <= 5; run++) {
            counter = 0;
            Thread[] threads = new Thread[THREADS];

            for (int i = 0; i < THREADS; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < INCREMENTS; j++) {
                        counter++;
                    }
                });
                threads[i].start();
            }
            for (Thread t : threads) {
                t.join();
            }

            System.out.println("Lần " + run + ": expected = " + (THREADS * INCREMENTS)
                    + ", actual = " + counter);
        }
    }

}
