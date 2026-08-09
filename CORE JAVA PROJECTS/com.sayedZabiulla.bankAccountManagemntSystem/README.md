# 🏦 Bank Account Management System

A **console-based Bank Account Management System** developed using **Core Java**.
This project demonstrates practical implementation of **Object-Oriented Programming (OOP)** concepts, interfaces, inheritance, polymorphism, collections, exception handling, and modular application design.

The application allows users to create customers and bank accounts, perform deposits, withdrawals and transfers, search records, and display customer/account information through an interactive command-line menu.

---

## 📌 Project Overview

The **Bank Account Management System** simulates basic banking operations through a Java console application.

The system supports:

* 👤 Individual and Business customers
* 💳 Savings and Current accounts
* 💰 Deposits
* 💸 Withdrawals
* 🔄 Account-to-account money transfers
* 🔎 Customer and account searches
* 📋 Displaying all customers
* 📋 Displaying all accounts
* ⚠️ Custom exception handling for invalid banking operations

The application starts from `BankManagementSystem.java`, which provides an interactive menu for performing the available operations.

---

## ✨ Features

### 👤 Customer Management

The system supports two types of customers:

* **Individual Customer**

  * Customer ID
  * Name
  * Phone
  * Email
  * Occupation

* **Business Customer**

  * Customer ID
  * Name
  * Phone
  * Email
  * Business Name

Customer creation is handled through the console application.

### 💳 Account Management

Two account types are available:

#### Savings Account

* Account number
* Customer information
* Interest rate
* Account balance

#### Current Account

* Account number
* Customer information
* Overdraft limit
* Account balance

The project implements these account types using separate model classes.

### 💰 Banking Operations

The application provides:

1. Create Customer
2. Create Account
3. Deposit Money
4. Withdraw Money
5. Transfer Money
6. Find Customer
7. Find Account
8. Display All Customers
9. Display All Accounts
10. Exit

These operations are exposed through the main console menu.

---

## 🧱 Project Structure

```text
com.sayedZabiulla.bankAccountManagemntSystem/
│
├── README.md
│
└── src/
    │
    ├── BankManagementSystem.java
    │
    ├── exception/
    │   ├── AccountNotFoundException.java
    │   ├── CustomerNotFoundException.java
    │   ├── InsufficientBalanceException.java
    │   └── InvalidAmountException.java
    │
    ├── interfaces/
    │   ├── AccountOperations.java
    │   └── BankOperations.java
    │
    ├── model/
    │   ├── Account.java
    │   ├── Customer.java
    │   ├── IndividualCustomer.java
    │   ├── BusinessCustomer.java
    │   ├── SavingsAccount.java
    │   └── CurrentAccount.java
    │
    └── service/
        └── Bank.java
```

The repository currently organizes the source into `model`, `service`, `interfaces`, and `exception` packages, with `BankManagementSystem.java` serving as the console entry point.

---

## 🏗️ Architecture

The project follows a simple layered/object-oriented structure:

```text
                    BankManagementSystem
                            │
                            ▼
                         Bank
                            │
              ┌─────────────┴─────────────┐
              ▼                           ▼
        Customer Models              Account Models
              │                           │
      ┌───────┴───────┐           ┌───────┴────────┐
      ▼               ▼           ▼                ▼
 Individual       Business     Savings          Current
 Customer         Customer     Account           Account
```

### Model Layer

Contains the core domain objects:

* `Customer`
* `IndividualCustomer`
* `BusinessCustomer`
* `Account`
* `SavingsAccount`
* `CurrentAccount`

### Service Layer

`Bank.java` manages:

* Customers
* Accounts
* Customer lookup
* Account lookup
* Deposits
* Withdrawals
* Transfers
* Display operations

The service maintains customers and accounts using Java `ArrayList` collections.

### Interface Layer

The project defines:

* `BankOperations`
* `AccountOperations`

These interfaces provide contracts for banking and account-related operations.

### Exception Layer

Custom exceptions are used to handle invalid operations:

* `CustomerNotFoundException`
* `AccountNotFoundException`
* `InsufficientBalanceException`
* `InvalidAmountException`

---

## 🧠 Core Java Concepts Demonstrated

This project is primarily designed to practice **Core Java and OOP concepts**.

### Object-Oriented Programming

* **Encapsulation**
* **Inheritance**
* **Polymorphism**
* **Abstraction**

