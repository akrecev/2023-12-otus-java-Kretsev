package homework;

import java.util.*;

public class CustomerReverseOrder {
    private final Deque<Customer> customerList = new LinkedList<>();

    public void add(Customer customer) {
        customerList.addFirst(customer);
    }

    public Customer take() {
        return customerList.pollFirst();
    }
}
