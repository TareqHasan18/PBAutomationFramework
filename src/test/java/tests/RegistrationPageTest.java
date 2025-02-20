package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import utility.TestUtil;

import java.io.IOException;

public class RegistrationPageTest extends RegistrationPage {

    RegistrationPage registrationPage;
    HomePage homePage;

//    public RegistrationPageTest(){
//        super();
//    }

    @BeforeMethod
    public void initialize() {
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        homePage = new HomePage();
        homePage.registerLink();
    }

    @DataProvider(name = "registrationdata")
    public static Object[][] getRegistrationTestData() throws IOException {
        Object[][] logInData = TestUtil.getTestData("register");
        return logInData;
    }

    @Test(dataProvider = "registrationdata")
    public void registrationProcessTest(String myFirstName, String myLastName, String myUserName, String myPassword, String myConfirmPassword){
        registrationPage.registrationProcess(myFirstName, myLastName, myUserName, myPassword, myConfirmPassword);
    }
}
