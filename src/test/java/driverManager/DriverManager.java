package driverManager;

import browserManager.BrowserManager;
import browserManager.ChromeManager;
import browserManager.FireFoxManager;
import enums.BrowsersNames;

public class DriverManager {

    public static BrowserManager getBrowserManager(BrowsersNames browser){
        switch (browser.name().toLowerCase()){
            case "chrome":
                return new ChromeManager();
            case "firefox":
                return new FireFoxManager();
            default:
                throw new IllegalArgumentException("no Matching browser found");
        }
    }
}
