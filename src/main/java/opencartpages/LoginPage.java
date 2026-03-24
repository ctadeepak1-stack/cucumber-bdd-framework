package opencartpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("ALL")
public class LoginPage {
    private WebDriver driver;

    // 1. By Locators
    private By emailInputLocator = By.id("input-email");
    private By passwordInputLocator = By.id("input-password");
    private By loginButtonLocator = By.xpath("(//input[@value='Login'])[1]");
    private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
    private By logoutLinkLocator = By.linkText("Logout");

    // 2. Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Page Actions
    public void enterEmail(String email) {
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    public void clickForgottenPasswordLink() {
        driver.findElement(forgottenPasswordLinkLocator).click();
    }

    public boolean checkLogoutLink() {
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }
}