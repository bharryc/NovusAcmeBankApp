package org.example.model;

public class Account {

    private String accountHolderName;
    private String accountNumber;
    private String address;
    private double balance = 1;

    public Account(String accountHolderName, String accountNumber, String address) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.address = address;
    }


    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAddress() {
        return address;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" + "ACCOUNT_NUMBER='" + accountNumber + '\'' + ", BALANCE=" + balance + '}';
    }
}
