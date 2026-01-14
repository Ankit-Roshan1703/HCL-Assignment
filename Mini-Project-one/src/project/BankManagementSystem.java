package project;

import java.util.Scanner;
import java.io.*;

abstract class Account {
    protected int accountNumber;
    protected String customerName;
    protected double balance;

    Account(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    public void showDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Balance: ₹" + balance);
    }
}

class SavingsAccount extends Account {

    SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

class CurrentAccount extends Account {

    CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount);
    }

    @Override
    void withdraw(double amount) {
        balance -= amount; // overdraft allowed
        System.out.println("Withdrawn ₹" + amount);
    }
}


public class BankManagementSystem {

    static final String FILE_NAME = "accounts.txt";

    static void saveToFile(Account acc) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(acc.accountNumber + "," + acc.customerName + "," + acc.balance + "\n");
        fw.close();
    }

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Account account = null;

        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Current Account");
        int choice = sc.nextInt();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        if (choice == 1) {
            account = new SavingsAccount(accNo, name, bal);
        } else {
            account = new CurrentAccount(accNo, name, bal);
        }

        saveToFile(account);

        int option;
        do {
            System.out.println("\n1.Deposit  2.Withdraw  3.Balance  4.Details  5.Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Amount: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Amount: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Balance: ₹" + account.balance);
                    break;
                case 4:
                    account.showDetails();
                    break;
            }
        } while (option != 5);

        sc.close();
    }
}

