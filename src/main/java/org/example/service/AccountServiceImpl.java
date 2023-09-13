package org.example.service;

import org.example.dao.AccountDao;
import org.example.model.*;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private final AccNumberGenerator generator;
    private final AccountDao dao;

    public AccountServiceImpl(AccNumberGenerator generator, AccountDao dao) {
        this.generator = generator;
        this.dao = dao;
    }


    @Override
    public void openPersonalAccount(long userId) {

        Account tempAcc = new PersonalAccount(generator.generateNumber(),userId);
        dao.addAccount(tempAcc);
    }

    @Override
    public void openIsaAccount(long userId) {

        Account tempAcc = new ISAAccount(generator.generateNumber(),userId);
        dao.addAccount(tempAcc);
    }

    @Override
    public void openBusinessAccount(long userId,String businessName, String businessAddress) {

        Account tempAcc = new BusinessAccount(generator.generateNumber(),userId, businessName, businessAddress);
        dao.addAccount(tempAcc);
    }

    public Account getAccountByAccountNumber(String personalAccountId) {
        return dao.getAccountByAccountNumber(personalAccountId);
    }

    @Override
    public List<Account> getAccounts(Long userId) {
        return dao.getAllUserAccounts(userId);
    }
}
