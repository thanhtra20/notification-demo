package lesson10;

import java.util.Optional;

public class OrElseExercise {

    static String defaultMethod() {
        System.out.println("Duoc goi khi opt khong co gia tri nhe");
        return "..,Cam kewt =)))";
    }

    public static void main(String[] args) {
        Optional<String> opt = Optional.of("An");

        System.out.println("orElse");
        opt.orElse(defaultMethod());

        System.out.println("orElseGet:");
        opt.orElseGet(() -> defaultMethod());

    }
}
