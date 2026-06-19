#!/bin/bash

echo " ============= Creating 10 Loan =============="

for i in {1..10}
do
    loanType="homeloan"
    loanAmount=$((10101+i))
    interestRate=$((2+i))

    java ui.TestLoan create "$loanType" $loanAmount $interestRate

    if [[ $? -eq 0 ]]
    then
            echo "account creation succesfull"
    else
            echo "account creation failed"
    fi

done