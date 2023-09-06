package org.example.model;

public class BusinessAccount extends Account{

    private String businessName;
    private boolean isCharity = false;


    public BusinessAccount(String accountHolderName, String address, String accountNumber, double balance, String businessName, boolean isCharity) {
        super(accountHolderName, accountNumber, address);
        this.businessName = businessName;
        this.isCharity = isCharity;
    }

    public void applyAnnualCharge() {
        if (!isCharity ) {
            deposit(-120); // Deduct the annual charge
        }
    }
}
