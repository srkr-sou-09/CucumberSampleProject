package pages;

import org.openqa.selenium.By;

public class LoginPage {
    public static final By input_userName = By.id("user-name");
    public static final By input_password = By.id("password");
    public static final By button_login = By.id("login-button");
    public static final By text_dashboard = By.xpath("//span[text()='Products']");

}
