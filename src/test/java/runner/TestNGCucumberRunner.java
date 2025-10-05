package runner;


import driverManager.CreateDriver;
import enums.BrowsersNames;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs","hooks"},
        plugin = {"pretty","html:target/cucumber-reports/index.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:target/cucumber-reports/timelineReport.html",
                "rerun:target/failed.xml",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        //tags = "@validCredentials",
        monochrome = true,
        dryRun = false
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

        @DataProvider(parallel = true)
        @Override
        public synchronized Object[][] scenarios(){
                return super.scenarios();
        }


       /* @Test(
                groups = {"cucumber"},
                description = "Runs Cucumber Scenarios",
                dataProvider = "scenarios",
                retryAnalyzer = Retry.class
        )
        @Override
        public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
                super.runScenario(pickleWrapper,featureWrapper);
        }*/


        @BeforeSuite
        public synchronized void beforeSuite(){
                System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        }

        @AfterSuite
        public synchronized void afterSuite(){
                System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        }

        @BeforeClass
        public synchronized void beforeClass(ITestContext context){
                System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
                //context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(3);
        }

        @AfterClass
        public synchronized void afterClass(){
                System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        }

        @BeforeTest
        @Parameters({"browser"})
        public synchronized void beforeTest(String browser){
                if(browser.equalsIgnoreCase(BrowsersNames.CHROME.toString())){
                        CreateDriver.setBrowserName(BrowsersNames.CHROME);
                }else if(browser.equalsIgnoreCase(BrowsersNames.FIREFOX.name())){
                        CreateDriver.setBrowserName(BrowsersNames.FIREFOX);
                }
                else if(browser.equalsIgnoreCase(BrowsersNames.EDGE.name())){
                        CreateDriver.setBrowserName(BrowsersNames.EDGE);
                }
                System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        }

        @AfterTest
        public synchronized void afterTest(){
                System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        }

        @BeforeMethod
        public synchronized void beforeMethod(){
                System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        }

        @AfterMethod
        public synchronized void afterMethod(){
                System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
                System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        }

}
