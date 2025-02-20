package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ForgotLoginInfo;
import pages.HomePage;
import pages.RegistrationPage;
import utility.TestUtil;

import java.io.IOException;

public class HomePageTest extends HomePage {

    HomePage homePage;
    RegistrationPage registrationPage;
    ForgotLoginInfo forgotLoginInfo;

    @BeforeMethod
    public void initialize(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @DataProvider(name = "logindata")
    public static Object[][] getLogInTestData() throws IOException {
        Object[][] logInData = TestUtil.getTestData("login");
        return logInData;
    }

    @Test(dataProvider = "logindata")
    public void logInActionTest(String myUsername, String myPassword) throws InterruptedException {
        homePage.logAction(myUsername, myPassword);
    }

    @Test
    public void registerLinkTest() {
        registrationPage = homePage. registerLink();
    }

    @Test
    public void forgotLoginInformationTest() {
        forgotLoginInfo = homePage.forgotLoginInformation();
    }


}
