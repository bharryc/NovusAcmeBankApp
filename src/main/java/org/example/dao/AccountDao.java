package org.example.dao;

import org.example.model.Account;

import java.util.List;


public interface AccountDao {

    void addAccount(Account acc);

    Account getAccount(String id);

    List<Account> fetchAccounts(String clientName, String accNumber);




}
