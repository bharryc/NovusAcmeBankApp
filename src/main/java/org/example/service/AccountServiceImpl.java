package org.example.service;

import org.example.dao.PersonalAccountDao;
import org.example.model.Account;
import org.example.model.PersonalAccount;

public class AccountServiceImpl implements AccountService{

    private final AccNumberGenerator generator;
    private final ValidationService validationService;
    private final PersonalAccountDao dao;

    public AccountServiceImpl(AccNumberGenerator generator, ValidationService validationService, PersonalAccountDao dao) {
        this.generator = generator;
        this.validationService = validationService;
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
    public Account openBusinessAccount(String accNumber) {
        return null;
    }
}
