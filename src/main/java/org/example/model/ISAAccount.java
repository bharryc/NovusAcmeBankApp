package org.example.model;

public class ISAAccount extends Account{

    private static final double ANNUAL_APR = 0.0275;

    public ISAAccount(String accountHolderName, String accountNumber, String address) {
        super(accountHolderName, accountNumber, address);
    }

    public double calculateAnnualInterest() {
        return getBalance() * ANNUAL_APR;
    }
}
