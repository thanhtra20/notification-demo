package lesson7;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapInGeneral {

    public static void main(String[] args) {
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new LinkedHashMap<>();
        Map<String, Integer> c = new TreeMap<>();

        a.put("banana", 1);
        a.put("apple", 20);
        a.put("mango", 2);
        System.out.println("a:" + a);

        b.put("banana", 1);
        b.put("apple", 20);
        b.put("mango", 2);
        System.out.println("b:" + b);

        c.put("banana", 1);
        c.put("apple", 20);
        c.put("mango", 2);
        System.out.println("c:" + c);

    }

}
