echo "Loading 10 customers..."

for i in {1..10}
do
    name="user$i"
    email="user$i@gmail.com"
    phone="111111111$i"
    address="home$i"
    dob="12-06-2022"

    java ui.TestCustomer create "$name" "$email" "$phone" "$address" "$dob"

    if [[ $? -eq 0 ]]
    then
        echo "Run Successful for user$i"
    else
        echo "Run Failed for user$i"
    fi

done


