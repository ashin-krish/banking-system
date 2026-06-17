🏦 Banking System (Java Console Application)

“A banking system built to make money management feel less like chaos and more like control.”

A console-based banking application built in Java that simulates core banking operations like account handling, customer management, loans, and transactions.

This project focuses on strengthening Core Java, Object-Oriented Design, Collections, Exception Handling, Layered Architecture, and real-world system thinking.

✨ What it does
💳 Accounts
Create and manage accounts
Deposit & withdraw funds
Transfer money between accounts
View & delete account details

👤 Customers
Add and manage customer profiles
Update customer information
View full customer list
Remove customer records

💰 Loans
Apply for loans
View loan details
Interest calculation
Search & manage loan records

📜 Transactions
Track deposits, withdrawals, and transfers
View complete transaction history per account
🚨 Error Handling (Built-in Safety Layer)

Custom exceptions ensure the system stays stable and predictable:

DuplicateAccountException
AccountNotFoundException
InsufficientBalanceException
DuplicateCustomerException
CustomerNotFoundException
DuplicateLoanException
LoanNotFoundException



🏗️ Project Structure
Banking-System/
│
├── .github/
│   └── workflows/
│       └── ci.yml              # CI pipeline (GitHub Actions)
│
├── exception/                  # Custom exception layer
├── model/                     # Core data models
├── service/                   # Business logic layer
├── ui/                        # Console UI (entry point)
│
├── scripts/                   # Automation scripts
│   ├── build.sh               # Compile project
│   └── run.sh                 # Run application


🛠️ Tech Stack (and Tools that make it real)
Java (Core)
OOP Design Principles
Collections Framework
Exception Handling
CLI-based UI


⚙️ Dev & Automation Layer
Bash scripting (build automation)
Git & GitHub (version control)
GitHub Actions (CI pipeline)
Linux environment
Vi editor (terminal-first development workflow)
⚙️ Automation Flow
🧪 Local Scripts

Simple bash scripts handle the heavy lifting:

build.sh → compiles the entire project
run.sh → launches the application

Think of it as your mini build system — no IDE needed.



🚀 CI Pipeline (GitHub Actions)

Every push to main triggers:

Code checkout
Java setup (Temurin 21)
Build execution via script
Compilation verification

So every change gets automatically validated — no surprises.

💻 How I Built It (Workflow)
Code written using Vi editor
Builds handled through bash scripts
Execution via terminal commands
Version control with Git + GitHub
CI checks through GitHub Actions

Basically: no IDE dependency, just terminal + discipline.

🎯 What This Project Taught Me
Thinking in layers (UI → Service → Model)
Designing clean business logic
Writing custom exceptions instead of hacks
Structuring Java projects properly
Automating builds using scripts
Setting up CI pipelines from scratch
Working in a Linux-style dev environment
🚀 Future Upgrades
Database integration (JDBC + MySQL)
User authentication system
Account statements & reports
Persistent file storage
JUnit test suite
Spring Boot version of the system
📌 Status

✔ Version 1 Complete
Core banking features are stable and fully functional.

👨‍💻 Author

Ashin Krishna

Built with Java, bash scripts, and a slightly unhealthy amount of debugging sessions.