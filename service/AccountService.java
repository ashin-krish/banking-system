package service;

import java.util.ArrayList;
import java.util.List;

import exception.DuplicateAccountException;
import model.Account;

public class AccountService 
{

    List<Account> accounts = new ArrayList<>();

    

    public void createAccount(Account account)

    throws DuplicateAccountException

    {
        if(account == null)
        {
            throw new NullPointerException("Account cannot be null");
        }
         for (Account existingAccount : accounts) {
            if(account.getAccountNumber() == existingAccount.getAccountNumber())
            {
                throw new DuplicateAccountException("Duplicate account");
            }

       
         }

         accounts.add(account);
       
    }
}
