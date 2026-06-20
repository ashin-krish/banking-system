package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import persistence.CustomerFileHandler;
import exception.CustomerNotFoundException;
import exception.DuplicateCustomerException;

public class CustomerService {

    private List<Customer> customers = new ArrayList<>();

    CustomerFileHandler customerFileHandler = new CustomerFileHandler();

    public CustomerService() {
        customers = customerFileHandler.loadCustomer();
    }

    public void addCustomer(Customer customer)

            throws DuplicateCustomerException, IOException

    {
        if (customer == null) {
            throw new IllegalArgumentException("Customer Cannot Be Null");
        }

        for (Customer existingCustomer : customers) {

            if (customer.getEmail().equals(existingCustomer.getEmail())) {
                throw new DuplicateCustomerException(" Account Already Exist ");
            }

        }

        customers.add(customer);
        customerFileHandler.saveFile(customers);

    }

    public Customer searchByEmail(String email)

            throws CustomerNotFoundException

    {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email Cannot Be Empty");
        }

        for (Customer existingCustomer : customers) {
            if (email.equals(existingCustomer.getEmail())) {

                return existingCustomer;

            }

        }

        throw new CustomerNotFoundException("No Customer Found" + email);
    }

    public List<Customer> viewAllCustomers() {
        return new ArrayList<>(customers);
    }

public void updateCustomerEmail(String oldEmail, String newEmail)
        throws CustomerNotFoundException, IOException, DuplicateCustomerException {

    if (oldEmail == null || newEmail == null ||
        oldEmail.trim().isEmpty() || newEmail.trim().isEmpty()) {
        throw new IllegalArgumentException("Emails cannot be null or empty");
    }

   
    for (Customer c : customers) {
        if (newEmail.equals(c.getEmail())) {
            throw new DuplicateCustomerException("Email already exists: " + newEmail);
        }
    }

   
    for (Customer customer : customers) {
        if (oldEmail.equals(customer.getEmail())) {
            customer.setEmail(newEmail);
            customerFileHandler.saveFile(customers);
            return;
        }
    }

    throw new CustomerNotFoundException("Customer not found: " + oldEmail);
}

    public void delCustomer(String email)

            throws CustomerNotFoundException, IOException

    {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        boolean removed = customers.removeIf(c -> email.equals(c.getEmail()));

        if (!removed) {
            throw new CustomerNotFoundException(" Customer Not Found ");
        }

        customerFileHandler.saveFile(customers);

    }

    public Customer searchById(String customerId)
    throws CustomerNotFoundException
    {
        System.out.println("Customer count = " + customers.size());
        System.out.println("Input ID = [" + customerId + "]");

        if(customerId == null || customerId.isEmpty())
        {
            throw new IllegalArgumentException("Enter a proper search input");
        }
        for (Customer existingCustomer : customers) {
            if(customerId.equals(existingCustomer.getCustomerId()))
            {
                System.out.println("Stored ID = [" + existingCustomer.getCustomerId() + "]");
                return existingCustomer;
            }
        }

        throw new CustomerNotFoundException(" No Customer Found " + customerId);
    }

    public Customer searchByPhoneNo(String phone)
    throws CustomerNotFoundException
    {

                if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException(" Enter a Proper Search Input ");
        }
                for (Customer existingCustomer : customers) {
            if(phone.equals(existingCustomer.getPhoneNumber()))
            {
                return existingCustomer;
            }
        }

        throw new CustomerNotFoundException(" No customer Found " + phone);

    }

}
