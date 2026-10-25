package lesson11;

import java.util.ArrayList;
import java.util.List;

public class NpVsEmpty {

    static List<String> findNull(boolean exist) {
        return exist ? List.of("an", "binh") : null;
    }

    static List<String> findEmpty(boolean exist) {
        return exist ? List.of("an", "binh") : new ArrayList<>();
    }

    public static void main(String[] args) {
        List<String> a = findNull(false);
        if (a != null) {
            for (String n : a)
                System.out.println(n);
        }
        try {
            for (String n : findNull(false)) {
            } 
        } catch (NullPointerException e) {
            System.out.println("Return null + without checking: NPE");
        }

       
        for (String n : findEmpty(false)) { 
            System.out.println(n);
        }
        System.out.println("Empty list: no error " + findEmpty(false).size());
    }

}
