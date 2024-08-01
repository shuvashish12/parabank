package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Browser {
    static WebDriver driver;

    public HomePage startBrowser() {
        String url = getPropertyValue("url");
        String browser = getPropertyValue("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return PageFactory.initElements(driver, HomePage.class);
    }

    public String getPropertyValue(String propertyName){
        String property;
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/info.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            property = properties.getProperty(propertyName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return property;
    }

    public void setPropertyValue(String propertyName, String propertyValue){
        String property;
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/info.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            properties.setProperty(propertyName, propertyValue);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
