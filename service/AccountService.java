package service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exception.DuplicateAccountException;
import exception.InsufficientBalanceException;
import exception.AccountNotFoundException;
import exception.CustomerNotFoundException;
import model.Account;
import model.Transaction;
import model.Account.AccountStatus;
import model.Transaction.TransactionType;
import persistence.*;

public class AccountService {

    private List<Account> accounts = new ArrayList<>();

    private CustomerService customerService; 

    AccountFileHandler accountFileHandler = new AccountFileHandler();

    TransactionService transactionService = new TransactionService();

    public AccountService(CustomerService customerService) 
    {
        this.customerService=customerService;

        accounts = accountFileHandler.loadFile();
    }

    public void createAccount(Account account)

            throws DuplicateAccountException, IOException,CustomerNotFoundException

    {
        
            
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }

            

        for (Account existingAccount : accounts) {
            if (account.getAccountNumber() == existingAccount.getAccountNumber()) {
                throw new DuplicateAccountException("Duplicate account");
            }

        }
        customerService.searchById(account.getCustomerId());
        accounts.add(account);
        accountFileHandler.saveAllAccounts(accounts);

    }

    public Account searchByAccountNumber(int accountNumber)

            throws AccountNotFoundException

    {

        for (Account availableAccount : accounts) {
            if (accountNumber == availableAccount.getAccountNumber()) {

                return availableAccount;

            }

        }

        throw new AccountNotFoundException("No Account Found");
    }

    public List<Account> searchByCustomerId(String customerId)
    throws CustomerNotFoundException,AccountNotFoundException
    {
         if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }

            customerService.searchById(customerId);

          List<Account> result = new ArrayList<>();



        for (Account existingAccount : accounts) 
        {
            if(customerId.equals(existingAccount.getCustomerId()))
            {
                result.add(existingAccount);
            }
        }

        if (result.isEmpty()) {
        throw new AccountNotFoundException("No accounts found for customer: " + customerId);
    }

        return result;
         
    }


    public List<Account> getAccountWithMinBalance(int minBalace)
    {

        List<Account> results = new ArrayList<>();

        for (Account existingAccount : accounts) 
        {
            if(existingAccount.getBalance() > minBalace)
            {
                results.add(existingAccount);
            }
        }

        return results;
    }

    public List<Account> getBlockedAccounts()
    {
        List<Account> results = new ArrayList<>();

          for (Account existingAccount : accounts) 
        {
            if(existingAccount.getAccountStatus() == AccountStatus.BLOCKED)
            {
                results.add(existingAccount);
            }
        }



            return results;
    }


       public List<Account> getActiveAccounts()
    {
        List<Account> results = new ArrayList<>();

          for (Account existingAccount : accounts) 
        {
            if(existingAccount.getAccountStatus() == AccountStatus.ACTIVE)
            {
                results.add(existingAccount);
            }
        }



            return results;
    }




    public void deposit(int amount, int accountNumber)

            throws AccountNotFoundException, IOException {

        if (amount <= 0) {
            throw new IllegalArgumentException(" Enter a Positive amount ");
        }
        for (Account depositAccount : accounts) {
            if (accountNumber == depositAccount.getAccountNumber()) {

                if (depositAccount.getAccountStatus() == AccountStatus.CLOSED) {
                    throw new IllegalStateException("Account is Closed");

                }

                depositAccount.setBalance(depositAccount.getBalance() + amount);
                Transaction transaction = new Transaction(accountNumber, TransactionType.DEPOSIT, amount,
                        LocalDateTime.now());
                transactionService.recordTransaction(transaction);

                accountFileHandler.saveAllAccounts(accounts);
                return;
            }

        }

        throw new AccountNotFoundException("No Account Found");

    }

    public void withDraw(int amount, int accountNumber)

            throws AccountNotFoundException, InsufficientBalanceException, IOException

    {

        if (amount <= 0) {
            throw new IllegalArgumentException(" Enter a Positive amount ");
        }

        for (Account withDrawAccount : accounts) {
            if (accountNumber == withDrawAccount.getAccountNumber()) {

                if (withDrawAccount.getAccountStatus() == AccountStatus.CLOSED
                        || withDrawAccount.getAccountStatus() == AccountStatus.BLOCKED) {
                    throw new IllegalStateException("Account is Closed or Blocked");

                }
                if (amount > withDrawAccount.getBalance()) {
                    throw new InsufficientBalanceException("Insufficient Balance");
                }

                withDrawAccount.setBalance(withDrawAccount.getBalance() - amount);
                Transaction transaction = new Transaction(accountNumber, TransactionType.WITHDRAW, amount,
                        LocalDateTime.now());
                transactionService.recordTransaction(transaction);
                accountFileHandler.saveAllAccounts(accounts);
                return;

            }

        }

        throw new AccountNotFoundException("No Account Found");

    }

    public void transferMoney(int fromAccountId, int toAccountId, int amount)

            throws AccountNotFoundException, InsufficientBalanceException, IOException

    {

        if (amount <= 0) {
            throw new IllegalArgumentException("Enter a positive value");
        }

        if (fromAccountId == toAccountId) {
            throw new IllegalArgumentException("receiver cannot be the same Account");
        }

        Account sender = searchByAccountNumber(fromAccountId);
        Account receiver = searchByAccountNumber(toAccountId);

        if (sender.getAccountStatus() == AccountStatus.BLOCKED || sender.getAccountStatus() == AccountStatus.CLOSED
                || receiver.getAccountStatus() == AccountStatus.BLOCKED
                || receiver.getAccountStatus() == AccountStatus.CLOSED)

        {
            throw new IllegalStateException("Account is Closed or Blocked");
        }

        if (amount > sender.getBalance()) {
            throw new InsufficientBalanceException(" Insufficient balance ");

        }

        sender.setBalance(sender.getBalance() - amount);

        receiver.setBalance(receiver.getBalance() + amount);

        accountFileHandler.saveAllAccounts(accounts);

        Transaction sendertransaction = new Transaction(fromAccountId, TransactionType.TRANSFER_OUT, amount,
                LocalDateTime.now());
        Transaction receiverTransaction = new Transaction(toAccountId, TransactionType.TRANSFER_IN, amount,
                LocalDateTime.now());
        transactionService.recordTransaction(receiverTransaction);
        transactionService.recordTransaction(sendertransaction);

    }

    public void deleteAccount(int accountId)
            throws AccountNotFoundException, IOException {
        Account account = searchByAccountNumber(accountId);
                if (account.getAccountStatus() == AccountStatus.CLOSED) {
        throw new IllegalStateException("Account is already closed");
    }
            account.setAccountStatus(AccountStatus.CLOSED);
        accountFileHandler.saveAllAccounts(accounts);
    }

    public List<Transaction> getTransactionHistory(int accountNumber) {
        return transactionService.getTransactionsByAccount(accountNumber);
    }

}
