package pages;

import browser.Browser;
import helper.GlobalVariable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(linkText = "Register") private WebElement registerLinkElement;
    @FindBy(name = "username") private WebElement userNameField;
    @FindBy(name = "password") private WebElement passwordField;
    @FindBy(css = "[value='Log In']") private WebElement loginButton;

    WebDriver driver = Browser.getDriver();

    public RegisterPage clickRegisterLink(){
        registerLinkElement.click();
        return PageFactory.initElements(driver, RegisterPage.class);
    }

    public void logIn(){
        userNameField.sendKeys(GlobalVariable.userName);
        passwordField.sendKeys(GlobalVariable.password);
        loginButton.click();

    }
}
