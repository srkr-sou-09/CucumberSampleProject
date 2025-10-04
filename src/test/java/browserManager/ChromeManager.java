package browserManager;

import enums.GlobalPropertiesEnums;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.properties.GlobalSettingsManager;

public class ChromeManager implements BrowserManager{
    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        GlobalSettingsManager globalSettingsManager = new GlobalSettingsManager();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (globalSettingsManager.getGlobalSettingsPropertiesValue(GlobalPropertiesEnums.HEADLESS_BROWSER).equalsIgnoreCase("y"))
            chromeOptions.addArguments("--headless");

        return new ChromeDriver(chromeOptions);
        }

    }
