package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep_Definitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        loginPage.login();
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        BrowserUtils.verifyTitleContains("Dashboard");
    }


}
