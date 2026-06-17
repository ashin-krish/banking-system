#!/bin/bash

echo " ---------- Java build ----------"

javac $(find . -name "*.java")

if [[ $? -eq 0 ]]
then
        echo " Build Succesfull .......... "
else
        echo " Build Unsuccesfull ......... "
        exit 1

fi

