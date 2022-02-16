package at.htlklu.nsvs.rentApp.server.service;

import at.htlklu.nsvs.rentApp.server.model.Customer;
import at.htlklu.nsvs.rentApp.server.service.interfaces.CustomerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Service
@Scope("singleton")
public class CustomerServiceImpl implements CustomerService {

    private ArrayList<Customer> customers = new ArrayList<Customer>();

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setUuid(UUID.randomUUID().toString());
        customers.add(customer);
        return customer;
    }

    @Override
    public Customer[] listAllCustomers() {
        Customer[] customerArray = customers.toArray(new Customer[customers.size()]);
        return customerArray;
    }

    @Override
    public Customer updateCustomer(String uuid, String surname, String firstname, LocalDate dateOfBirth) {
        Customer customer = customers.stream().filter(v -> v.getUuid().equals(uuid)).findFirst().get();
        customer.setSurname(surname);
        customer.setFirstname(firstname);
        customer.setDateOfBirth(dateOfBirth);

        return customer;
    }

    @Override
    public void deleteCustomer(String uuid) {
        Customer customer = customers.stream().filter(v -> v.getUuid().equals(uuid)).findFirst().get();
        customers.remove(customer);
    }
}