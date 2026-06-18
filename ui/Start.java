package ui;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import exception.AccountNotFoundException;
import exception.CustomerNotFoundException;
import exception.DuplicateAccountException;
import exception.DuplicateCustomerException;
import exception.DuplicateLoanException;
import exception.InsufficientBalanceException;
import exception.LoanNotFoundException;
import model.Account;
import model.Customer;
import model.Loan;
import model.Transaction;
import service.AccountService;
import service.CustomerService;
import service.LoanService;

public class Start {

    private static AccountService accountService = new AccountService();

    private static CustomerService customerservice = new CustomerService();

    private static LoanService loanservice = new LoanService();

    public static void accountMenu(Scanner sc) {

        while (true) {

            Menu.showAccountMenu();

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    int balance = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Account Type (Savings/Current/fixed):");
                    String accountType = sc.nextLine();

                    try {
                        Account account = new Account(
                                accountNumber,
                                accountHolderName,
                                balance,
                                accountType);

                        accountService.createAccount(account);
                        System.out.println("Account " + accountNumber + " created successfully.");

                    } catch (DuplicateAccountException | IllegalArgumentException | IOException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    int searchId;
                    try {
                        System.out.print("Enter Account Number: ");
                        searchId = sc.nextInt();
                        sc.nextLine();

                        Account account = accountService.viewAccount(searchId);

                        System.out.println(account);
                    } catch (AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    int amount;

                    try {

                        System.out.println(" Enter the Amount To Deposit ");
                        amount = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter the Account Number  To Deposit");
                        accountNumber = sc.nextInt();
                        sc.nextLine();

                        accountService.deposit(amount, accountNumber);
                        System.out.println("Deposit successful.");
                    } catch (IllegalArgumentException | AccountNotFoundException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:

                    try {

                        System.out.println(" Enter the Amount To WithDraw ");
                        amount = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter the Account Number  To WithDrawn");
                        accountNumber = sc.nextInt();
                        sc.nextLine();

                        accountService.withDraw(amount, accountNumber);
                        System.out.println("Withdrawal successful.");
                    } catch (IllegalArgumentException | AccountNotFoundException | InsufficientBalanceException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:

                    try {
                        int fromAccountId, toAccountId;

                        System.out.print("Enter Sender Account Number: ");
                        fromAccountId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Receiver Account Number: ");
                        toAccountId = sc.nextInt();
                        sc.nextLine();

                        System.out.println(" Enter the Amount To Transfer ");
                        amount = sc.nextInt();
                        sc.nextLine();

                        accountService.transferMoney(fromAccountId, toAccountId, amount);
                        System.out.println("Transfer successful.");

                    } catch (IllegalArgumentException | AccountNotFoundException | InsufficientBalanceException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {

                        System.out.print("Enter Account Number: ");
                        accountNumber = sc.nextInt();
                        sc.nextLine();

                        accountService.deleteAccount(accountNumber);

                        System.out.println("Account Deleted successful.");

                    } catch (AccountNotFoundException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void customerMenu(Scanner sc) {

        while (true) {

            Menu.showCustomerMenu();

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter DOB (dd-mm-yyyy): ");
                    String dob = sc.nextLine();

                    try {

                        Customer customer = new Customer(name, email, phone, address, dob);

                        customerservice.addCustomer(customer);

                    } catch (DuplicateCustomerException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    try {
                        System.out.print("Enter The Email Id : ");
                        email = sc.nextLine();

                        Customer customer = customerservice.viewCustomer(email);

                        System.out.println(customer);
                    } catch (CustomerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    for(Customer customer : customerservice.viewAllCustomers())
                    {
                        System.out.println(customer);
                    }
                    break;

                case 4:
                    try {

                        System.out.print(" Enter the Old Email : ");
                        email = sc.nextLine();

                        System.out.println("Enter the New Email To Update");
                        String newEmail = sc.nextLine();

                        customerservice.updateCustomerEmail(email, newEmail);

                        System.out.println(" Updation Succesfull ");
                    }

                    catch (CustomerNotFoundException e) {
                        System.out.println(e.getMessage());

                    }
                    break;

                case 5:
                    try {
                        System.out.println(" Enter The Customer Email ");
                        email = sc.nextLine();

                        customerservice.delCustomer(email);

                        System.out.println(" Customer Deleted Succesfully ");
                    } catch (IllegalArgumentException | CustomerNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Enter a Valid Choice ");
                    break;

            }
        }
    }

        public static void loanMenu(Scanner sc) {

        while (true) {

            Menu.showLoanMenu();

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                System.out.print("Enter Loan Type: ");
                String loanType = sc.nextLine();

                System.out.print("Enter Loan Amount: ");
                int loanAmount = Integer.parseInt(sc.nextLine());

                System.out.print("Enter Interest Rate: ");
                double interestRate = Double.parseDouble(sc.nextLine());

                    try {
                        Loan loan = new Loan(
                                loanType,
                                loanAmount,
                                interestRate);

                        loanservice.applyLoan(loan);
                        System.out.println("Loan created successfully.");

                    } catch (DuplicateLoanException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    try 
                    
                    {
                        String loanId;

                        System.out.print("Enter Loan Id: ");
                        loanId = sc.nextLine();
                       

                        Loan loan = loanservice.getloanById(loanId);

                        System.out.println(loan);
                    } 
                    
                    catch (LoanNotFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
               
                    for(Loan loan : loanservice.getAllLoans())
                    {
                        System.out.println(loan);
                    }
                    break;

                case 4:

                    try 
                    
                    {

                        String loanId;
                        System.out.print("Enter Loan Id: ");
                        loanId = sc.nextLine();

                        loanservice.removeLoan(loanId);
                       


                        System.out.println(" Loan Deleted Succesfully ");
                    } 
                    
                    catch (LoanNotFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:

                     try 
                    
                    {
                        String loanId;
                        System.out.print("Enter Loan Id: ");
                        loanId = sc.nextLine();

                       double interest = loanservice.calculateInterest(loanId);
                       


                        System.out.println(" Interest : " + interest);
                    } 
                    
                    catch (LoanNotFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println(" Enter the loan Type ");
                    loanType = sc.nextLine();

              List<Loan> loans = loanservice.getLoansByType(loanType);

                    if (loans.isEmpty()) {
                        System.out.println("No loans found.");
                    } else {
                        for (Loan loan : loans) {
                            System.out.println(loan);
                        }
                            }
                    break;

              
                case 0:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void transactionMenu(Scanner sc)
    {
       int accountNumber;

        System.out.println(" Enter the account Number ");
        accountNumber = sc.nextInt();
        sc.nextLine();

        
        
        try
        {
            List<Transaction> transactions = accountService.getTransactionsByAccount(accountNumber);

            for (Transaction transaction : transactions) 
            {
                System.out.println(transaction);
            }
        }
        catch(AccountNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            Menu.showMainMenu();

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {

                case 1:
                    accountMenu(sc);
                    break;

                case 2:
                    customerMenu(sc);
                    break;

                case 3:
                    loanMenu(sc);
                    break;

                case 4:
                    transactionMenu(sc);
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}