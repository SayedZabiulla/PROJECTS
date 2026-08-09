package model;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import interfaces.AccountOperations;

public abstract class Account implements AccountOperations{
    
    private String accountNumber ;
    private double balance;
    private Customer customer;

    public Account (String accountNumber, Customer customer){
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Amount Must be Greater than 0");
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException{
        if (amount <= 0)
            throw new InvalidAmountException("Amount Must be Greater than 0");
        if (getBalance()<amount)
            throw new InsufficientBalanceException("Balance is not Sufficient");
        balance -=amount;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    protected void addToBalance(double amount){
        balance += amount;
    }

    protected void updatedBalance(double amount){
        balance -= amount;
    }
}