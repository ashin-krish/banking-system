# 🏦 Banking System (Java Console Application)

> Because keeping money under the mattress isn't scalable.

A console-based Banking Management System built in Java that allows users to manage accounts, customers, loans, and transactions through a menu-driven interface.

This project was created to practice **Core Java, OOP concepts, Collections, Exception Handling, Layered Architecture, and Business Logic Implementation**.

---

## ✨ Features

### 💳 Account Management

* Create a new account
* View account details
* Deposit money
* Withdraw money
* Transfer money between accounts
* Delete accounts

### 👤 Customer Management

* Add new customers
* View customer details
* View all customers
* Update customer email
* Delete customers

### 💰 Loan Management

* Apply for loans
* View loan details
* View all loans
* Remove loans
* Calculate loan interest
* Search loans by type

### 📜 Transaction Management

* Record deposits
* Record withdrawals
* Record transfers
* View account transaction history

### 🚨 Exception Handling

Custom exceptions implemented for:

* DuplicateAccountException
* AccountNotFoundException
* InsufficientBalanceException
* DuplicateCustomerException
* CustomerNotFoundException
* DuplicateLoanException
* LoanNotFoundException

---

## 🏗️ Project Structure

```text
Banking-System/
│
├── exception/
│   ├── AccountNotFoundException.java
│   ├── CustomerNotFoundException.java
│   ├── DuplicateAccountException.java
│   ├── DuplicateCustomerException.java
│   ├── DuplicateLoanException.java
│   ├── InsufficientBalanceException.java
│   └── LoanNotFoundException.java
│
├── model/
│   ├── Account.java
│   ├── Customer.java
│   ├── Loan.java
│   └── Transaction.java
│
├── service/
│   ├── AccountService.java
│   ├── CustomerService.java
│   └── LoanService.java
│
└── ui/
    ├── consoleUI.java
    ├── Menu.java
    └── Start.java
```


## 🛠️ Tech Stack

* Java
* OOP (Object-Oriented Programming)
* Collections Framework
* Exception Handling
* Console-Based UI
* Layered Architecture

---

## 🎯 Concepts Practiced

* Classes & Objects
* Encapsulation
* Constructor Overloading
* Collections (`ArrayList`)
* Custom Exceptions
* Business Logic Separation
* Menu Driven Applications
* Method Design
* Validation & Error Handling

---

## 🚀 Running the Project

### Compile

```bash
javac ui/*.java service/*.java model/*.java exception/*.java
```

### Run

```bash
java ui.Start
```

---

## 📈 Future Improvements

* [ ] JDBC Integration
* [ ] MySQL Database Support
* [ ] User Authentication
* [ ] Account Statements
* [ ] Interest Calculation Automation
* [ ] File Persistence
* [ ] JUnit Testing
* [ ] Spring Boot Version



---

## 📸 Current Status

✅ Version 1 Completed

The core banking functionalities are fully implemented and working as expected.

---

## 👨‍💻 Author

Ashin Krishna

> Built with Java, patience, and an unreasonable amount of debugging.
