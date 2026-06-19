package persistence;

import model.Loan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


import java.util.ArrayList;

public class LoanFileHandler 
{
    public List<Loan> loadLoanFile()
    {
        List<Loan> loans = new ArrayList<>();

        File f = new File("data/loan_data.csv");

        if(!f.exists())
        {
            return loans;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(f)))
        {
            br.readLine();

            String line;

            while((line = br.readLine()) != null)
            {
                String[] data = line.split(",");
                if(data.length == 4)
                {
                    String loanType = data[0];
                    int loanAmount = Integer.parseInt(data[1]);
                    double interestRate = Double.parseDouble(data[2]);

                    Loan loan = new Loan(loanType, loanAmount, interestRate);
                    loans.add(loan);
                }
                else
                {
                    System.out.println("Inavlid record" + line);
                    continue;
                }
            }
            return loans;
        }

        catch(IOException e)
        {
            System.out.println(e);
        }
        catch(NumberFormatException e)
        {
            System.out.println(e);

        }
        return loans;
    }



    public void saveLoanFile(List<Loan> loans)
    throws IOException
    {
        File f = new File("data/loan_data.csv");

        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw))
            {
               bw.write("LoanType,loanAmount,interestRate,LoanId");
               bw.newLine();

               for (Loan existingLoan : loans) 
                {
                    bw.write(existingLoan.getLoanType() + "," +
                     existingLoan.getAmount() + "," +
                    existingLoan.getLoanInterest() + "," +
                    existingLoan.getLoanId()); 
                    bw.newLine();
               }
            }


    }
}
