@echo off

cd /d %~dp0\..

echo Running tests...

java -cp scripts\out ui.TestApp create 11123 Ashin 1000
java -cp scripts\out ui.TestApp create 11323 John 2000

echo Done
pause