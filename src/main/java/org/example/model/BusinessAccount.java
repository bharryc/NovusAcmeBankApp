package org.example.model;

public class BusinessAccount extends Account {
    private static final double ANNUAL_CHARGE = 120.0;
    private  String businessName;
    private  String businessAddress;

    private boolean hasBusinessChequeBook;
    private final boolean hasDebitCard;
    private final boolean hasCreditCard;
    private boolean hasOverdraft;
    private final boolean canAccessInternationalTrading;
    private final boolean canAccessLoans;

    public BusinessAccount( String accountNumber, long userId , String businessName, String businessAddress) {
        super(accountNumber,userId);
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        super.setType("BA");
        this.hasBusinessChequeBook = false;
        this.hasDebitCard = true; // Debit card is issued by default
        this.hasCreditCard = false;
        this.hasOverdraft = false;
        this.canAccessInternationalTrading = true; // Business accounts can access international trading
        this.canAccessLoans = true; // Business accounts can access loans
    }

    public BusinessAccount(String accountNumber, Long userId) {
        super(accountNumber,userId);
        super.setType("BA");
        this.hasBusinessChequeBook = false;
        this.hasDebitCard = true; // Debit card is issued by default
        this.hasCreditCard = false;
        this.hasOverdraft = false;
        this.canAccessInternationalTrading = true; // Business accounts can access international trading
        this.canAccessLoans = true; // Business accounts can access loans
    }

    public void requestBusinessChequeBook() {
        this.hasBusinessChequeBook = true;
    }

    public void applyForOverdraft() {
        this.hasOverdraft = true;
    }

    public boolean hasBusinessChequeBook() {
        return hasBusinessChequeBook;
    }

    public boolean hasDebitCard() {
        return hasDebitCard;
    }

    public boolean hasCreditCard() {
        return hasCreditCard;
    }

    public boolean hasOverdraft() {
        return hasOverdraft;
    }

    public boolean canAccessInternationalTrading() {
        return canAccessInternationalTrading;
    }

    public boolean canAccessLoans() {
        return canAccessLoans;
    }

    public static double getAnnualCharge() {
        return ANNUAL_CHARGE;
    }

    public boolean isHasBusinessChequeBook() {
        return hasBusinessChequeBook;
    }

    public void setHasBusinessChequeBook(boolean hasBusinessChequeBook) {
        this.hasBusinessChequeBook = hasBusinessChequeBook;
    }

    public boolean isHasDebitCard() {
        return hasDebitCard;
    }

    public boolean isHasCreditCard() {
        return hasCreditCard;
    }

    public boolean isHasOverdraft() {
        return hasOverdraft;
    }

    public void setHasOverdraft(boolean hasOverdraft) {
        this.hasOverdraft = hasOverdraft;
    }

    public boolean isCanAccessInternationalTrading() {
        return canAccessInternationalTrading;
    }

    public boolean isCanAccessLoans() {
        return canAccessLoans;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    @Override
    public String toString() {
        return "BusinessAccount{ accountNumber: " +super.getAccountNumber()+ " hasBusinessChequeBook=" + hasBusinessChequeBook + ", hasDebitCard=" + hasDebitCard + ", hasCreditCard=" + hasCreditCard + ", hasOverdraft=" + hasOverdraft + ", canAccessInternationalTrading=" + canAccessInternationalTrading + ", canAccessLoans=" + canAccessLoans + '}';
    }
}
