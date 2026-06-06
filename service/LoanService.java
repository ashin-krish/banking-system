package service;

import model.Loan;

import java.util.List;

import exception.DuplicateLoanException;
import exception.LoanNotFoundException;

import java.util.ArrayList;

public class LoanService 
{
    private List<Loan> loans = new ArrayList<>();

    public void applyLoan(Loan loan)
      throws DuplicateLoanException
    {
        if(loan == null)
        {
            throw new IllegalArgumentException("Loan cannot be empty");
        }
       for (Loan existingLoan : loans) 
    {
         if(loan.getLoanId() == existingLoan.getLoanId())
         {
                throw new DuplicateLoanException("Loan Already exists");
         }
       }

       loans.add(loan);
    }

    public Loan getloanById(String loanId)
    throws LoanNotFoundException
    {
        for (Loan existingLoan : loans) 
        {
            if(existingLoan.getLoanId().equals(loanId))
            {
                return  existingLoan;
            }
        }

        throw new LoanNotFoundException("Loan does Not Exit ");


    }

    public List<Loan> getAllLoans()
    {
         return new ArrayList<>(loans);
    }

    public void removeLoan(String loanId)
     throws LoanNotFoundException
     {
  

        Loan loan = getloanById(loanId);

        loans.remove(loan);

     }

     public double calculateInterest(String loanId)
      throws LoanNotFoundException
     {
        Loan loan = getloanById(loanId);
         return (loan.getAmount() * loan.getLoanInterest())/100.0;
     }


}
