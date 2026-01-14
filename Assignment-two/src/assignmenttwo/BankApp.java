package assignmenttwo;

interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double checkBalance();
}

interface CustomerOperations {
    void showCustomerDetails();
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount implements BankOperations, CustomerOperations {

    private int accountNumber;
    private String customerName;
    private double balance;

    public BankAccount(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Amount deposited: ₹" + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal");
        }
        balance -= amount;
        System.out.println("Amount withdrawn: ₹" + amount);
    }

    @Override
    public double checkBalance() {
        return balance;
    }
    @Override
    public void showCustomerDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}


public class BankApp {

    public static void main(String[] args) {
        
        BankAccount account = new BankAccount(101, "Aniket", 5000);

        try {
            account.showCustomerDetails();
            account.deposit(2000);
            account.withdraw(1000);
            account.withdraw(7000); // This will throw exception
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        } finally {
            System.out.println("Final Balance: ₹" + account.checkBalance());
        }
    }
    
}
