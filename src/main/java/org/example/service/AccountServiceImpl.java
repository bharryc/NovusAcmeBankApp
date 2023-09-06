package org.example.service;

import org.example.dao.AccountDao;
import org.example.model.Account;
import org.example.model.BusinessAccount;
import org.example.model.ISAAccount;

public class AccountServiceImpl implements AccountService{

    private final AccNumberGenerator generator;
    private final AccountDao dao;

    public AccountServiceImpl(AccNumberGenerator generator,  AccountDao dao) {
        this.generator = generator;
        this.dao = dao;
    }


    @Override
    public Account openPersonalAccount(String accHolderName) {
        return null;
    }

    @Override
    public void openIsaAccount(String accHolderName, String address) {

        //Validation
        Account tempAcc = new ISAAccount(accHolderName, generator.generateNumber(), address);
        dao.addAccount(tempAcc);
    }

    @Override
    public void openBusinessAccount(String accHolderName, String clientAddress , String businessAddress, String businessName) {

        //TO DO
        Account tempAcc = new BusinessAccount(accHolderName, generator.generateNumber(), clientAddress ,businessName,businessAddress);
        dao.addAccount(tempAcc);
    }




}
