#!/bin/bash

echo "Starting 10 accounts creation test"

for i in {1..10}
do
    accNo=$((10000 + i))
    name="User$i"
    balance=1000
    java ui.TestApp create $accNo $name $balance
done


