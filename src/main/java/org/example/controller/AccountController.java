package org.example.controller;

import org.example.model.Account;
import org.example.model.User;
import org.example.service.AccountService;
import org.example.service.UserService;
import org.example.view.TellersView;

import java.util.List;

public class AccountController {

    private final UserService userService;
    private final AccountService accService;
    private final TellersView view;

    public AccountController(UserService userService, AccountService service, TellersView view) {
        this.userService = userService;
        this.accService = service;
        this.view = view;
    }

    public static void simulateLoading() {
        System.out.print("Loading: ");
        for (int i = 0; i <= 3; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000); // Simulate some work (100 milliseconds)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
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
                case 4 -> viewUserAccounts();
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

    //Creates the personal account by calling on the UserService to create the user and open account.
    private void openPersonalAccount() {
        view.displayOpenPersonalAccountBanner();
        String name = view.requestUserName();
        String photoID = view.requestPhotoId();
        String photoIDType = view.requestPhotoIdType();
        String addressBasedId = view.requestAddressBasedId();
        String addressBasedIdType = view.requestAddressBasedIdType();
        String userAddress = view.getAddress();

        try {
            simulateLoading();
            User user = userService.createUser(name, photoID, photoIDType, addressBasedId, addressBasedIdType, userAddress);
            accService.openPersonalAccount(user.getUserId());
            view.displaySuccessMessage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Creates the ISA account by calling on the UserService to find the user's personal and open an ISA account.
    private void openISAAccount() {

        view.displayISAAccountBanner();

        if (view.userHasPersonalAccount()) {

            Long userId = view.getUserId();
            String accountNumber = view.getAccountNumber();

            User tempUser = userService.getUserById(userId);
            Account tempAcc = accService.getAccountByAccountNumber(accountNumber);

            //Checking if user exists than we create the business account
            if (tempUser != null && tempAcc != null) {
                try {
                    simulateLoading();
                    accService.openIsaAccount(userId);
                    view.displayISAAccountCreated(tempUser.getName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("User or personal account not found.");
            }
        } else {
            System.out.println("Sorry, you first have to open a personal account.");
            openPersonalAccount();
        }
    }

    //Creates the business account by calling on the UserService to see if the user has a personal account
    //Then checks to see if the type is a charity or not as they are not served.
    //Checks if user exists or not and then creates account.
    private void openBusinessAccount() {

        view.displayBusinessAccountNumberBanner();

        //If the business is a charity business let user know that we don't serve them.
        if (view.getIsCharity()) {
            System.out.println("Sorry but we are not serving charity organisations, instead you can create a personal account :)");
            openPersonalAccount();
        }

        if (view.userHasPersonalAccount()) {
            Long userId = view.getUserId();
            String personalAccountId = view.getAccountNumber();
            User tempUser = userService.getUserById(userId);
            Account tempAcc = accService.getAccountByAccountNumber(personalAccountId);

            //Checking if user exists than we create the business account
            if (tempUser != null && tempAcc != null) {
                String businessAddress = view.getBusinessAddress();
                String businessName = view.getBusinessName();
                try {
                    simulateLoading();
                    accService.openBusinessAccount(userId, businessName, businessAddress);
                    //passing the name and account number to the view for rendering
                    view.displayBusinessAccountCreated(tempUser.getName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("User or personal account not found.");
            }
        } else {
            System.out.println("Sorry, you first have to open a personal account.");
            openPersonalAccount();
        }
    }

    //Gets all accounts based on a user ID.
    private void viewUserAccounts() {
        view.displayAccountsBanner();
        Long userId = view.getUserId();

        try {
            List<Account> accounts = accService.getAccounts(userId);
            simulateLoading();
            view.displayListOfAccounts(accounts);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Searches for an account based on the account number.
    private void searchForAccount() {
        view.displaySearchAccountById();
        String accountId = view.getAccountNumber();

        try {
            simulateLoading();
            Account acc = accService.getAccountByAccountNumber(accountId);
            view.displayAccount(acc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
