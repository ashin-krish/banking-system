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

            if(customer.getEmail().equals(existingCustomer.getEmail()))
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

    public List<Customer> viewAllCustomers()
    {
        return new ArrayList<>(customers);
    }

public void updateCustomerEmail(String oldEmail,String newEmail )
        throws CustomerNotFoundException {

    for (Customer customer : customers) {
        if (customer.getCustomerId().equals(oldEmail)) {
            customer.setEmail(newEmail);
            return;
        }
    }

    throw new CustomerNotFoundException("Customer not found");
}

public void delCustomer(String email)

 throws CustomerNotFoundException

{

    if(email == null)
{
    throw new IllegalArgumentException("Customer cannot be null");
} 

viewCustomer(email);


 for (Customer existingCustomer : customers) 
 {
     if(email.equals(existingCustomer.getEmail()))
     {

         customers.remove(existingCustomer);
     }
 }



}



}





        
