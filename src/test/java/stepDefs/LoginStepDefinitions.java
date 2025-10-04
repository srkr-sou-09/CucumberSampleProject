package stepDefs;

import context.Context;
import driverManager.CreateDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.util.List;
import java.util.Map;


public class LoginStepDefinitions {

    private WebDriver driver;
    private Context context;

    public LoginStepDefinitions(Context context){
        driver = CreateDriver.getInstance().getDriver();
        driver.manage().window().maximize();
        this.context = context;
    }


    @Given("user has launched url {string}")
    public void user_has_launched_url(String url) {
        driver.get(url);
    }

    @When("user entered the credentials")
    public void user_entered_the_credentials(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
        driver.findElement(LoginPage.input_userName)
                .sendKeys(data.get(0).get("userName"));
        driver.findElement(LoginPage.input_password)
                .sendKeys(data.get(0).get("Password"));
    }

    @When("user entered username {string} and password {string}")
    public void user_entered_username_and_password(String userName, String password) {
        driver.findElement(LoginPage.input_userName).sendKeys(userName);
        driver.findElement(LoginPage.input_password).sendKeys(password);
    }

    @When("user has clicked on Login button")
    public void user_has_clicked_on_login_button() {
        driver.findElement(LoginPage.button_login).click();
    }

    @Then("user verify {string} on Dashboard")
    public void user_verify_on_dashboard(String text) {
        Assert.assertTrue(driver.findElement(LoginPage.text_dashboard).isDisplayed());
    }

    @Then("close the browser")
    public void close_the_browser() {
        System.out.println("Step is covered in after hooks");
    }
}
