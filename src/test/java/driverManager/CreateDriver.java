package driverManager;

import enums.BrowsersNames;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class CreateDriver {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static CreateDriver Driver_Instance = null;

    private static BrowsersNames browserName;

    public static BrowsersNames getBrowserName() {
        return browserName;
    }

    public static void setBrowserName(BrowsersNames browserName) {
        CreateDriver.browserName = browserName;
    }

    private CreateDriver(){}

    public static synchronized CreateDriver getInstance(){
        if(Objects.isNull(Driver_Instance))
            Driver_Instance = new CreateDriver();

        return Driver_Instance;
    }

    public void setDriver(BrowsersNames browserName){
       /* switch (browserName.name().toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browserName");
        }*/
       //driver = DriverManager.getBrowserManager(browserName).getDriver();
        driver.set(DriverManager.getBrowserManager(browserName).getDriver());
    }


    public WebDriver getDriver(){return driver.get();}

    public void flushDriver(){driver.remove();}

}
