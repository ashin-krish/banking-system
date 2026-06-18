@echo off

cd /d %~dp0\..

echo Running Banking System...

java -cp scripts\out ui.Start

pause