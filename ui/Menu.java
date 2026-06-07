package ui;

public class Menu {

    public static void showMainMenu() {
        consoleUI.header("Bank Management System");

        System.out.println("[1] Account Management");
        System.out.println("[2] Customer Management");
        System.out.println("[3] Loan Management");
        System.out.println("[4] Transaction History");
        System.out.println("[0] Exit");

        consoleUI.line();
        System.out.print("Enter Choice: ");
    }

    public static void showAccountMenu() {
        consoleUI.header("Account Management");

        System.out.println("[1] Create Account");
        System.out.println("[2] View Account");
        System.out.println("[3] Deposit");
        System.out.println("[4] Withdraw");
        System.out.println("[5] Transfer");
        System.out.println("[6] Delete Account");
        System.out.println("[0] Back");

        consoleUI.line();
        System.out.print("Enter Choice: ");
    }

    public static void showCustomerMenu() {
        consoleUI.header("Customer Management");

        System.out.println("[1] Add Customer");
        System.out.println("[2] View Customer");
        System.out.println("[3] View All Customers");
        System.out.println("[4] Update Customer");
        System.out.println("[5] Delete Customer");
        System.out.println("[0] Back");

        consoleUI.line();
        System.out.print("Enter Choice: ");
    }

    public static void showLoanMenu() {
        consoleUI.header("Loan Management");

        System.out.println("[1] Apply Loan");
        System.out.println("[2] View Loan");
        System.out.println("[3] View All Loans");
        System.out.println("[4] Remove Loan");
        System.out.println("[5] Calculate Interest");
        System.out.println("[6] View Loans By Type");
        System.out.println("[0] Back");

        consoleUI.line();
        System.out.print("Enter Choice: ");
    }
}