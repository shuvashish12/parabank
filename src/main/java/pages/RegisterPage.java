package pages;

import browser.Browser;
import com.github.javafaker.Faker;
import helper.GlobalVariable;
import helper.RegisterPerson;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage {
    @FindBy(id = "customer.firstName") private WebElement firstNameElement;
    @FindBy(id = "customer.lastName") private WebElement lastNameElement;
    @FindBy(id = "customer.address.street") private WebElement streetAddressElement;
    @FindBy(id = "customer.address.city") private WebElement cityAddressElement;
    @FindBy(id = "customer.address.state") private WebElement stateAddressElement;
    @FindBy(id = "customer.address.zipCode") private WebElement zipCodeAddressElement;
    @FindBy(id = "customer.phoneNumber") private WebElement phoneNumberElement;
    @FindBy(id = "customer.ssn") private WebElement ssnElement;
    @FindBy(id = "customer.username") private WebElement userNameElement;
    @FindBy(id = "customer.password") private WebElement passwordElement;
    @FindBy(id = "repeatedPassword") private WebElement confirmPasswordElement;
    @FindBy(css = "[value='Register']") private WebElement registerButtonElement;

    @FindBy(xpath = "//*[@id='rightPanel']/p") private WebElement successMessageElement;



    public DashboardPage fillOutRegisterInfo(){
        RegisterPerson person = new RegisterPerson();
        Browser browser = new Browser();
//        browser.setPropertyValue("userName", person.getUserName());
//        browser.setPropertyValue("password", person.getPassword());

        GlobalVariable.userName = person.getUserName();
        GlobalVariable.password = person.getPassword();

        firstNameElement.sendKeys(person.getFirstName());
        lastNameElement.sendKeys(person.getLastName());
        streetAddressElement.sendKeys(person.getStreetAddress());
        stateAddressElement.sendKeys(person.getState());
        cityAddressElement.sendKeys(person.getCity());
        zipCodeAddressElement.sendKeys(person.getZipCode());
        phoneNumberElement.sendKeys(person.getPhoneNumber());
        ssnElement.sendKeys(person.getSsn());

        userNameElement.sendKeys(person.getUserName());
        passwordElement.sendKeys(person.getPassword());
        confirmPasswordElement.sendKeys(person.getPassword());
        registerButtonElement.click();
        return PageFactory.initElements(Browser.getDriver(), DashboardPage.class);
    }

    public RegisterPage validateRegistrationSuccess(){
        String successMessage = successMessageElement.getText();
        Assert.assertTrue(successMessage.contains("Your account was created successfully"));
        return this;
    }


}
