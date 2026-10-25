package lesson11;

import java.util.HashMap;
import java.util.Map;

public class NPEExericse {

    public static void main(String[] args) {
        Integer score = null;

        try {
            int s = score;
        } catch (NullPointerException e) {
            System.out.println("Loi NPE");
        }

        int s = (score != null) ? score : 0;
        System.out.println("Fix 1: s = " + s);

        Map<String, Integer> stock = new HashMap<>();

        try {
            int qty = stock.get("tea");
        } catch (NullPointerException e) {
            System.out.println("Loi 2: NPE");
        }

        int qtyFix = stock.getOrDefault("tea", 0);
        System.out.println("Fix 2: qty = " + qtyFix);
    }

}
