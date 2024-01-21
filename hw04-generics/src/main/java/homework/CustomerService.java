package homework;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    private final TreeMap<Customer, String> customerMap = new TreeMap<>(Comparator.comparing(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {

        return customerMap.firstKey() == null
                ? null
                : new AbstractMap.SimpleEntry<>(
                        new Customer(
                                customerMap.firstKey().getId(),
                                customerMap.firstKey().getName(),
                                customerMap.firstKey().getScores()),
                        customerMap.firstEntry().getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return customerMap.higherKey(customer) == null
                ? null
                : new AbstractMap.SimpleEntry<>(
                        new Customer(
                                customerMap.higherKey(customer).getId(),
                                customerMap.higherKey(customer).getName(),
                                customerMap.higherKey(customer).getScores()),
                        customerMap.ceilingEntry(customer).getValue());
    }

    public void add(Customer customer, String data) {
        customerMap.put(customer, data);
    }
}
