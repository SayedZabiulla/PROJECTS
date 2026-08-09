package model;

public class SavingsAccount extends Account{
    
    private double interestRate;
    
    
    public SavingsAccount(String accountNumber, Customer customer, double interestRate){
        super(accountNumber, customer);
        this.interestRate = interestRate;   
    }

    public void addInterest(){
        double intersetAmount = getBalance() * interestRate /100;
        addToBalance(intersetAmount);
    }
}