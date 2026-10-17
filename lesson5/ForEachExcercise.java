package lesson5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachExcercise {
    public static void main(String[] args) {
        // List<String> orders = new ArrayList<>();
        // for (int i = 1; i <= 10; i++) {
        //     orders.add("don" + i);
        // }

        // java.util.ConcurrentModificationException
        // for (String o : orders) {
        // if (o.equals("don3")) {
        // orders.remove(o);
        // }

        // }
        // orders.removeIf(o -> o.equals("don2"));
        // System.out.println(orders);

        //
        List<String> orders3 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            orders3.add("don" + i);
        }
        Iterator<String> it = orders3.iterator();
        while (it.hasNext()) {
            String o = it.next();
            if (o.equals("don1")) {
                it.remove();
            }
            System.out.println("Sau Iterator.remove: " + orders3);
        }
    }

}