package examen_opgave1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerRepository {
    private Map<String, Customer> customers = new HashMap<>();

    public CustomerRepository() {
        for (Customer customer : Customers.customers) {
            customers.put(customer.getCustomerNumber(), customer);
        }
    }

    public Customer getByCustomerNumber(String customerNumber) {
        return customers.keySet()
                .stream()
                .filter(key -> key.equals(customerNumber))
                .map(customers::get)
                .findFirst()
                .get();
    }

    public List<Customer> findAll() {
        return customers.values()
                .stream()
                .collect(Collectors.toList());
    }
}
