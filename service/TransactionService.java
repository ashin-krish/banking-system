package service;

import java.util.ArrayList;
import java.util.List;

import model.*;
import persistence.TransactionFileHandler;

public class TransactionService 

{

    TransactionFileHandler transactionFileHandler = new TransactionFileHandler();

    private List<Transaction> transactions = new ArrayList<>();

   public TransactionService()
    {
        transactions = transactionFileHandler.loadTransactions();
    }

    public void recordTransaction(Transaction transaction)
    {
        transactions.add(transaction);
        transactionFileHandler.saveTransactionFile(transactions);

    }

    public List<Transaction> getTransactionsByAccount(int accountNumber)
    {
        List<Transaction> result = new ArrayList<>();

        for (Transaction existingTransaction : transactions) 
        {
            if(existingTransaction.getAccountNumber() == accountNumber)
            {
                result.add(existingTransaction);
            }
        }

        return result;
    }


}
