#!/bin/bash

echo "Creating 5 accounts and depositing money"

for i in {1..5}
do
    name="user$i"
    balance=100
    accountNumber=$((1000 + i))
    depositAmount=500

    # CREATE
    java ui.TestTransaction create $accountNumber $name $balance

    if [[ $? -eq 0 ]]
    then
        echo "Account creation successful: $accountNumber"
    else
        echo "Account creation failed: $accountNumber"
        continue
    fi

    # DEPOSIT
    java ui.TestTransaction deposit $accountNumber $depositAmount

    if [[ $? -eq 0 ]]
    then
        echo "Deposit successful: $accountNumber"
    else
        echo "Deposit failed: $accountNumber"
    fi

done