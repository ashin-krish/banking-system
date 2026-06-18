package ui;


import model.Customer;

import service.CustomerService;

public class TestCustomer 
{
     public static void main(String[] args) {

        // ✅ safety check
        if (args.length < 6) {
            System.out.println("Usage: create <accountNumber> <name> <balance>");
            return;
        }

        String command = args[0];

        CustomerService service = new CustomerService();

        // ❗ only handle "create" command for now
        if (!command.equals("create")) {
            System.out.println("Invalid command");
            return;
        }

        try {
           
            String name = args[0];
            String email = args[1];
            String phone = args[2];
            String address = args[3];
            String dob = args[4];

            Customer customer = new Customer(name, email, phone, address, dob);

            service.addCustomer(customer);

            System.out.println(" Customer Created succesfully " + customer.getCustomerId());
            

       

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
