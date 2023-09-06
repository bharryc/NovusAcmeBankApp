package org.example;


import org.example.controller.AccountController;
import org.example.dao.PersonalAccountDao;
import org.example.dao.PersonalAccountDaoImpl;
import org.example.service.*;
import org.example.ui.TellerIO;
import org.example.ui.TellerIOConsoleImpl;
import org.example.view.TellersView;

public class App
{
    public static void main( String[] args ) {
        AccNumberGenerator generator = new AccNumberGeneratorImpl();
        ValidationService validationService = new ValidationServiceImpl();
        PersonalAccountDao dao = new PersonalAccountDaoImpl();
        AccountServiceImpl service = new AccountServiceImpl(generator,validationService,dao);
        TellerIO io = new TellerIOConsoleImpl();
        TellersView view = new TellersView(io);
        AccountController controller = new AccountController(service, view);
        controller.run();




    }
}
