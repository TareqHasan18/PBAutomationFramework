package pages;

import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends CommonClass {

    @FindBy(id = "customer.firstName")
    WebElement firstName;


    public void registrationProcess(){
        firstName.sendKeys("Sarah");
    }


}
