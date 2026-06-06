package service;

import java.util.ArrayList;
import java.util.List;


import model.Customer;
import exception.CustomerNotFoundException;
import exception.DuplicateCustomerException;

public class CustomerService 
{
  

    private List<Customer> customers  = new ArrayList<>();

    public void addCustomer(Customer customer)

    throws DuplicateCustomerException

    {
         if(customer == null)
         {
            throw new IllegalArgumentException("Customer Cannot Be Null");
         }
         

         for (Customer existingCustomer : customers) 
        {

            if(customer.getCustomerId().equals(existingCustomer.getCustomerId()))
            {
                throw new DuplicateCustomerException(" Account Already Exist ");
            }

         }

         customers.add(customer);

    }


     public Customer viewCustomer(String email)

            throws CustomerNotFoundException

    {

        if(email == null || email.trim().isEmpty())
        {
            throw new IllegalArgumentException("Email Cannot Be Empty");
        }

        for (Customer existingCustomer : customers) {
            if (email.equals(existingCustomer.getEmail())) {

                return existingCustomer;

            }

        }

        throw new CustomerNotFoundException("No Customer Found");
    }

    public Customer viewAllCustomer()
    {
        for (Customer existingCustomer : customers) 
        {
             return existingCustomer;
        }
        return null;
    }





    
}