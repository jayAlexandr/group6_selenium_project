package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStep_Definitions {

    private static final Logger log = LoggerFactory.getLogger(LoginStep_Definitions.class);
    LoginPage loginPage = new LoginPage();

    @Given("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        loginPage.login();
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        BrowserUtils.verifyTitleContains("Dashboard");
    }

    // US-1
    @When("user is on the login page")
    public void user_is_on_the_login_page() {
    }

    @When("user enters valid username")
    public void user_enters_valid_username() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
    }

    @When("user enters valid password")
    public void user_enters_valid_password() {
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @Then("user clicks on log in button")
    public void user_clicks_on_log_in_button() {
        loginPage.loginButton.click();
    }

    @Then("user can log in by clicking Enter button")
    public void user_can_log_in_by_clicking_enter_button() {
        loginPage.passwordInput.sendKeys(Keys.ENTER);
    }


    String username;
    String password;
    @When("user enters the username {string} and password {string}")
    public void userEntersTheUsernameAndPassword(String user, String pass) {
        username = user;
        password = pass;
        loginPage.usernameInput.sendKeys(user);
        loginPage.passwordInput.sendKeys(pass);
        loginPage.loginButton.click();

    }

    @Then("the user should not be able to log in")
    public void theUserShouldNotBeAbleToLogIn() {
        BrowserUtils.verifyTitleContains("Trycloud");
        System.out.println("Works");
    }


    @Then("user should blankCredentialMessage or invalidCredentialMessage")
    public void userShouldBlankCredentialMessageOrInvalidCredentialMessage() {

        if (username.isEmpty() || password.isEmpty()){

        }else{

        }
    }

    @Then("user can see the password in the input in a form of dots")
    public void userCanSeeThePasswordInTheInputInAFormOfDots() {
        String fieldType = loginPage.passwordInput.getDomAttribute("type");

        if (fieldType.equals("password")){
            System.out.println("Test Passed: Password Masked");
        }else {
            System.out.println("Test Failed: Password is not masked");
        }

    }

    @And("user clicks on toggle password icon")
    public void userClicksOnTogglePasswordIcon() {
        loginPage.togglePassword.click();
    }

    @Then("user can see entered password clearly")
    public void userCanSeeEnteredPasswordClearly() {
        String expectedText = "text";

        Assert.assertEquals(expectedText, loginPage.passwordInput.getDomAttribute("type"));
    }

    @And("user click on the forgot password button")
    public void userClickOnTheForgotPasswordButton() {
        loginPage.forgotPasswordButton.isDisplayed();
        loginPage.forgotPasswordButton.click();
    }

    @Then("user can see in the next page reset password button")
    public void userCanSeeInTheNextPageResetPasswordButton() {
        loginPage.resetPasswordButton.isDisplayed();
    }
}
