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
        io.print("-*    |Add personal account|    *-");
    }

    public String getAccountHolderName() {
        return io.readString("What is your name?");
    }

    public void displayAccount(Account acc) {

        /***TO DO*/
        io.print("That's your account");
    }






    public String getUserAccNumber() {
        return io.readString("Acc#: ");
    }


}
