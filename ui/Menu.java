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
        System.out.println("[2] View Account By Account Number");
        System.out.println("[3] View Account By Customer Id");
        System.out.println("[4] Deposit");
        System.out.println("[5] Withdraw");
        System.out.println("[6] Transfer");
        System.out.println("[7] Delete Account");
        System.out.println("[8] View Account With Minimum Balance");
        System.out.println("[9] View Blocked Account ");
        System.out.println("[10] View Active Account ");
        System.out.println("[0] Back");

        consoleUI.line();
        System.out.print("Enter Choice: ");
    }

    public static void showCustomerMenu() {
        consoleUI.header("Customer Management");

        System.out.println("[1] Add Customer");
        System.out.println("[2] Search By Email");
        System.out.println("[3] Search By Customer Id");
        System.out.println("[4] Search By Phone Number");
        System.out.println("[5] View All Customers");
        System.out.println("[6] Update Customer");
        System.out.println("[7] Delete Customer");
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