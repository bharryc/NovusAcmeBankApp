package org.example.service;

import org.example.dao.AccountDao;
import org.example.model.Account;
import org.example.model.BusinessAccount;

public class AccountServiceImpl implements AccountService{

    private final AccNumberGenerator generator;
    private final AccountDao dao;

    public AccountServiceImpl(AccNumberGenerator generator,  AccountDao dao) {
        this.generator = generator;
        this.dao = dao;
    }


    @Override
    public Account openPersonalAccount(String accHolderName) {


//        validationService.validateName();
////        validationService.validateAddress();
//        Account tempAcc = new PersonalAccount(accHolderName,generator.generateNumber());
//        dao.createAccount(tempAcc);
        return null;

    }

    @Override
    public Account openIsaAccount(String accNumber) {
        return null;
    }

    @Override
    public void openBusinessAccount(String accHolderName, String clientAddress , String businessAddress, String businessName) {

        //TO DO
        Account tempAcc = new BusinessAccount(accHolderName, generator.generateNumber(), clientAddress ,businessName,businessAddress);
        dao.addAccount(tempAcc);
    }




}
