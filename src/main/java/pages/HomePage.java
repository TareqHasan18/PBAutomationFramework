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



    //Initializing the Page Objects
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public RegistrationPage registerLink() throws InterruptedException {
        register.click();
        Thread.sleep(4000);
        return new RegistrationPage();

    }





}
