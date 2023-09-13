package org.example;


import org.example.controller.AccountController;
import org.example.dao.AccountDao;
import org.example.dao.AccountDaoImpl;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.service.*;
import org.example.ui.TellerIO;
import org.example.ui.TellerIOConsoleImpl;
import org.example.view.TellersView;

public class App
{
    public static void main( String[] args ) {
        AccNumberGenerator generator = new AccNumberGeneratorImpl();
        AccountDao accountDao = new AccountDaoImpl();
        UserDao userDao = new UserDaoImpl();
        AccountService accountService = new AccountServiceImpl(generator,accountDao);
        UserService userService = new UserServiceImpl(userDao);
        TellerIO io = new TellerIOConsoleImpl();
        TellersView view = new TellersView(io);
        AccountController controller = new AccountController(userService, accountService, view);
        controller.run();
}}
