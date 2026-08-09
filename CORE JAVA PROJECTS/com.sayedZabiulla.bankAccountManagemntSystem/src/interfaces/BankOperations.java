package interfaces;
import exception.CustomerNotFoundException;
import exception.AccountNotFoundException;
import model.Account;
import model.Customer;

public interface BankOperations {

    void addCustomer(Customer customer);
    void removeCustomer(String id) throws CustomerNotFoundException;
    Customer findCustomer(String id) throws CustomerNotFoundException;
    void openAccount(Account account);
    void closeAccount(String id) throws AccountNotFoundException;
    Account findAccount(String id) throws AccountNotFoundException;  

}