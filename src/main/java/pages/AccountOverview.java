package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AccountOverview
{
    @FindBy(css = "#accountTable a") private List<WebElement> accountNumbers;

    public AccountOverview validateAccountNumber(String accountNumber){
        boolean isPresent = false;
        for (WebElement element:accountNumbers){
            if (element.getText().equals(accountNumber)){
                isPresent= true;
                break;
            }
        }
        Assert.assertTrue(isPresent);
        return this;
    }
}
