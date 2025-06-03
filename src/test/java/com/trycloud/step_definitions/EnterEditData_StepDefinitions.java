package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.SettingsPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class EnterEditData_StepDefinitions {
    // creating an object for setting page globally so I can use it later in different steps
    SettingsPage settingsPage = new SettingsPage();
    //TC1
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

    @Then("user sees Full name, Email, Phone Number displayed")
    public void user_sees_full_name_email_phone_number_displayed() {
        //using assert checking if web needed web elements are displayed.
        Assert.assertTrue(settingsPage.fullNameLabel.isDisplayed());
        Assert.assertTrue(settingsPage.emailLabel.isDisplayed());
        Assert.assertTrue(settingsPage.phoneNumberLabel.isDisplayed());
    }
    //TC2

    @When("user enters a new name {string} into the Full name field and presses Enter")
    public void user_enters_a_new_name_into_the_full_name_field_and_presses_enter(String name) {
        settingsPage.fullNameInput.clear();
        settingsPage.fullNameInput.sendKeys(name, Keys.ENTER);
    }
    @Then("user sees a new name {string} is saved in the Full name field")
    public void user_sees_a_new_name_is_saved_in_the_full_name_field(String expectedName) {
        Assert.assertTrue(settingsPage.fullNameInput.getDomAttribute("value").contains(expectedName));
    }
    //TC3
 //TODO this TC3
    @When("user clicks on the options icon next to Phone number label")
    public void user_clicks_on_the_options_icon_next_to_phone_number_label() {
        settingsPage.phoneSettingsIcon.click();


    }
    @When("user selects private option")
    public void user_selects_private_option() {
        settingsPage.privatePhoneSelection.click();
    }
    @Then("user sees phone number settings changed to private")
    public void user_sees_phone_number_settings_changed_to_private() {
        System.out.println("settingsPage.privatePhoneSelection.getDomAttribute(\"class\") = " + settingsPage.privatePhoneSelection.getDomAttribute("class"));

    }


}

