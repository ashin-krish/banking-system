package service;

import java.util.ArrayList;
import java.util.List;

import model.*;
import persistence.TranscationFileHandler;

public class TranscationService 

{

    TranscationFileHandler transcationFileHandler = new TranscationFileHandler();

    private List<Transaction> transactions = new ArrayList<>();

   public TranscationService()
    {
        transactions = transcationFileHandler.loadTransactions();
    }

    public void recordTranscation(Transaction transaction)
    {
        transactions.add(transaction);
        transcationFileHandler.saveTransactionFile(transactions);

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
