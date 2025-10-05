package browserManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager implements BrowserManager{

    @Override
    public WebDriver getDriver() {
        try{
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }catch(Exception ex){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
                    +"/src/test/resources/drivers/geckodriver");
            return new FirefoxDriver();
        }


    }
}
