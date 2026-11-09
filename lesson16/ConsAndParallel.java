package lesson16;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsAndParallel {

    static String task(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return name + " (" + Thread.currentThread().getName() + ")";
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        long start = System.currentTimeMillis();
        // Consequential
        CompletableFuture.supplyAsync(() -> task("Tác vụ 1"), executor)
                .thenCompose(a -> CompletableFuture.supplyAsync(() -> task("Tác vụ 2"), executor))
                .thenCompose(b -> CompletableFuture.supplyAsync(() -> task("Tác vụ 3"), executor))
                .join();
        long seq = System.currentTimeMillis() - start;
        System.out.println("Tuần tự : " + seq + " ms");

        // Para
        start = System.currentTimeMillis();
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> task("Tác vụ 1"), executor);
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> task("Tác vụ 2"), executor);
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> task("Tác vụ 3"), executor);
        CompletableFuture.allOf(f1, f2, f3).join();
        long par = System.currentTimeMillis() - start;
        System.out.println("Parallel : " + par + " ms");

        executor.shutdown();

    }

}
