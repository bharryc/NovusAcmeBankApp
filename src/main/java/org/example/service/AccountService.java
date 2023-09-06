package org.example.service;

import org.example.model.Account;

public interface AccountService {

    Account openPersonalAccount(String holderName);
    Account openIsaAccount(String accNumber);
    Account openBusinessAccount(String accNumber);

}
