package opencartstepdefinitions;

import factory.DriverFactory;
import opencartpages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.By;

@SuppressWarnings("ALL")
public class loginstepdefinition {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterEmail("ctadeepak1@gmail.com");
        loginPage.enterPassword("Ramayan@1990");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the Login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.checkLogoutLink());
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        Assert.assertTrue(DriverFactory.getDriver().findElement(By.cssSelector(".alert-danger")).isDisplayed());
    }
    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        // loginPage is your Page Object variable
        loginPage.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("account/forgotten"));
    }
}