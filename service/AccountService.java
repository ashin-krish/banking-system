package service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exception.DuplicateAccountException;
import exception.InsufficientBalanceException;
import exception.AccountNotFoundException;

import model.Account;
import model.Transaction;
import model.Transaction.TransactionType;
import persistence.*;

public class AccountService {

private List<Account> accounts = new ArrayList<>();


AccountFileHandler accountFileHandler = new AccountFileHandler();

TranscationService transcationService = new TranscationService();

public AccountService()
{
    accounts=accountFileHandler.loadFile();
}

    public void createAccount(Account account)

            throws DuplicateAccountException,IOException

    {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        for (Account existingAccount : accounts) {
            if (account.getAccountNumber() == existingAccount.getAccountNumber()) {
                throw new DuplicateAccountException("Duplicate account");
            }

        }

        accounts.add(account);
        accountFileHandler.saveAllAccounts(accounts);
     
       
    }

    public Account viewAccount(int accountNumber)

            throws AccountNotFoundException

    {

        for (Account availableAccount : accounts) {
            if (accountNumber == availableAccount.getAccountNumber()) {

                return availableAccount;

            }

        }

        throw new AccountNotFoundException("No Account Found");
    }

    public void deposit(int amount, int accountNumber)

            throws AccountNotFoundException,IOException {

        if (amount <= 0) {
            throw new IllegalArgumentException(" Enter a Positive amount ");
        }
        for (Account depositAccount : accounts) {
            if (accountNumber == depositAccount.getAccountNumber()) {
                depositAccount.setBalance(depositAccount.getBalance() + amount);
                Transaction transaction = new Transaction( accountNumber, TransactionType.DEPOSIT, amount, LocalDateTime.now());
                transcationService.recordTranscation(transaction);
               
                accountFileHandler.saveAllAccounts(accounts);
                return;
            }

        }

        throw new AccountNotFoundException("No Account Found");

    }

    public void withDraw(int amount, int accountNumber)

            throws AccountNotFoundException, InsufficientBalanceException,IOException

    {

        if (amount <= 0) {
            throw new IllegalArgumentException(" Enter a Positive amount ");
        }

        for (Account withDrawAccount : accounts) {
            if (accountNumber == withDrawAccount.getAccountNumber()) {
                if (amount > withDrawAccount.getBalance()) {
                    throw new InsufficientBalanceException("Insufficient Balnce ");
                }

                withDrawAccount.setBalance(withDrawAccount.getBalance() - amount);
                 Transaction transaction = new Transaction( accountNumber, TransactionType.WITHDRAW, amount, LocalDateTime.now());
                 transcationService.recordTranscation(transaction);
                 accountFileHandler.saveAllAccounts(accounts);
                return;

            }

        }

        throw new AccountNotFoundException("No Account Found");

    }

    public void transferMoney(int fromAccountId, int toAccountId, int amount)

            throws AccountNotFoundException, InsufficientBalanceException,IOException

    {

        if (amount <= 0) {
            throw new IllegalArgumentException("Enter a positive value");
        }

        if (fromAccountId == toAccountId) {
            throw new IllegalArgumentException("receiver cannot be the same Account");
        }

        

        Account sender = viewAccount(fromAccountId);
        Account receiver = viewAccount(toAccountId);

        if (amount > sender.getBalance()) {
            throw new InsufficientBalanceException(" Insuffucent balanace ");

        }

        sender.setBalance(sender.getBalance() - amount);

        receiver.setBalance(receiver.getBalance() + amount);

        accountFileHandler.saveAllAccounts(accounts);


         Transaction sendertransaction = new Transaction(fromAccountId, TransactionType.TRANSFER_OUT, amount, LocalDateTime.now());
         Transaction receiverTransaction= new Transaction(toAccountId, TransactionType.TRANSFER_IN, amount, LocalDateTime.now());
         transcationService.recordTranscation(receiverTransaction);
         transcationService.recordTranscation(sendertransaction);

    }


    public void deleteAccount(int accountId)
    throws AccountNotFoundException,IOException
    {
        Account delAccount = viewAccount(accountId);

        accounts.remove(delAccount);
        accountFileHandler.saveAllAccounts(accounts);
    }


      public List<Transaction> getTranscationHistory(int accountNumber)
      {
        return transcationService.getTransactionsByAccount(accountNumber);
      }


}
