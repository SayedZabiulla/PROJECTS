import service.Bank;
import java.util.Scanner;
import exception.CustomerNotFoundException;
import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import exception.AccountNotFoundException;
import model.Customer;
import model.CurrentAccount;
import model.Account;
import model.BusinessCustomer;
import model.IndividualCustomer;
import model.SavingsAccount;

public class BankManagementSystem {

    private Bank bank;
    private Scanner scanner;

    public BankManagementSystem() {
        bank = new Bank();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {

        BankManagementSystem bankManagementSystem = new BankManagementSystem();

        bankManagementSystem.showMenu();
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("=================================");
            System.out.println("      BANK MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. Find Customer");
            System.out.println("7. Find Account");
            System.out.println("8. Display All Customers");
            System.out.println("9. Display All Accounts");
            System.out.println("10. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    createCustomer();
                    break;

                case 2:
                    createAccount();
                    break;

                case 3:
                    depositMoney();
                    break;

                case 4:
                    withdrawMoney();
                    break;

                case 5:
                    transferMoney();
                    break;

                case 6:
                    findCustomer();
                    break;

                case 7:
                    findAccount();
                    break;

                case 8:
                    displayCustomers();
                    break;

                case 9:
                    displayAccounts();
                    break;

                case 10:
                    exit();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 10);
    }

    public void createCustomer() {

        System.out.println();
        System.out.println("Select Customer Type:");
        System.out.println("1. Individual Customer");
        System.out.println("2. Business Customer");

        System.out.print("Enter your choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Customer customer;

        if (type == 1) {

            System.out.print("Enter Occupation: ");
            String occupation = scanner.nextLine();

            customer = new IndividualCustomer(
                    customerId,
                    name,
                    phone,
                    email,
                    occupation);

        } else if (type == 2) {

            System.out.print("Enter Business Name: ");
            String businessName = scanner.nextLine();

            customer = new BusinessCustomer(
                    customerId,
                    name,
                    phone,
                    email,
                    businessName);

        } else {

            System.out.println("Invalid customer type.");
            return;
        }

        bank.addCustomer(customer);

        System.out.println("Customer created successfully!");
    }

    public void createAccount() {

        System.out.println();
        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        System.out.print("Enter your choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        try {

            Customer customer = bank.findCustomer(customerId);

            System.out.print("Enter Account Number: ");
            String accountNumber = scanner.nextLine();

            Account account;

            if (type == 1) {

                System.out.print("Enter Interest Rate: ");
                double interestRate = scanner.nextDouble();

                account = new SavingsAccount(
                        accountNumber,
                        customer,
                        interestRate);

            } else if (type == 2) {

                System.out.print("Enter Overdraft Limit: ");
                double overdraftLimit = scanner.nextDouble();

                account = new CurrentAccount(
                        accountNumber,
                        customer,
                        overdraftLimit);

            } else {

                System.out.println("Invalid account type.");
                return;
            }

            bank.openAccount(account);

            System.out.println("Account created successfully!");

        } catch (CustomerNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    public void depositMoney() {

        scanner.nextLine();

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter Deposit Amount: ");
        double amount = scanner.nextDouble();

        try {

            bank.deposit(accountNumber, amount);

            System.out.println("Amount deposited successfully!");

        } catch (AccountNotFoundException | InvalidAmountException e) {

            System.out.println(e.getMessage());
        }
    }

    public void withdrawMoney() {

        scanner.nextLine();

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter Withdrawal Amount: ");
        double amount = scanner.nextDouble();

        try {

            bank.withdraw(accountNumber, amount);

            System.out.println("Amount withdrawn successfully!");

        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {

            System.out.println(e.getMessage());
        }
    }

    public void transferMoney() {

        scanner.nextLine();

        System.out.print("Enter Source Account Number: ");
        String from = scanner.nextLine();

        System.out.print("Enter Destination Account Number: ");
        String to = scanner.nextLine();

        System.out.print("Enter Transfer Amount: ");
        double amount = scanner.nextDouble();

        try {

            bank.transferMoney(from, to, amount);

            System.out.println("Money transferred successfully!");

        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {

            System.out.println(e.getMessage());
        }
    }

    public void findCustomer() {

        scanner.nextLine();

        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        try {

            Customer customer = bank.findCustomer(id);

            customer.displayDetails();

        } catch (CustomerNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    public void findAccount() {

        scanner.nextLine();

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        try {

            Account account = bank.findAccount(accountNumber);

            System.out.println();
            System.out.println("Account Number: "
                    + account.getAccountNumber());

            System.out.println("Customer: "
                    + account.getCustomer().getName());

            System.out.println("Balance: "
                    + account.getBalance());

            System.out.println("Account Type: "
                    + account.getClass().getSimpleName());

        } catch (AccountNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    public void displayCustomers() {

        bank.displayCustomers();
    }

    public void displayAccounts() {

        bank.displayAccounts();
    }

    public void exit() {

        System.out.println();
        System.out.println("Thank you for using Bank Management System!");

        scanner.close();
    }
}