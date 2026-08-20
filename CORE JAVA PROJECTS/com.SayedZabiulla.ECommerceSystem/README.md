# E-Commerce Management System (Core Java)

A console-based **E-Commerce Management System** built using **Core Java**. This project demonstrates Object-Oriented Programming (OOP), Collections, Interfaces, Abstract Classes, Exception Handling, Multithreading, and Synchronization without using a database. All data is managed in memory using `ArrayList`.

## Features

- Admin can add, remove, update, and view products.
- Customer registration and profile display.
- Customer login and logout.
- Add and remove products from cart.
- View shopping cart.
- Place orders using UPI payment.
- View order history.
- Order processing using multithreading.
- Thread-safe order processing using `ReentrantLock`.

## Concepts Used

- Core Java
- Object-Oriented Programming
  - Encapsulation
  - Inheritance
  - Polymorphism
  - Abstraction
- Abstract Classes
- Interfaces
- Constructors
- Method Overriding
- ArrayList Collections
- Custom Exception (`OutOfStockException`)
- Multithreading
- Synchronization using `ReentrantLock`
- Exception Handling

## Project Structure

```text
src/
│
├── Main.java
├── User.java
├── Customer.java
├── Admin.java
├── Product.java
├── Order.java
├── ECommerceService.java
├── PaymentMethod.java
├── UPIPayment.java
├── OrderProcessor.java
└── OutOfStockException.java
```

## Class Overview

| Class | Purpose |
|--------|---------|
| `User` | Abstract base class for users |
| `Customer` | Manages cart and orders |
| `Admin` | Manages products |
| `Product` | Stores product details |
| `Order` | Stores order information |
| `ECommerceService` | Manages products and customers |
| `PaymentMethod` | Payment interface |
| `UPIPayment` | UPI payment implementation |
| `OrderProcessor` | Processes orders using threads |
| `OutOfStockException` | Custom exception |

## How to Run

1. Clone the repository.

```bash
git clone https://github.com/your-username/ecommerce-system.git
```

2. Open the project in your preferred Java IDE.
3. Compile all Java files.
4. Run `Main.java`.

## Sample Workflow

1. Create an Admin.
2. Register a Customer.
3. Admin adds products.
4. Customer views products.
5. Customer adds products to cart.
6. Customer places an order using UPI.
7. Order is processed in a separate thread.
8. Customer views order history.

## Learning Outcomes

This project helped practice:

- Designing software using OOP principles.
- Working with interfaces and abstract classes.
- Managing in-memory data using `ArrayList`.
- Creating custom exceptions.
- Implementing multithreading with `Thread`.
- Protecting critical sections using `ReentrantLock`.
- Building a structured Java console application.