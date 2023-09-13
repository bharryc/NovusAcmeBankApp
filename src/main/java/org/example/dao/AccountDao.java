package org.example.dao;

import org.example.model.Account;

import java.util.List;


public interface AccountDao {

    void addAccount(Account acc);

    Account getAccountByAccountNumber(String id);

    List<Account> getAllUserAccounts(Long userId);
}
