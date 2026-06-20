package model;

public class Account {

    public enum AccountStatus {
        ACTIVE,
        BLOCKED,
        CLOSED
    }

    public enum AccountType {
        SAVINGS,
        CURRENT,
        FIXED
    }

    private int accountNumber;
    private String accountHolderName;
    private int balance = 0;
    private AccountStatus accountStatus;
    private AccountType accountType;
    private String customerId;

    public Account(int accountNumber, String accountHolderName, int balance, AccountType accountType,
            AccountStatus accountStatus,String customerId) {
        setAccountHolderName(accountHolderName);
        setAccountNumber(accountNumber);
        setAccountType(accountType);
        setBalance(balance);
        setAccountStatus(accountStatus);

        if(customerId == null || customerId.isEmpty())
        {
            throw new IllegalArgumentException(" Customer Id cannot be empty ");
        }
        this.customerId=customerId;

    }

    public void setBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Enter a Value Greater Than zero");
        }
        this.balance = balance;
    }

    public void setAccountNumber(int accountNumber) {
        if (accountNumber < 10000 || accountNumber > 99999) {
            throw new IllegalArgumentException("Account number must be 5 digits");
        }

        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account Holder Name Should Not be Empty");
        }

        this.accountHolderName = accountHolderName.trim();
    }

    public void setAccountType(AccountType accountType) {
        if (accountType == null) {
            throw new IllegalArgumentException("Account Type Cannot be Null");
        }

        this.accountType = accountType;

    }

    public void setAccountStatus(AccountStatus accountStatus) {
        if (accountStatus == null) {
            throw new IllegalArgumentException(" Account Status Cannot be Empty");
        }

        this.accountStatus = accountStatus;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public String getCustomerId()
    {
        return customerId;
    }

    @Override
    public String toString() {
        return "\nAccount Number : " + accountNumber +
                "\nAccount Holder : " + accountHolderName +
                "\nBalance        : " + balance +
                "\nAccount Type   : " + accountType +
                "\nAccount Status : " + accountStatus;
    }
}