package org.example.model;

public class BusinessAccount extends Account{

    private String businessName;
    private String proofAddressId;

    public BusinessAccount(String accountHolderName, String accountNumber, String address, String businessName, String proofAddressId) {
        super(accountHolderName, accountNumber, address);
        this.businessName = businessName;
        this.proofAddressId = proofAddressId;
        super.setType("BA");
    }


    public String getBusinessName() {
        return businessName;
    }

    public String getProofAddressId() {
        return proofAddressId;
    }
}
