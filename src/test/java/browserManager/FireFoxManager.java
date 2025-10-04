package browserManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager implements BrowserManager{

    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