### Java Concepts

* Classes and Objects
* Constructors
* Interfaces
* Method Overriding
* Inheritance
* Exception Handling
* Custom Exceptions
* `ArrayList`
* `Scanner`
* Loops
* Conditional Statements
* `switch`
* Method decomposition

---

## ⚙️ Requirements

Before running the project, make sure you have:

* **Java JDK 8 or higher**
* A Java IDE such as:

  * IntelliJ IDEA
  * Eclipse
  * VS Code
  * NetBeans

No external libraries or database are required.

---

## 🚀 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/SayedZabiulla/PROJECTS.git
```

### 2. Navigate to the project

```bash
cd PROJECTS/CORE\ JAVA\ PROJECTS/com.sayedZabiulla.bankAccountManagemntSystem
```

On Windows, you can simply open the project folder in your preferred Java IDE.

### 3. Compile the source files

From the `src` directory:

```bash
javac BankManagementSystem.java service/*.java model/*.java interfaces/*.java exception/*.java
```

### 4. Run the application

```bash
java BankManagementSystem
```

Alternatively, open `BankManagementSystem.java` in your IDE and run its `main()` method.

---

## 🖥️ Application Menu

When the application starts, the following menu is displayed:

```text
=================================
 BANK MANAGEMENT SYSTEM
=================================
1. Create Customer
2. Create Account
3. Deposit Money
4. Withdraw Money
5. Transfer Money
6. Find Customer
7. Find Account
8. Display All Customers
9. Display All Accounts
10. Exit
=================================
Enter your choice:
```

---

## 🔄 Example Workflow

A typical user flow is:

```text
1. Create Customer
        ↓
2. Create Account
        ↓
3. Deposit Money
        ↓
4. Withdraw Money
        ↓
5. Transfer Money
        ↓
6/7. Search Customer or Account
        ↓
8/9. Display Records
        ↓
10. Exit
```

For example:

1. Create an Individual Customer.
2. Create a Savings Account for that customer.
3. Deposit money into the account.
4. Withdraw money when required.
5. Create another account.
6. Transfer money between the two accounts.
7. Display account information.

---

## 🛡️ Exception Handling

The application uses custom exceptions to make banking operations safer and easier to understand.

Examples include:

### `CustomerNotFoundException`

Thrown when a customer cannot be found using the supplied customer ID.

### `AccountNotFoundException`

Thrown when an account cannot be found using the supplied account number.

### `InsufficientBalanceException`

Used when an account does not have sufficient funds for a withdrawal or transfer.

### `InvalidAmountException`

Used to handle invalid transaction amounts.

The `Bank` service explicitly uses these exceptions when performing customer/account searches and financial operations.

---

## 💾 Data Storage

This project currently uses Java `ArrayList` collections for storing customers and accounts:

```java
ArrayList<Customer> customers;
ArrayList<Account> accounts;
```

Therefore:

* Data is stored **in memory**.
* Data is lost when the application terminates.
* No database is currently required.

The `Bank` service manages these collections and performs operations on them.

---

## 🔐 Current Limitations

This project is intended as a **Core Java learning project**, rather than a production banking application.

Current limitations include:

* No database persistence
* No user authentication
* No password/PIN management
* No transaction history
* No GUI
* No REST API
* No concurrency handling
* No external payment integration

---

## 🔮 Future Enhancements

Possible improvements include:

* [ ] Add MySQL/PostgreSQL database support
* [ ] Add JDBC integration
* [ ] Add transaction history
* [ ] Add user authentication
* [ ] Add PIN/password security
* [ ] Add account statements
* [ ] Add interest calculation
* [ ] Add transaction timestamps
* [ ] Add JavaFX/Swing GUI
* [ ] Convert the application into a Spring Boot REST API
* [ ] Add unit and integration tests
* [ ] Add logging
* [ ] Add Maven/Gradle project configuration

---

## 📚 Learning Objectives

This project is useful for practicing:

> **Core Java → OOP → Interfaces → Inheritance → Collections → Exception Handling → Application Design**

It provides a practical example of how different Java concepts can be combined to build a small real-world-style application.

---

## 👨‍💻 Author

**Sayed Zabiulla**

GitHub:
https://github.com/SayedZabiulla

---

## 📄 License

This project is available for educational and learning purposes.

Feel free to explore, modify, and improve the implementation.