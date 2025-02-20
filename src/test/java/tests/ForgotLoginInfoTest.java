package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ForgotLoginInfo;
import pages.HomePage;
import utility.TestUtil;

import java.io.IOException;

public class ForgotLoginInfoTest extends ForgotLoginInfo {

    ForgotLoginInfo forgotLoginInfo;
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        forgotLoginInfo = PageFactory.initElements(driver, ForgotLoginInfo.class);
        homePage = new HomePage();
        homePage.forgotLoginInformation();
    }

    @DataProvider(name = "forgotlogindata")
    public static Object[][] getExistingLoginTestData() throws IOException {
        Object[][] existingLogInData = TestUtil.getTestData("existinguser");
        return existingLogInData;
    }

    @Test(dataProvider = "forgotlogindata")
    public void findMyLoginInformationTest(String infoFirstName, String infoLastName) {
        forgotLoginInfo.findMyLoginInformation(infoFirstName, infoLastName);
        String error = driver.findElement(By.xpath("//p[@class='error']")).getText();
        Assert.assertEquals(error, "The customer information provided could not be found.", "wrong text");
    }
}
