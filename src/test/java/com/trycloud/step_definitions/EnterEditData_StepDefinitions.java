package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.SettingsPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        //clearing existing data
        settingsPage.fullNameInput.clear();
        //sending data from the feature file
        settingsPage.fullNameInput.sendKeys(name, Keys.ENTER);
    }

    @Then("user sees a new name {string} is saved in the Full name field")
    public void user_sees_a_new_name_is_saved_in_the_full_name_field(String expectedName) {
        //checking if the name is saved
        Assert.assertTrue(settingsPage.fullNameInput.getDomAttribute("value").contains(expectedName));
    }

    //TC3
    @When("user clicks on the options icon next to Phone number label")
    public void user_clicks_on_the_options_icon_next_to_phone_number_label() {
        //clicking on the icon
        settingsPage.phoneSettingsIcon.click();
    }

    @When("user selects private option")
    public void user_selects_private_option() {
        //making selection
        settingsPage.privatePhoneSelection.click();
    }

    @Then("user sees phone number settings changed to private")
    public void user_sees_phone_number_settings_changed_to_private() {
        //waiting until the web element has changed the class
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-federation-menu")));
        wait.until(driver1 -> icon.getDomAttribute("class").contains("icon-contacts-dark")); // expecting to see specific icon here
        //getting class from the webelement
        String actualClass = icon.getDomAttribute("class");
        //confirming user sees accurate icon displayed
        Assert.assertTrue("Expected icon class not found!", actualClass.contains("icon-contacts-dark"));

    }
    //TC4

    @When("user enters {string} to the phone number field and press Enter")
    public void user_enters_to_the_phone_number_field_and_press_enter(String phone) {
        //waiting until web element is visible
        BrowserUtils.waitForClickablility(settingsPage.phoneInput, 10);
        //clearing the field
        settingsPage.phoneInput.clear();
        //sending the data from the feature file
        settingsPage.phoneInput.sendKeys(phone, Keys.ENTER);
        BrowserUtils.sleep(2);
        //checking if the phone is saved and printing the current value
        System.out.println("Current saved phone number = " + settingsPage.phoneInput.getDomAttribute("value"));

    }

    @Then("user sees his phone number is NOT saved")
    public void user_sees_his_phone_number_is_not_saved() {
        // creating a condition where if the field contains anything besides numbers this statement will send an error message
        if (!settingsPage.phoneInput.getDomAttribute("value").matches("\\d+")) {
            String value = settingsPage.phoneInput.getDomAttribute("value");
            System.err.println("WARNING: Phone input contains non-digit characters: " + value);
        } else {
            System.out.println("Current phone: " + settingsPage.phoneInput.getDomAttribute("value"));//otherwise it will send the current number
        }

    }


    @Then("user sees correct webelement is displayed")
    public void userSeesCorrectWebelementIsDisplayed() {
        //Waiting until elements are visible
        BrowserUtils.waitForVisibility(settingsPage.localDateTime, 10);
        BrowserUtils.waitForVisibility(settingsPage.localDate, 10);
        BrowserUtils.waitForVisibility(settingsPage.localTime, 10);
        //Getting current date time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String formattedNow = now.format(formatter);
        System.out.println("Current date and time: " + formattedNow);
        //Getting date/time from the page
        String dateTimeText = settingsPage.localDateTime.getText().trim();
        System.out.println("Date/Time from page: " + dateTimeText);
        //Making sure the element is visible to the user
        Assert.assertTrue(settingsPage.localDateTime.isDisplayed());
    }
}

