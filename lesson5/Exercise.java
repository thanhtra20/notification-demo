package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
     public static void main(String[] args) {
        // UnsupportedOperationException when running
        List<String> colors = List.of("yellow", "orange");
        // colors.add("mint");

        // List.copyOf => van bi loi UnsupportedOperationException neu khong try catch
        // va list copy bat bien
        // List<String> copyList = List.copyOf(colors);
        // try {
        //     copyList.add("blue");
        // } catch (UnsupportedOperationException e) {
        //     System.out.println(copyList);
        // }
        //new ArrayList
        List<String> usingArrayList = new ArrayList<>(colors);
        usingArrayList.add("pink");
        System.out.println(usingArrayList);
    }
}
