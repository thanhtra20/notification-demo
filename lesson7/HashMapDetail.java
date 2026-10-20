package lesson7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDetail {
    public static void main(String[] args) {
        int n = 20000;
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listA.add(i);
            listB.add(i + n / 2);
        }

        long start = System.nanoTime();
        int count1 = 0;
        for (Integer a : listA) {
            for (Integer b : listB) {
                if (a.equals(b)) {
                    count1++;
                    break;
                }
            }
        }
        long time1 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("For lồng nhau: " + count1 + "," + time1 + " ms");

        //using map
        start = System.nanoTime();
        Map<Integer, Boolean> mapB = new HashMap<>();
        for (Integer b : listB) {
            mapB.put(b, true); 
        }
        int count2 = 0;
        for (Integer a : listA) {
            if (mapB.containsKey(a)) {
                count2++;
            }
        }
        long time2 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Dùng Map: " + count2 + "," + time2 + " ms");
    }
}
