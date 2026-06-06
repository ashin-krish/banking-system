package model;

public class Account
{
    private int accountNumber;
    private String accountHolderName;
    private int balance = 0;
    private String accountType;
 

    public Account(int accountNumber, String accountHolderName, int balance, String accountType)
    {
        setAccountHolderName(accountHolderName);
        setAccountNumber(accountNumber);
        setAccountType(accountType);
     

       
    }

    public void setAccountNumber(int accountNumber)
    {
        if (accountNumber < 10000 || accountNumber > 99999)
        {
            throw new IllegalArgumentException("Account number must be 5 digits");
        }

        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName)
    {
        if (accountHolderName == null || accountHolderName.trim().isEmpty())
        {
            throw new IllegalArgumentException("Account Holder Name Should Not be Empty");
        }

        this.accountHolderName = accountHolderName.trim();
    }

    public void setAccountType(String accountType)
    {
        if (accountType == null)
        {
            throw new IllegalArgumentException("Account Type Cannot be Null");
        }

        accountType = accountType.trim().toLowerCase();

        if (accountType.equals("savings") ||
            accountType.equals("current") ||
            accountType.equals("fixed"))
        {
            this.accountType = accountType;
            return;
        }

        throw new IllegalArgumentException(" Add Only Valid Account Type");
    }


      public void setBalance(int balance)
      {
        if(balance < 0)
        {
          throw new IllegalArgumentException("Enter a Value Greater Than zero");
        }
        this.balance = balance;
      }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public String getAccountHolderName()
    {
        return accountHolderName;
    }

    public int getBalance()
    {
        return balance;
    }

    public String getAccountType()
    {
        return accountType;
    }

   

    @Override
    public String toString()
    {
        return "\nAccount Number : " + accountNumber +
               "\nAccount Holder : " + accountHolderName +
               "\nBalance        : " + balance +
               "\nAccount Type   : " + accountType;
    }
}