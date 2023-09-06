package org.example.service;

import org.example.model.Account;

public interface AccountService {

    Account openPersonalAccount(String holderName);

    void openIsaAccount(String accNumber, String address);

    void openBusinessAccount(String accHolderName, String clientAddress , String businessAddress, String businessName);

}
