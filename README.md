# 🏦 Banking System

> **"A banking system built to make money management feel less like chaos and more like control."**

A robust console-based banking application built in Java that simulates core banking operations including account management, customer profiles, loans, and transaction tracking. This project demonstrates Object-Oriented Design principles, layered architecture, and comprehensive exception handling.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Architecture](#project-architecture)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [How to Run](#how-to-run)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Exception Handling](#exception-handling)
- [Development Workflow](#development-workflow)
- [Future Enhancements](#future-enhancements)

---

## Overview

This Banking System is an educational project demonstrating:
- **Core Java Concepts**: Object-Oriented Programming, Collections Framework, Exception Handling
- **Layered Architecture**: Clear separation between UI, Business Logic, and Data Models
- **Real-world Banking Operations**: Account management, transactions, customer profiles, and loan processing
- **Automation & CI/CD**: Build scripts and GitHub Actions integration for continuous validation

---

## ✨ Features

### 💳 Account Management
- Create and manage multiple bank accounts
- Deposit and withdraw funds with real-time balance updates
- Transfer money between accounts
- View detailed account information
- Delete account records
- Account type categorization (Savings, Checking, etc.)
- Auto-generated account identifiers

### 👤 Customer Management
- Add and manage customer profiles
- Store customer details: name, email, phone, address, date of birth
- Auto-generated unique Customer IDs (CUS1000, CUS1001, etc.)
- Update customer information
- View complete customer list
- Remove customer records
- Email-based duplicate prevention

### 💰 Loan Management
- Apply for loans with multiple loan types
- Auto-generated Loan IDs (LN1000, LN1001, etc.)
- Interest rate calculation and tracking
- View loan details and history
- Search and manage loan records
- Duplicate loan prevention

### 📜 Transaction Tracking
- Automatic transaction logging for all operations
- Track deposits, withdrawals, and transfers
- View complete transaction history per account
- Auto-generated Transaction IDs (TXN1000, TXN1001, etc.)
- Transaction timestamps for audit trails
- Transaction type classification

---

## 🏗️ Project Architecture

This project follows a **Layered Architecture Pattern** with clear separation of concerns:

```
┌─────────────────────────────────────┐
│          UI Layer                   │
│  (Start.java, Menu.java)            │
├─────────────────────────────────────┤
│      Business Logic Layer           │
│  (AccountService, CustomerService,  │
│   LoanService)                      │
├─────────────────────────────────────┤
│        Data Model Layer             │
│  (Account, Customer, Loan,          │
│   Transaction)                      │
├─────────────────────────────────────┤
│      Exception Handling Layer       │
│  (Custom Exception Classes)         │
└─────────────────────────────────────┘
```

**Benefits:**
- **Maintainability**: Each layer has a specific responsibility
- **Testability**: Services can be tested independently
- **Scalability**: Easy to add new features or replace components
- **Reusability**: Services can be used by different UI implementations

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java 8+ |
| **Architecture** | Layered Architecture |
| **Collections** | ArrayList, Collections Framework |
| **Exception Handling** | Custom Exception Classes |
| **UI** | Console-based CLI |
| **Build System** | Bash Scripts |
| **Version Control** | Git & GitHub |
| **CI/CD** | GitHub Actions |
| **Development** | Linux/Unix Terminal |
| **Date/Time** | Java Time API (LocalDateTime) |

---

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher
  - Verify installation: `java -version`
  - Verify compiler: `javac -version`
- **Bash Shell**: For running build and run scripts
- **Operating System**: Linux, macOS, or Windows (with Git Bash or WSL)
- **Git**: For version control (optional)

---

## Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/banking-system.git
cd banking-system
```

### 2. Verify Java Installation
```bash
java -version
javac -version
```

### 3. Verify Project Structure
```bash
ls -la
```

You should see directories: `exception/`, `model/`, `service/`, `ui/`, `scripts/`, and `README.md`

---

## How to Run

### Option 1: Using the Run Script (Recommended)
```bash
chmod +x scripts/run.sh
./scripts/run.sh
```

This script automatically:
1. Compiles all Java files via `build.sh`
2. Validates the build
3. Launches the application with `java ui.Start`

### Option 2: Manual Build and Run
```bash
# Build the project
chmod +x scripts/build.sh
./scripts/build.sh

# Run the application
java ui.Start
```

### Option 3: One-liner Compilation
```bash
javac $(find . -name "*.java") && java ui.Start
```

### Option 4: Windows PowerShell
```powershell
javac -d . $(Get-ChildItem -Path . -Filter *.java -Recurse)
java ui.Start
```

---

## Usage

Once the application starts, you'll be presented with a menu-driven interface:

### Main Menu Options:
1. **Accounts** - Manage bank accounts
2. **Customers** - Manage customer profiles
3. **Loans** - Manage loan applications
4. **Exit** - Close the application

### Account Operations:
- **Create Account** → Specify account number (5 digits), holder name, initial balance, and account type
- **View Account** → Enter account number to view details and balance
- **Deposit Funds** → Add money to an account
- **Withdraw Funds** → Withdraw money (validates sufficient balance)
- **Transfer Funds** → Transfer money between two accounts
- **View Transactions** → See all transactions for a specific account
- **Delete Account** → Remove an account and its records

### Customer Operations:
- **Add Customer** → Create new customer profile (name, email, phone, address, DOB)
- **View Customers** → Display all registered customers
- **Update Customer** → Modify customer information
- **Delete Customer** → Remove customer record

### Loan Operations:
- **Apply for Loan** → Create new loan application (specify type, amount, interest rate)
- **View Loan** → Check loan details by Loan ID
- **View All Loans** → Display all loans in the system
- **Delete Loan** → Remove loan record

### Example Workflow:
```
1. Add a Customer (John Doe, john@example.com)
2. Create an Account (Account #12345, Balance: 5000)
3. Link Customer to Account
4. Deposit funds (+500)
5. Apply for a Loan (Type: Personal, Amount: 50000)
6. View Transaction History
```

---

## Project Structure

### Directory Overview

```
banking-system/
│
├── exception/                              # Custom Exception Classes
│   ├── AccountNotFoundException.java        # Account lookup failure
│   ├── CustomerNotFoundException.java       # Customer lookup failure
│   ├── DuplicateAccountException.java       # Duplicate account number
│   ├── DuplicateCustomerException.java      # Duplicate customer email
│   ├── DuplicateLoanException.java          # Duplicate loan ID
│   ├── InsufficientBalanceException.java    # Insufficient funds
│   └── LoanNotFoundException.java           # Loan lookup failure
│
├── model/                                  # Core Data Models
│   ├── Account.java                        # Account entity
│   │   └── Properties: accountNumber, accountHolderName, balance, accountType
│   │
│   ├── Customer.java                       # Customer entity
│   │   └── Properties: name, email, phone, address, dob, customerId
│   │
│   ├── Loan.java                           # Loan entity
│   │   └── Properties: loanId, loanType, loanAmount, interestRate
│   │
│   └── Transaction.java                    # Transaction entity
│       └── Properties: transactionId, accountNumber, transactionType, amount, dateTime
│
├── service/                                # Business Logic Layer
│   ├── AccountService.java                 # Account operations & validation
│   │   └── Methods: createAccount, viewAccount, deposit, withdraw, transfer, deleteAccount
│   │
│   ├── CustomerService.java                # Customer operations & validation
│   │   └── Methods: addCustomer, viewCustomers, updateCustomer, deleteCustomer
│   │
│   └── LoanService.java                    # Loan operations & validation
│       └── Methods: applyLoan, getLoanById, getAllLoans, deleteLoan
│
├── ui/                                     # User Interface Layer
│   ├── Start.java                          # Application entry point & controller
│   │   └── Main menu routing & operation handlers
│   │
│   ├── Menu.java                           # Menu display logic
│   │   └── Display menus and options
│   │
│   └── consoleUI.java                      # Console utilities
│       └── Input/output helper methods
│
├── scripts/                                # Automation Scripts
│   ├── build.sh                            # Compile all Java files
│   │   └── Finds and compiles all .java files recursively
│   │
│   └── run.sh                              # Build and run application
│       └── Calls build.sh, validates success, then runs ui.Start
│
└── README.md                               # Project documentation (this file)
```

### Key Classes Detail

#### Model Layer
- **Account.java**: 
  - 5-digit account number validation
  - Account holder name validation
  - Balance tracking
  - Account type classification

- **Customer.java**: 
  - Auto-generated Customer IDs
  - Email-based uniqueness
  - Contact and personal information
  - Input validation

- **Loan.java**: 
  - Auto-generated Loan IDs
  - Loan type and amount
  - Interest rate tracking
  - Validation logic

- **Transaction.java**: 
  - Auto-generated Transaction IDs
  - Timestamp tracking
  - Transaction type (Deposit, Withdrawal, Transfer)
  - Amount recording

#### Service Layer
- **AccountService.java**: 
  - Account CRUD operations
  - Fund deposit/withdrawal with validation
  - Inter-account transfers
  - Balance verification
  - Transaction logging

- **CustomerService.java**: 
  - Customer profile management
  - Duplicate email prevention
  - Customer data updates
  - Customer removal

- **LoanService.java**: 
  - Loan application processing
  - Duplicate loan prevention
  - Loan retrieval and management
  - Interest tracking

#### UI Layer
- **Start.java**: 
  - Main application controller
  - Menu-driven interface
  - Operation routing
  - Exception handling

- **Menu.java**: 
  - Menu display formatting
  - User option presentation

- **consoleUI.java**: 
  - Input/output utilities
  - Console formatting helpers

---

## Exception Handling

The system implements comprehensive exception handling with **7 custom exception classes**:

| Exception | When Thrown | Scenario |
|-----------|-------------|----------|
| `AccountNotFoundException` | Operation on non-existent account | Viewing/deleting/modifying unknown account |
| `CustomerNotFoundException` | Operation on non-existent customer | Updating/deleting unknown customer |
| `DuplicateAccountException` | Account creation with existing number | Account number already in system |
| `DuplicateCustomerException` | Customer creation with duplicate email | Email already registered |
| `DuplicateLoanException` | Loan creation with duplicate ID | Loan ID already exists |
| `InsufficientBalanceException` | Withdrawal/transfer exceeds balance | Account lacks funds |
| `LoanNotFoundException` | Operation on non-existent loan | Accessing unknown loan ID |
| `IllegalArgumentException` | Invalid input data | Null/empty/invalid values |

**Exception Handling Flow:**
```
User Input
   ↓
Validation in Service Layer
   ↓
Exception Thrown (if invalid)
   ↓
UI Layer Catches Exception
   ↓
User-Friendly Error Message Displayed
   ↓
Application Continues
```

**Example:**
```java
try {
    accountService.withdraw(12345, 5000);
} catch (InsufficientBalanceException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## Development Workflow

### Build Process Flow
```
User runs: ./scripts/build.sh
    ↓
Script finds all *.java files recursively
    ↓
javac compiles all files
    ↓
Success? → Reports "Build Successful"
Failure? → Reports "Build Unsuccessful" and exits with code 1
```

### Run Process Flow
```
User runs: ./scripts/run.sh
    ↓
Calls scripts/build.sh
    ↓
Build failed? → Exit
    ↓
Build successful? → Continue
    ↓
Execute: java ui.Start
    ↓
Application runs
    ↓
Exit code 0? → "Application Exited Normally"
Exit code ≠ 0? → "Application Exited with Error"
```

### Development Best Practices
1. **Compile Frequently**: Catch errors early during development
2. **Test Each Feature**: Verify functionality after each implementation
3. **Use Version Control**: Commit regularly with meaningful messages
4. **Follow Layering**: Maintain separation between UI, Service, and Model
5. **Handle Exceptions**: Always catch and handle potential errors
6. **Validate Input**: Check data at service layer before processing
7. **Use Descriptive Names**: Make code self-documenting
8. **Add Comments**: Explain complex logic and business rules

### Debugging Tips
```bash
# Check Java version
java -version

# Verify all Java files compile
javac $(find . -name "*.java")

# Run with error output
java ui.Start 2>&1

# Search for specific errors
javac $(find . -name "*.java") 2>&1 | grep -i "error"
```

---

## Future Enhancements

### Phase 2: Persistence
- [ ] Database Integration (JDBC + MySQL)
- [ ] Persistent data storage
- [ ] Data migration scripts
- [ ] Backup and recovery system

### Phase 3: Security & Authentication
- [ ] User login and authentication
- [ ] Password hashing and encryption
- [ ] Role-based access control (Admin, Customer)
- [ ] Audit logging

### Phase 4: Advanced Features
- [ ] Interest calculation and accrual
- [ ] Automated overdraft protection
- [ ] Account statements and reports
- [ ] Scheduled transactions
- [ ] Bill payment functionality

### Phase 5: API & Integration
- [ ] REST API endpoints
- [ ] SOAP web services
- [ ] Integration with payment gateways
- [ ] Mobile app backend

### Phase 6: Testing & Quality
- [ ] JUnit unit tests
- [ ] Integration tests
- [ ] Performance testing
- [ ] Security testing

### Phase 7: UI Modernization
- [ ] GUI Interface (Swing/JavaFX)
- [ ] Web UI (JSP/Spring)
- [ ] Mobile application
- [ ] Dark mode support

---

## Testing

### Manual Testing Checklist

**Account Operations:**
- [ ] Create account with valid 5-digit number
- [ ] Reject invalid account numbers (< 10000 or > 99999)
- [ ] Prevent duplicate account creation
- [ ] Deposit increases balance correctly
- [ ] Withdrawal decreases balance correctly
- [ ] Reject withdrawal if insufficient balance
- [ ] Transfer between accounts works correctly
- [ ] Transaction history shows all operations
- [ ] Delete account removes all records

**Customer Operations:**
- [ ] Add customer with all details
- [ ] Prevent duplicate email registration
- [ ] Update customer information
- [ ] View all customers
- [ ] Delete customer and verify removal
- [ ] Verify customer ID auto-generation (CUS1000, CUS1001, etc.)

**Loan Operations:**
- [ ] Apply for loan successfully
- [ ] Prevent duplicate loan IDs
- [ ] View loan details correctly
- [ ] Interest calculation is accurate
- [ ] Delete loan and verify removal
- [ ] Verify loan ID auto-generation (LN1000, LN1001, etc.)

**Exception Handling:**
- [ ] AccountNotFoundException on invalid account
- [ ] CustomerNotFoundException on invalid customer
- [ ] DuplicateAccountException on duplicate creation
- [ ] InsufficientBalanceException on low balance
- [ ] All error messages are user-friendly

### Test Scenarios

**Scenario 1: Happy Path Account Operations**
```
1. Create Account #12345 with $5000
2. Deposit $1000 → Balance: $6000 ✓
3. Withdraw $2000 → Balance: $4000 ✓
4. View transactions → Shows 2 entries ✓
```

**Scenario 2: Error Handling**
```
1. Try to create Account #12345 again → DuplicateAccountException ✓
2. Try to withdraw $10000 → InsufficientBalanceException ✓
3. Try to view Account #99999 → AccountNotFoundException ✓
```

**Scenario 3: Data Validation**
```
1. Try account number 999 → IllegalArgumentException ✓
2. Try empty customer name → IllegalArgumentException ✓
3. Try null loan type → IllegalArgumentException ✓
```

---

## Contributing

### Development Guidelines:
1. Fork the repository
2. Create a feature branch: `git checkout -b feature/new-feature`
3. Follow the layered architecture pattern
4. Add comprehensive error handling
5. Test thoroughly before committing
6. Commit with clear messages:
   ```bash
   git commit -m "Feature: Add new feature description"
   git commit -m "Fix: Resolve issue description"
   git commit -m "Refactor: Improve code structure"
   ```
7. Push to the branch: `git push origin feature/new-feature`
8. Open a pull request with description

### Commit Message Format:
```
<type>: <description>
<blank line>
<body>

Types: Feature, Fix, Refactor, Test, Docs, Chore
```

---

## Project Learning Outcomes

This project demonstrates proficiency in:

✅ **Core Java**
- Object-Oriented Programming
- Collections Framework (ArrayList)
- Exception Handling
- Java Time API

✅ **Software Architecture**
- Layered Architecture Pattern
- Separation of Concerns
- Model-Service-UI structure
- Dependency Management

✅ **Software Engineering**
- Input validation and error handling
- Custom exception design
- Code organization
- SOLID principles

✅ **Development Tools & Practices**
- Build automation (Bash scripts)
- Version control (Git)
- CI/CD integration (GitHub Actions)
- Terminal-based development

✅ **Problem Solving**
- Real-world banking scenarios
- Edge case handling
- Performance optimization
- Security considerations

---



## Credits

**Author**: Ashin Krishna  
**Version**: 1.0.0  
**Status**: Production Ready  
**Last Updated**: 2026-06-18  

Built with ☕ Java, 🔧 bash scripts, and 🐛 debugging determination.

---

## Quick Reference

### Common Commands
```bash
# Build the project
./scripts/build.sh

# Run the application
./scripts/run.sh

# Clean compiled files
find . -name "*.class" -delete

# View project structure
tree -I 'target'

# Search for specific class
find . -name "*.java" -exec grep -l "className" {} \;
```

### Project Stats
- **Total Java Files**: 14
- **Exception Classes**: 7
- **Model Classes**: 4
- **Service Classes**: 3
- **UI Components**: 3
- **Lines of Code**: 1000+ (estimated)

---

**Happy Banking! 🏦**
