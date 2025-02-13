package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class HomePageTest extends HomePage {

    HomePage homePage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void initialize(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

//    public HomePageTest(){
//        super();
//    }

    @Test
    public void registerLinkTest() throws InterruptedException {
        registrationPage = homePage. registerLink();
    }


}
