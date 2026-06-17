#!/bin/bash

echo " ========== Java Run Application =========="

 ./scripts/build.sh || exit 1

echo " Appilcation Starting ............. "

java ui.Start

if [[ $? -eq 0 ]]
then
       echo " Application Exited Normally "

else
    echo " Run Failed .............. " 
fi




