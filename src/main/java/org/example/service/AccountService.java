package org.example.service;

import org.example.model.Account;
import org.example.model.User;

import java.util.List;

public interface AccountService {

    void openPersonalAccount(long userId);

    void openIsaAccount(long userId);

    void openBusinessAccount(long userId, String businessName, String businessAddress);

    Account getAccountByAccountNumber(String personalAccountId);

    List<Account> getAccounts(Long userId);

}
