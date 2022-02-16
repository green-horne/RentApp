package at.htlklu.nsvs.rentApp.server.service.interfaces;

import at.htlklu.nsvs.rentApp.server.model.Customer;

import java.time.LocalDate;

public interface CustomerService {

    public Customer createCustomer(Customer customer);
    public Customer[] listAllCustomers();
    public Customer updateCustomer(String uuid, String surname, String firstname, LocalDate dateOfBirth);
    public void deleteCustomer(String uuid);
}