package opencartpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import java.time.Duration;

@SuppressWarnings("ALL")
public class LoginPage{
private  WebDriver driver;

// By Locators
private By emailInputLocator = By.id("input-email");
private By passwordInputLocator = By.id("input-password");
private By loginButtonLocator = By.xpath("(//input[@value='Login'])[1]");
private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
private By logoutLinkLocator = By.linkText("Logout");

// Constructor
public LoginPage(WebDriver driver)
{

    this.driver = driver;
}

// Page Methods/Actions
public void enterEmail(String email) {
    WebElement emailInput = driver.findElement(emailInputLocator);
    emailInput.sendKeys(email);
}

public void enterPassword(String password) {
    WebElement passwordInput = driver.findElement(passwordInputLocator);
    passwordInput.sendKeys(password);
}

public void clickLoginButton() {
    WebElement loginButton = driver.findElement(loginButtonLocator);
    loginButton.click();
}

public void clickForgottenPasswordLink() {
    WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
    forgottenPasswordLink.click();
}

public boolean checkForgotPwdLink() {

    return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
}

public boolean checkLogoutLink() {
   /* try {
        // Wait up to 10 seconds for the Logout link to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        return logoutLink.isDisplayed();
    } catch (Exception e) {
        System.out.println("Logout link not found within timeout: " + e.getMessage());
        return false;*/
    return driver.findElement(logoutLinkLocator).isDisplayed();
    }

    // return driver.findElement(logoutLinkLocator).isDisplayed();


public void login(String email, String password) {
    enterEmail(email);
    enterPassword(password);
    clickLoginButton();
}

public String getForgotPwdPageUrl() {
    String forgotPwdPageUrl = driver.getCurrentUrl();
    return forgotPwdPageUrl;
}
    }



