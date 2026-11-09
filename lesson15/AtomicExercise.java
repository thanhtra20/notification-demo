package lesson15;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExercise {
      static final int THREADS = 10;

    static int unsafeCounter = 0;

    // 2. AtomicInteger
    static final AtomicInteger atomicCounter = new AtomicInteger();

    // 3. synchronized
    static int syncCounter = 0;
    static synchronized void incrementSync() {
        syncCounter++;
    }

    static long run(Runnable task) throws InterruptedException {
        Thread[] threads = new Thread[THREADS];
        long start = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        return (System.nanoTime() - start) / 1_000_000; // ms
    }

    public static void main(String[] args) throws InterruptedException {
        for (int increments : new int[]{1_000, 1_000_000}) {
            unsafeCounter = 0;
            atomicCounter.set(0);
            syncCounter = 0;

            long t1 = run(() -> { for (int j = 0; j < increments; j++) unsafeCounter++; });
            long t2 = run(() -> { for (int j = 0; j < increments; j++) atomicCounter.incrementAndGet(); });
            long t3 = run(() -> { for (int j = 0; j < increments; j++) incrementSync(); });

            System.out.println("=== " + THREADS + " thread x " + increments
                    + " lần, expected = " + (THREADS * increments) + " ===");
            System.out.printf("Không đồng bộ : %8d  (%d ms)%n", unsafeCounter, t1);
            System.out.printf("AtomicInteger : %8d  (%d ms)%n", atomicCounter.get(), t2);
            System.out.printf("synchronized  : %8d  (%d ms)%n%n", syncCounter, t3);
        }
    }
    
}
