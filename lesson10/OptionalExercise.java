package lesson10;

import java.util.List;
import java.util.Optional;

import lesson2.Address;
import lesson2.Customer;

public class OptionalExercise {

    // Viết findCustomerById trả Optional<Customer>

    public static Optional<Customer> findById(List<Customer> customers, long id) {

        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public static String getCity(List<Customer> customers, long id) {
        return findById(customers, id)
                .map(Customer::getAddress)
                .map(Address::getCity)
                .orElse("UNKNOWN");
    }

    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer(1, "An", new Address("Hà Nội")),
                new Customer(2, "Bình", null));

        System.out.println(getCity(customers, 1));
        System.out.println(getCity(customers, 2));

    }

}
