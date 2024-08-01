package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage {

    @FindBy(css = "#leftPanel a") private List<WebElement> leftLinks;

    public DashboardPage clickLink(String linkName){
        for (WebElement webElement : leftLinks){
            if(webElement.getText().equals(linkName)){
                webElement.click();
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
