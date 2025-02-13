package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationPageTest extends RegistrationPage {

    RegistrationPage registrationPage;
    HomePage homePage;

//    public RegistrationPageTest(){
//        super();
//    }

    @BeforeMethod
    public void initialize() throws InterruptedException {
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        homePage = new HomePage();
        homePage.registerLink();
    }

    @Test
    public void registrationProcessTest(){
        registrationPage.registrationProcess();
    }
}
