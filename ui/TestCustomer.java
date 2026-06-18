package ui;

import model.Customer;
import service.CustomerService;

public class TestCustomer {

    public static void main(String[] args) {

        // format: create name email phone address dob
        if (args.length < 6) {
            System.out.println("Usage: create <name> <email> <phone> <address> <dob>");
            return;
        }

        String command = args[0];

        if (!command.equals("create")) {
            System.out.println("Invalid command");
            return;
        }

        try {
            CustomerService service = new CustomerService();

            String name = args[1];
            String email = args[2];
            String phone = args[3];
            String address = args[4];
            String dob = args[5];

            Customer customer = new Customer(name, email, phone, address, dob);

            service.addCustomer(customer);

            System.out.println("Customer created successfully: " + customer.getCustomerId());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}