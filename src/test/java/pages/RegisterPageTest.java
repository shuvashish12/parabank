package pages;

import browser.Browser;
import helper.GlobalVariable;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RegisterPageTest {

    @Test
    public void paraBankTest1(){
        Browser browser = new Browser();
        browser
                .startBrowser()
                .clickRegisterLink()
                .fillOutRegisterInfo()
                .clickLink("Open New Account");
        PageFactory.initElements(Browser.getDriver(), NewAccountPage.class)
                .clickNewAccoutButton();
        PageFactory.initElements(Browser.getDriver(), DashboardPage.class)
                .clickLink("Log Out");
        PageFactory.initElements(Browser.getDriver(), HomePage.class)
                .logIn();
        PageFactory.initElements(Browser.getDriver(), AccountOverview.class)
                .validateAccountNumber(GlobalVariable.accountNumber);
    }
}
