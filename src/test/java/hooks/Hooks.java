package hooks;


import com.aventstack.extentreports.service.ExtentService;
import driverManager.CreateDriver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public WebDriver driver;

    @Before()
    public void setUp(Scenario scenario){
        CreateDriver.getInstance().setDriver(CreateDriver.getBrowserName());
        driver = CreateDriver.getInstance().getDriver();
        System.out.println("Before each scenario");
        System.out.println(scenario.getId()+ "--> Execution started----------------------------------");
        ExtentService.getInstance().setSystemInfo("os",System.getProperty("os.name")+"::"+System.getProperty("os.version")+"::"+CreateDriver.getBrowserName());
    }

    @After()
    public void tearDown(Scenario scenario){
        System.out.println("After each scenario");
        driver.quit();
        CreateDriver.getInstance().flushDriver();
        System.out.println(scenario.getId()+ "--> Execution ended----------------------------------");
    }

    @BeforeStep()
    public void commonStepBeforeEachStep(){


    }

    @AfterStep()
    public void commonStepAfterEachStep(Scenario scenario){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png", screenshot.toString()+CreateDriver.getBrowserName());
       // Allure.addAttachment("step Screenshot",new ByteArrayInputStream(screenshot));


    }
}
