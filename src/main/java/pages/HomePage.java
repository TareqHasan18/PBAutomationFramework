package pages;

import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonClass {

    //Page Factory - OR
//    @FindBy(xpath = "//div[contains(text(), ' Credit Cards ')]")
//    WebElement creditCards;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement register;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passWord;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement logIn;

    @FindBy(xpath = "//a[contains(text(),'Forgot login info?')]")
    WebElement forgotLoginInfoElement;


    //Initializing the Page Objects
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public RegistrationPage registerLink() {
        register.click();
        return new RegistrationPage();
    }

    public LandingPage logAction(String un, String ps) throws InterruptedException {
        userName.sendKeys(un);
        passWord.sendKeys(ps);
        logIn.click();
        Thread.sleep(2000);
        return new LandingPage();
    }

    public ForgotLoginInfo forgotLoginInformation() {
        forgotLoginInfoElement.click();
        return new ForgotLoginInfo();
    }
}
