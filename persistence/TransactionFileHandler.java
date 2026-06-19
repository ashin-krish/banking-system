package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import model.Transaction;
import model.Transaction.TransactionType;

public class TransactionFileHandler 

{
    
    public List<Transaction> loadTransactions()
    {
        List<Transaction> transactions = new ArrayList<>();

        File f = new File("data/transaction_data.csv");

        if(!f.exists())
        {
            return transactions;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(f)))
        {
            br.readLine();

            String line;

            while((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                if(data.length == 5 )
                {   
                    int accountNumber = Integer.parseInt(data[1]);
                    TransactionType transactionType = TransactionType.valueOf(data[2]);
                    int amount = Integer.parseInt(data[3]);
                    LocalDateTime transactionDateTime = LocalDateTime.parse(data[4]);

                    Transaction transaction = new Transaction(accountNumber, transactionType, amount, transactionDateTime);
                    transactions.add(transaction);

                }

                else
                {
                    System.out.println("Invalid Format" + line);
                    continue;
                }

            }
            return  transactions;
        }

        catch(IOException e)
        {
            System.out.println(e);
        }
        catch(NumberFormatException e)
        {
            System.out.println(e);
        }

        return transactions;
    }


    public void saveTransactionFile(List<Transaction> transactions)
    {
        File f = new File("data/transaction_data.csv");

        try(FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw))
                {
                    
                    bw.write("transactionId,accountNumber,TransactionType,amount,transactionDatetime");
                    bw.newLine();
                    
                    for (Transaction existingTransaction : transactions) 
                    {
                        
                            bw.write(existingTransaction.getTransactionId() + "," +
                                    existingTransaction.getAccountNumber() + "," +
                                    existingTransaction.getTransactionType() + "," +
                                    existingTransaction.getAmount() + "," +
                                    existingTransaction.getTransactionDateTime());

                                    bw.newLine();

                    }
                }
                catch(IOException e)
                {
                    System.out.println(e);
                }

    }
  


    
}
