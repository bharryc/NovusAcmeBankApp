package org.example.view;

import org.example.model.Account;
import org.example.ui.TellerIO;

import java.util.List;

public class TellersView {
    private final TellerIO io;

    public TellersView(TellerIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("----------------------------");
        io.print("|*         Acme Bank         *|");
        io.print("-------------------------------");
        io.print("| 1. Open Personal Account    |");
        io.print("| 2. Open ISA Account         |");
        io.print("| 3. Open Business account    |");
        io.print("| 4. View Accounts            |");
        io.print("| 5. Search for Account       |");
        io.print("| 6. Quit                     |");
        io.print("-------------------------------");

        return io.readInt("--> Please select from the above choices.", 1, 6);
    }

    //Add personal Account Section
    public void displayOpenPersonalAccountBanner() {
        io.print("-*    |Add Personal Account|    *-");
    }

    public String requestUserName() {
        return io.readString("What is your name?");
    }

    public String requestPhotoId() {
        return io.readString("Enter the proof of id number: Passport Number/ Student ID");
    }

    public String requestPhotoIdType() {
        return io.readString("What type of id you have? Passport/Student Card ");
    }

    public String requestAddressBasedId() {
        return io.readString("Enter the id from the proof of address provided? ");
    }

    public String requestAddressBasedIdType() {
        return io.readString("What proof of address are you providing? Bill/Payslip");
    }

    public String getAddress() {
        return io.readString("What is your address?");
    }

    public void displaySuccessMessage() {
        io.print("Congratulations!!! Account was created!");
    }


    // Add ISA Account
    public void displayISAAccountBanner() {
        io.print("-*    |Add ISA Account|    *-");
    }

    public boolean userHasPersonalAccount() {
        return io.readYesNo("Do you have personal account? ");
    }

    public String getAccountHolderName() {
        return io.readString("What is your name? ");
    }

    public Long getUserId() {
        return io.readLong("What is your User Id? ");
    }

    public String getAccountNumber() {
        return io.readString("Enter the personal account id number");
    }

    public void displayISAAccountCreated(String username) {
        io.print("Congratulations " + username + " your ISA account was created!!");
    }


    //Add Business Account

    public void displayBusinessAccountNumberBanner() {
        io.print("-*    |Add Business Account|    *-");

    }

    public boolean getIsCharity() {
        return io.readYesNo("Is this a charity business?");
    }

    public String getBusinessAddress() {
        return io.readString("Enter business address?");
    }

    public String getBusinessName() {

        return io.readString("Enter the Company Name?");
    }

    public void displayBusinessAccountCreated(String username) {
        io.print("Congratulations " + username + " your Business account was created!!");
    }


    //View Accounts Section
    public void displayAccountsBanner() {
        io.print("-*    |View Accounts |    *-");
    }

    public void displayListOfAccounts(List<Account> accounts) {

        for (Account acc : accounts) {
            io.print(acc.toString());
        }
    }

    //Search Account By ID section

    public void displaySearchAccountById() {
        io.print("-*    |Search Account By ID |    *-");
    }

    public void displayAccount(Account acc) {
        io.print(acc.toString());
        acc.getDescription();
    }

}
