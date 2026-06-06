package model;

import java.time.LocalDateTime;

public class Transaction {

    private String transactionId;
    private int accountNumber;
    private String transactionType;
    private int amount;
    private LocalDateTime transactionDateTime;

    private static int counter = 1000;

    public Transaction(
            int accountNumber,
            String transactionType,
            int amount,
            LocalDateTime transactionDateTime) 
        {
             this.transactionId = generateTransactionId();
        setAccountNumber(accountNumber);
        setTransactionType(transactionType);
        setAmount(amount);
        setTransactionDateTime(transactionDateTime);
    }


      private static String generateTransactionId()
      {
        return "TXN" + counter++;
      }

      public String getTransactionId()
      {
        return transactionId;
      }

    public void setAccountNumber(int accountNumber) {
        if (accountNumber < 10000 || accountNumber > 99999) {
            throw new IllegalArgumentException("Account number must be 5 digits");
        }

        this.accountNumber = accountNumber;
    }

    public void setTransactionType(String transactionType) {
        if (transactionType == null || transactionType.trim().isEmpty()) {
            throw new IllegalArgumentException("Transaction type Should not ne empty");
        }

        transactionType = transactionType.trim().toLowerCase();

        if (!transactionType.equals("deposit") &&
                !transactionType.equals("withdraw") &&
                !transactionType.equals("transfer")) {
            throw new IllegalArgumentException("Choose only valid transaction type ");
        }

        this.transactionType = transactionType;
    }

    public void setAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Enter a positive value");
        }

        this.amount = amount;
    }

    public void setTransactionDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        if (dateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Date cannot be in the future");
        }

        this.transactionDateTime = dateTime;
    }

  

    public String getTransactionType() {
        return transactionType;
    }

    public int getTransactionAmount() {
        return amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    @Override
    public String toString() {
        return "\n Transcation Id : " + transactionId +
                "\n Transcation Type : " + transactionType +
                "\n Account Number        : " + accountNumber +
                "\n Transaction Amount        : " + amount +
                "\n Date  : " + transactionDateTime;
    }

}
