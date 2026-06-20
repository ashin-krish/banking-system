package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import model.Account;

import model.Account.AccountStatus;
import model.Account.AccountType;

public class AccountFileHandler {

    public List<Account> loadFile()

    {

        List<Account> accounts = new ArrayList<>();

        File file = new File("data/account_data.csv");

        if (!file.exists()) {

            return accounts;

        }

        try (BufferedReader br = new BufferedReader(new FileReader(file)))

        {
            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 6) {
                    int accountNumber = Integer.parseInt(data[0]);
                    String accountHolderName = data[1];
                    int balance = Integer.parseInt(data[2]);
                    AccountType accountType = AccountType.valueOf(data[3]);
                    AccountStatus accountStatus = AccountStatus.valueOf(data[4]);
                    String customerId = data[5];

                    Account account = new Account(accountNumber, accountHolderName, balance, accountType,accountStatus,customerId);

                    accounts.add(account);

                }

                else

                {
                    System.out.println(" Invalid record found ");
                    continue;
                }

            }
            return accounts;

        } catch (IOException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        return accounts;
    }

    public void saveAllAccounts(List<Account> accounts)
            throws IOException {
        File file = new File("data/account_data.csv");

        try (
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw)) {
       
                bw.write("accountNumber,accountHolderName,balance,accountType,accountStatus,customerId");
                bw.newLine();
            

            for (Account existingAccount : accounts) {
                bw.write(existingAccount.getAccountNumber() + "," +
                        existingAccount.getAccountHolderName() + "," +
                        existingAccount.getBalance() + "," +
                        existingAccount.getAccountType() + "," +
                        existingAccount.getAccountStatus() + "," +
                        existingAccount.getCustomerId());
                bw.newLine();
            }

        }

    }

}
