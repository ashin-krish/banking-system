@echo off

cd /d %~dp0\..

echo ================================
echo   Building Java Project
echo ================================

if not exist scripts\out mkdir scripts\out

dir /s /b model\*.java > scripts\sources.txt
dir /s /b service\*.java >> scripts\sources.txt
dir /s /b ui\*.java >> scripts\sources.txt
dir /s /b persistence\*.java >> scripts\sources.txt
dir /s /b exception\*.java >> scripts\sources.txt

javac -d scripts\out @scripts\sources.txt

if %errorlevel% neq 0 (
    echo.
    echo ❌ Build failed
    pause
    exit /b
)

echo.
echo ✅ Build successful!
pause