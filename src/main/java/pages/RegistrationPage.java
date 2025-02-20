package pages;

import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends CommonClass {

    @FindBy(id = "customer.firstName")
    WebElement firstName;

    @FindBy(id = "customer.lastName")
    WebElement lastName;

    @FindBy(id = "customer.address.street")
    WebElement address;

    @FindBy(id = "customer.address.city")
    WebElement city;

    @FindBy(id = "customer.address.state")
    WebElement state;

    @FindBy(id = "customer.address.zipCode")
    WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    WebElement ssn;

    @FindBy(id = "customer.username")
    WebElement username;

    @FindBy(id = "customer.password")
    WebElement password;

    @FindBy(id = "repeatedPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement register;

    public void registrationProcess(String myFirstName, String myLastName, String myUserName, String myPassword, String myConfirmPassword){
        firstName.sendKeys(myFirstName);
        lastName.sendKeys(myLastName);
        address.sendKeys("8887 45th street");
        city.sendKeys("Queens");
        state.sendKeys("NY");
        zipCode.sendKeys("11411");
        phoneNumber.sendKeys("3473473470");
        ssn.sendKeys("123456789");
        username.sendKeys(myUserName);
        password.sendKeys(myPassword);
        confirmPassword.sendKeys(myConfirmPassword);
        register.click();
    }


}
