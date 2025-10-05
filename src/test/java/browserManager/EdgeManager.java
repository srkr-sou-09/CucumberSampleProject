package browserManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeManager implements BrowserManager {
    @Override
    public WebDriver getDriver() {
        try{
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }catch (Exception ex){
            if(System.getProperty("os.name").toLowerCase().contains("linux")){
                System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/msedgedriver_linux");
            }else if(System.getProperty("os.name").toLowerCase().contains("windows")){
                System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/src/test/resources/drivers/msedgedriver.exe");
            }

            return new EdgeDriver();
        }
    }
}
