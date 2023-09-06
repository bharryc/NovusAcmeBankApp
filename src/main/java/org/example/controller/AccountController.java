package org.example.controller;

import org.example.model.Account;
import org.example.service.AccountServiceImpl;
import org.example.view.TellersView;

public class AccountController {

    private final AccountServiceImpl service;
    private final TellersView view;

    public AccountController(AccountServiceImpl service, TellersView view) {
        this.service = service;
        this.view = view;
    }


    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1 -> openPersonalAccount();
                case 2 -> openISAAccount();
                case 3 -> openBusinessAccount();
                case 4 -> viewAccounts();
                case 5 -> searchForAccount();
                case 6 -> keepGoing = false;
                default -> System.out.println("Hope you love it!");
            }
        }
        System.out.println("Good Bye!");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void openPersonalAccount() {
        view.displayOpenPersonalAccountBanner();
        String accHolderName = view.getAccountHolderName();

        try {
            Account acc = service.openPersonalAccount(accHolderName);
            view.displayAccount(acc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //TO DO

    }

    private void openISAAccount() {

        view.displayISAAccountBanner();

        String accHolderName = view.getAccountHolderName();
        String address = view.getAddress();
        service.openIsaAccount(accHolderName, address);
    }

    private void openBusinessAccount() {

        view.displayBusinessAccountNumberBanner();

        if(!view.getIsCharity()){
            String accHolderName = view.getAccountHolderName();
            String businessAddress = view.getBusinessAddress();
            String businessName = view.getBusinessName();
            String clientAddress = view.getClientAddress();

            service.openBusinessAccount(accHolderName,businessAddress,businessName,clientAddress);

        }else{
            openPersonalAccount();
        }



    }



    private void searchForAccount() {
//        view.displaySearchForAccountView();
//        String accNumber = view.getUserAccNumber();


    }

    private void viewAccounts() {
    }
}
