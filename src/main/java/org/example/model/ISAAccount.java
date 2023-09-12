package org.example.model;

import java.util.Calendar;
import java.util.Date;

public class ISAAccount extends Account {

    private static final double ANNUAL_INTEREST_RATE = 0.0275;
    private static final int MAX_ISA_COUNT = 1; // Maximum number of ISAs a customer can have
    private Date lastInterestCalculationDate;

    public ISAAccount(String accountNumber, long userId) {
        super( accountNumber, userId);
        super.setType("ISA");

        this.lastInterestCalculationDate = new Date();
    }

    public static double getAnnualInterestRate() {
        return ANNUAL_INTEREST_RATE;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount); // Call the deposit method of the parent class
        calculateInterest(); // Calculate and apply interest for the deposit
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals are not allowed from an ISA account.");
    }

    @Override
    public void getDescription() {
        System.out.println("ISA Account Rules for Bank Teller:");
        System.out.println("1. Customers are eligible for an ISA account if they meet the criteria set by the government.");
        System.out.println("2. ISA accounts offer a tax-free savings environment.");
        System.out.println("3. Customers can contribute to only one ISA account per tax year.");
        System.out.println("4. The annual interest rate for ISAs is 2.75% APR.");
        System.out.println("5. Customers can make deposits into their ISA account.");
        System.out.println("6. Withdrawals from an ISA account are not allowed except in specific circumstances.");
        System.out.println("7. Interest is calculated and credited annually.");
        System.out.println("8. The maximum allowed balance in an ISA account depends on government regulations.");
    }

    private void calculateInterest() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastInterestCalculationDate);
        calendar.add(Calendar.YEAR, 1); // Calculate interest annually

        Date currentDate = new Date();
        if (currentDate.after(calendar.getTime())) {
            // A year has passed, calculate and apply interest
            double currentBalance = getBalance();
            double annualInterest = currentBalance * ANNUAL_INTEREST_RATE;
            super.deposit(annualInterest); // Deposit the annual interest
            lastInterestCalculationDate = currentDate; // Update the last interest calculation date
        }
    }

    public Date getLastInterestCalculationDate() {
        return lastInterestCalculationDate;
    }



    @Override
    public String toString() {
        return "ISAAccount{" + "lastInterestCalculationDate=" + lastInterestCalculationDate + '}';
    }
}

