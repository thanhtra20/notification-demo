package lesson11;

import java.util.Objects;
import java.util.Optional;

import lesson2.Address;
import lesson2.Customer;

public class NullExericse {

    public static void main(String[] args) {

        // if (a != null && a.getB() != null && a.getB().getC() != null) {
        // return a.getB().getC().getName();
        // }
        // return "N/A";

        // Co 2 cach pho bien:
        //1. Optional + map

            Address a = new Address("Hamburg");
            System.out.println(getCity(a));

            Customer c = new Customer(1, "Mangoiess");
            System.out.println();
    }

    
    static String getCity(Address a) {
        return Optional.ofNullable(a).map(Address::getCity).orElse("Nothing found");
    }

    //Objects.requireNonNullElse();
    static String getName(Customer c) {
        return Objects.requireNonNullElse(c.getName(), "Camellia");
    }

}