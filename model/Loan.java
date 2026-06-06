package model;

public class Loan
{
    private String loanId;
    private String loanType;
    private int loanAmount;
    private double interestRate;

    private static int counter = 1000;

    Loan(String loanType, int loanAmount, double interestRate)
    {
        setLoanAmount(loanAmount);
       this.loanId = generateLoanId();
        setLoanInterest(interestRate);
        setLoanType(loanType);
    }

    public String generateLoanId()
    {
          return "LN" + counter++;
    } 

 

    public void setLoanType(String loanType)
    {
        if (loanType == null || loanType.trim().isEmpty())
        {
            throw new IllegalArgumentException("Loan type Should not ne empty");
        }

        loanType = loanType.trim().toLowerCase();

        if (!loanType.equals("homeloan") &&
            !loanType.equals("carloan") &&
            !loanType.equals("educationalloan"))
        {
            throw new IllegalArgumentException(" Choose only avilable loan type ");
        }

        this.loanType = loanType;
    }

    public void setLoanAmount(int loanAmount)
    {
        if (loanAmount <= 0)
        {
            throw new IllegalArgumentException("Enter a positive Amount ");
        }

        this.loanAmount = loanAmount;
    }

    public void setLoanInterest(double interestRate)
    {
        if (interestRate < 1 || interestRate > 30)
        {
            throw new IllegalArgumentException("ENter value between 1%-30% only");
        }

        this.interestRate = interestRate;
    }

    public String getLoanId()
    {
        return loanId;
    }

    public String getLoanType()
    {
        return loanType;
    }

    public int getAmount()
    {
        return loanAmount;
    }

    public double getLoanInterest()
    {
        return interestRate;
    }

    @Override
    public String toString()
    {
        return "\n Loan Id : " + loanId +
               "\n Loan Type : " + loanType +
               "\n Loan Amount        : " + loanAmount +
               "\n Loan Interest   : " + interestRate;
    }
}