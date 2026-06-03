package model;

public class Loan
{
    String loanId;
    String loanType;
    int loanAmount;
    double interestRate;

    Loan(String loanId, String loanType, int loanAmount, double interestRate)
    {
        setLoanAmount(loanAmount);
        setLoanId(loanId);
        setLoanInterest(interestRate);
        setLoanType(loanType);
    }

    private static final String LOAN_ID_REGEX = "^LN[A-Za-z0-9]{4,10}$";

    public void setLoanId(String loanId)
    {
        if (loanId == null || loanId.trim().isEmpty())
        {
            throw new IllegalArgumentException("Loan Id cannot be Empty");
        }

        if (!loanId.matches(LOAN_ID_REGEX))
        {
            throw new IllegalArgumentException(" Invalid Loan Id Format ");
        }

        this.loanId = loanId.trim();
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