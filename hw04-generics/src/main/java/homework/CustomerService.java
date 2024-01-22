package homework;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    private final TreeMap<Customer, String> customerMap = new TreeMap<>(Comparator.comparing(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        return getEntry(customerMap.firstKey(), customerMap.firstEntry().getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return getEntry(
                customerMap.higherKey(customer),
                customerMap.ceilingEntry(customer).getValue());
    }

    public void add(Customer customer, String data) {
        customerMap.put(customer, data);
    }

    private Map.Entry<Customer, String> getEntry(Customer customer, String value) {
        return customer == null
                ? null
                : new AbstractMap.SimpleEntry<>(
                        new Customer(customer.getId(), customer.getName(), customer.getScores()), value);
    }
}
