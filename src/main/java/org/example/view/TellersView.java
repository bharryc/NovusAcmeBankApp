package org.example.view;

import org.example.model.Account;
import org.example.ui.TellerIO;

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

    public String getAccountHolderName() {
        return io.readString("What is your name?");
    }

    public void displayAccount(Account acc) {

        /***TO DO*/
        io.print("That's your account");
    }


    // Add ISA Account
    public void displayISAAccountBanner() {
        io.print("-*    |Add ISA Account|    *-");
    }

    public String getAddress(){
        return io.readString("What is your address?");
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

    public String getClientAddress() {
        return io.readString("What is the client address? ");
    }



    public String getUserAccNumber() {
        return io.readString("Acc#: ");
    }



}
