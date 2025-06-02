package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EnterEditData_StepDefinitions {

    @When("user is logged in the app and on the settings page")
    public void user_is_logged_in_the_app_and_on_the_settings_page() {
        //Using login page to create an object
        LoginPage loginPage = new LoginPage();
        //using the object's ready method to log in
        loginPage.login();


        //After login is finished creating base page object
        BasePage basePage = new BasePage();
        //waiting for elements to load before clicking on them
        BrowserUtils.waitForVisibility(basePage.userIcon, 10);
        basePage.userIcon.click();
        basePage.userSettings.click();
    }
    //TODO this step
    @Then("user sees Full name, Email, Phone Number displayed")
    public void user_sees_full_name_email_phone_number_displayed() {


    }
}
