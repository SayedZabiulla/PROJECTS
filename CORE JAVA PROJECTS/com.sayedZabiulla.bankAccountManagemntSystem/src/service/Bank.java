package service;
import java.util.ArrayList;
import exception.AccountNotFoundException;
import exception.CustomerNotFoundException;
import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import interfaces.BankOperations;
import model.Account;
import model.Customer;

public class Bank implements BankOperations{
    
    ArrayList<Customer> customers =new ArrayList<>(); 
    ArrayList<Account> accounts =new ArrayList<>();

    public Bank(){
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void removeCustomer(String id) throws CustomerNotFoundException{
        boolean removed = customers.removeIf(
            customer -> customer.getCustomerId().equals(id)
        );

        if (!removed) {
            throw new CustomerNotFoundException("Wrong Customer ID");
        }
    }

    @Override
    public Customer findCustomer(String id) throws CustomerNotFoundException{
        for (Customer i : customers){
            if (i.getCustomerId().equals(id)){
                return i;
            }
        }
        throw new CustomerNotFoundException("Wrong Customer ID");
    }

    @Override
    public void openAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public void closeAccount(String id) throws AccountNotFoundException{
        boolean removed = accounts.removeIf(
            account -> account.getAccountNumber().equals(id)
        );

        if (!removed) {
            throw new AccountNotFoundException("Account not Found");
        }
    }

   @Override
   public Account findAccount(String id) throws AccountNotFoundException{
       for (Account i: accounts){
        if (i.getAccountNumber().equals(id))
            return i;
       }
       throw new AccountNotFoundException("Account not Found");
   }

   public void deposit(String accountNo, double amount) throws AccountNotFoundException, InvalidAmountException{
        Account account = findAccount(accountNo);
        account.deposit(amount);
   }

   public void withdraw(String accountNo, double amount) throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException{
        Account account = findAccount(accountNo);
        account.withdraw(amount);
   }

   public void transferMoney(String from, String to, double amount)throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException{
        findAccount(from);
        findAccount(to);
        withdraw(from, amount);
        deposit(to, amount);    
   }

   public void displayCustomers(){
        for (Customer i : customers){
            i.displayDetails();
        }
   }

   public void displayAccounts(){
        for (Account i : accounts){
            System.out.println("Account Number: "
                    + i.getAccountNumber());

            System.out.println("Customer: "
                    + i.getCustomer().getName());

            System.out.println("Balance: "
                    + i.getBalance());

            System.out.println("Account Type: "
                    + i.getClass().getSimpleName());

            System.out.println("---------------------------");
        }
   }
}