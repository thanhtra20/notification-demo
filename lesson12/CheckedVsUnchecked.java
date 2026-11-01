package lesson12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedVsUnchecked {
    public static void main(String[] args) {
        // try {
        //     BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        // } catch (FileNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        //     System.out.println("Không đọc được file: " + e.getMessage());

        // }
        int a = 20; 
        int b = 0;
        System.out.println(a/b);

    }
}
