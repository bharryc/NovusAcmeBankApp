package org.example.dao;

import org.example.model.Account;
import org.example.model.PersonalAccount;

import java.util.HashMap;
import java.util.Map;

public class PersonalAccountDaoImpl implements PersonalAccountDao {

    Map<String, Account> accountMap = new HashMap<>();

    @Override
    public void createAccount(Account acc) {

    }
}
