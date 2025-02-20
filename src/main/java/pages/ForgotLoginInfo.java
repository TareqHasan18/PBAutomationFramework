package pages;

import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotLoginInfo extends CommonClass {
    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "address.street")
    WebElement address;

    @FindBy(id = "address.city")
    WebElement city;

    @FindBy(id = "address.state")
    WebElement state;

    @FindBy(id = "address.zipCode")
    WebElement zipCode;

    @FindBy(id = "ssn")
    WebElement ssn;

    @FindBy(xpath = "//input[@value='Find My Login Info']")
    WebElement findMyLoginInfo;

    public void findMyLoginInformation(String myInfoFirstName, String myInfoLastName) {
        firstName.sendKeys(myInfoFirstName);
        lastName.sendKeys(myInfoLastName);
        address.sendKeys("8887 45th street");
        city.sendKeys("NYC");
        state.sendKeys("NY");
        zipCode.sendKeys("11411");
        ssn.sendKeys("123456789");
        findMyLoginInfo.click();
    }
}
