package org.example.model;

import java.util.Calendar;
import java.util.Date;

public class PersonalAccount extends Account {
    private static final double MONTHLY_CHARGE = 10.0;
    private Date lastChargeDate;

    public PersonalAccount(String accountNumber, long userId) {
        super(accountNumber, userId);
    }

    @Override
    public void withdraw(double amount) {
        checkAndApplyMonthlyCharge();
        super.withdraw(amount);
        checkAndNotifyZeroBalance();
    }

    @Override
    public void getDescription() {
        System.out.println("Personal Account Rules for Bank Teller:");
        System.out.println("1. All customers must provide a valid photo ID (e.g., passport, driving license).");
        System.out.println("2. Customers should also provide an address-based ID (e.g., utility bill, council letter).");
        System.out.println("3. The minimum initial deposit to open an account is £1 (GBP).");
        System.out.println("4. There are no charges for owning a Personal Account.");
        System.out.println("5. Be cautious of accounts in the red, as they may incur charges of 10 pounds per month.");
        System.out.println("6. Customers can set up direct debits and standing orders for bill payments.");
        System.out.println("7. Customers can have multiple Personal Accounts.");
    }


    private void checkAndApplyMonthlyCharge() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastChargeDate);
        calendar.add(Calendar.MONTH, 1); // Add one month to the last charge date

        Date currentDate = new Date();
        if (currentDate.after(calendar.getTime())) {
            // It's a new month, apply the monthly charge
            double currentBalance = getBalance();
            if (currentBalance >= MONTHLY_CHARGE) {
                super.withdraw(MONTHLY_CHARGE); // Apply the monthly charge
                lastChargeDate = currentDate; // Update the last charge date
            } else {
                // Balance is less than the monthly charge, can't apply the charge
                System.out.println("Insufficient balance to apply monthly charge.");
            }
        }
    }

    private void checkAndNotifyZeroBalance() {
        if (getBalance() == 0) {
            System.out.println("Your account balance has reached zero.");
        }
    }


}

