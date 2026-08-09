package model;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public class CurrentAccount extends Account{
    
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, Customer customer, double overdraftLimit){
        super(accountNumber, customer);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException{
        if (amount <= 0)
            throw new InvalidAmountException("Amount must be gretaer than Zero");
        double allowedAmount = getBalance() + overdraftLimit;
        if (allowedAmount < amount)
            throw new InsufficientBalanceException("Inssuficient Balance");
        updatedBalance(amount);
    }

    public boolean checkOverdraft(){
        if (getBalance()<0)
            return true;
        else 
            return false;
    }
}