package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.PicoContainer;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs","hooks"},
        plugin = {"pretty","html:target/cucumber-reports/index.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:target/cucumber-reports/timelineReport.html"
                },
        //tags = "@validCredentials",
        monochrome = true,
        dryRun = false
)
public class CucumberTestRunner {

    public PicoContainer getContainer(){

        return new DefaultPicoContainer();
    }

}
