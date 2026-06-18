package ui;

import service.AccountService;
import model.Account;

public class TestApp {

    public static void main(String[] args) {

        // ✅ safety check
        if (args.length < 4) {
            System.out.println("Usage: create <accountNumber> <name> <balance>");
            return;
        }

        String command = args[0];

        AccountService service = new AccountService();

        // ❗ only handle "create" command for now
        if (!command.equals("create")) {
            System.out.println("Invalid command");
            return;
        }

        try {
            int accountNumber = Integer.parseInt(args[1]);
            String name = args[2];
                int balance = Integer.parseInt(args[3]);

        Account account = new Account(accountNumber, name, balance, "Savings");
        
            service.createAccount(account);

            System.out.println("Account created successfully: " + accountNumber);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}