package pages;

import helper.GlobalVariable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountPage {
    @FindBy(css = "input[value='Open New Account']") private WebElement newAccountButton;
    @FindBy(id = "newAccountId") private WebElement accountNumber;

    public NewAccountPage clickNewAccoutButton(){
        newAccountButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GlobalVariable.accountNumber = accountNumber.getText();

        return this;
    }
}
