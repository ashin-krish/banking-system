// package ui;

// import model.Account;
// import model.Account.AccountStatus;
// import model.Account.AccountType;
// import service.AccountService;


// public class TestTransaction
// {
//     public static void main(String[] args)
//     {
//         if(args.length < 1)
//         {
//             System.out.println("Usage: create/deposit ...");
//             return;
//         }

//         AccountService accservice = new AccountService();

//         String command = args[0];

//         try
//         {
//             if(command.equals("create"))
//             {
//                 if(args.length != 6)
//                 {
//                     System.out.println("Usage: create <accountNumber> <name> <balance>");
//                     return;
//                 }

//                 int accountNumber = Integer.parseInt(args[1]);
//                 String name = args[2];
//                 int balance = Integer.parseInt(args[3]);

//                 Account account = new Account(accountNumber, name, balance, AccountType.SAVINGS,AccountStatus.ACTIVE,"CUS1011");
//                 accservice.createAccount(account);

//                 System.out.println("Account created: " + accountNumber);
//             }

//             else if(command.equals("deposit"))
//             {
//                 if(args.length != 3)
//                 {
//                     System.out.println("Usage: deposit <accountNumber> <amount>");
//                     return;
//                 }

//                 int accountNumber = Integer.parseInt(args[1]);
//                 int amount = Integer.parseInt(args[2]);

//                 accservice.deposit(amount, accountNumber);

//                 System.out.println("Deposited " + amount + " to " + accountNumber);
//             }

//             else
//             {
//                 System.out.println("Invalid command");
//             }
//         }
//         catch(Exception e)
//         {
//             System.out.println(e);
//         }
//     }
// }
