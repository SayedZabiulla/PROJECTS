package interfaces;

import exception.InsufficientBalanceException;
import exception.InvalidAmountException;

public interface AccountOperations {

    void deposit (double amount) throws InvalidAmountException;
    void withdraw (double amount) throws InsufficientBalanceException, InvalidAmountException;
    double checkBalance();

}
