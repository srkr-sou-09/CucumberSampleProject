package browserManager;

import enums.GlobalPropertiesEnums;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utilities.properties.GlobalSettingsManager;

public class EdgeManager implements BrowserManager {
    @Override
    public WebDriver getDriver() {
        try {
            WebDriverManager.edgedriver().setup();
            GlobalSettingsManager globalSettingsManager = new GlobalSettingsManager();
            EdgeOptions edgeOptions  = new EdgeOptions ();
            if (globalSettingsManager.getGlobalSettingsPropertiesValue(GlobalPropertiesEnums.HEADLESS_BROWSER).equalsIgnoreCase("y"))
                edgeOptions.addArguments("--headless");
            return new EdgeDriver(edgeOptions);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return new EdgeDriver();
    }
}