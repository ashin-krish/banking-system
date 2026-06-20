package ui;

import service.AccountService;
import service.CustomerService;
import model.Account;
import model.Account.AccountStatus;
import model.Account.AccountType;

public class TestApp {

    public static void main(String[] args) {

        // ✅ safety check
        if (args.length < 4) {
            System.out.println("Usage: create <accountNumber> <name> <balance>");
            return;
        }

        String command = args[0];

        CustomerService customerService = new CustomerService();

        AccountService service = new AccountService(customerService);

        // ❗ only handle "create" command for now
        if (!command.equals("create")) {
            System.out.println("Invalid command");
            return;
        }

        try {
            int accountNumber = Integer.parseInt(args[1]);
            String name = args[2];
                int balance = Integer.parseInt(args[3]);

        Account account = new Account(accountNumber, name, balance, AccountType.SAVINGS,AccountStatus.ACTIVE,"CUS1011");
        
            service.createAccount(account);

            System.out.println("Account created successfully: " + accountNumber);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}