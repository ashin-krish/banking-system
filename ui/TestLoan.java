package ui;

import model.Loan;

import service.LoanService;

public class TestLoan {

    public static void main(String[] args) {
        // ✅ safety check
        if (args.length < 4) {
            System.out.println("Usage: create <loanType> <loanAmount> <interestRate>");
            return;
        }

        String command = args[0];

        LoanService service = new LoanService();

        // ❗ only handle "create" command for now
        if (!command.equals("create")) {
            System.out.println("Invalid command");
            return;
        }

        try {
            String loanType = args[1];
            int loanAmount = Integer.parseInt(args[2]);
                double interestRate = Double.parseDouble(args[3]);

                 Loan loan = new Loan(loanType, loanAmount, interestRate);
        
            service.applyLoan(loan);

            System.out.println("Loan created successfully: " + loan.getLoanId());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
    }
    

