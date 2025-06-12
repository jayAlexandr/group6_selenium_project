package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.CalendarPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarViewAddDelete_StepDefinitions {

    //Background for all test cases
    @When("the user is logged into the app and on the Calendar page")
    public void the_user_is_logged_into_the_app_and_on_the_calendar_page() {
        //Using login page to create an object
        LoginPage loginPage = new LoginPage();
        //using the object's ready method to log in
        loginPage.login();
        //After login is finished creating base page object
        BasePage basePage = new BasePage();
        basePage.calendar.click();
    }

    //initializing an object from the calendar page to get access to the web elements
    CalendarPage calendarPage = new CalendarPage();

    //TC1-TC2-TC3
    @When("the user clicks the View Selection menu button")
    public void the_user_clicks_the_view_selection_menu_button() {
        //clicking on the menu option to do the selection
        calendarPage.selectionView.click();
    }

    //TC1
    @When("the user selects Day")
    public void the_user_selects_Day() {
        //selecting day view
        calendarPage.daySelection.click();
    }

    @Then("the user should see the Daily Calendar view displayed")
    public void the_user_should_see_the_daily_calendar_view_displayed() {
        //making sure the url changes to desired
        BrowserUtils.verifyURLContains("timeGridDay");
    }

    //TC2
    @And("the user selects Week")
    public void theUserSelectsWeek() {
        //selecting week View
        calendarPage.weekSelection.click();
    }

    @Then("the user should see the Weekly Calendar view displayed")
    public void the_user_should_see_the_weekly_calendar_view_displayed() {
        //making sure the url changes to desired
        BrowserUtils.verifyURLContains("timeGridWeek");
    }

    //TC3
    @And("the user selects Month")
    public void theUserSelectsMonth() {
        //selecting Month view
        calendarPage.monthSelection.click();
    }

    @Then("the user should see the Monthly Calendar view displayed")
    public void the_user_should_see_the_monthly_calendar_view_displayed() {
        //making sure the url changes to desired
        BrowserUtils.verifyURLContains("dayGridMonth");
    }

    //TC4
    @When("the user selects the Monthly Calendar view")
    public void the_user_selects_the_monthly_calendar_view() {
        //clicking on the menu option to do the selection
        calendarPage.selectionView.click();
        //selecting Month view
        calendarPage.monthSelection.click();
    }

    @When("the user selects the Personal event view")
    public void the_user_selects_the_personal_event_view() {
        //waiting until the element is visible
        BrowserUtils.waitForVisibility(calendarPage.personalEvents, 10);
        //here I want to make sure that the personal calendar is selected, this way
        //user sees all the elements that are to be created during the next steps
        if (calendarPage.personalEvents.getDomAttribute("class").contains("disabled")) {
            //getting the attribute value and if it's disable clicking on it
            calendarPage.personalEvents.click();
        }

    }

    @When("the user clicks on New Event button")
    public void the_user_clicks_on_New_Event_button() {
        //simply clicking on the new event button
        calendarPage.newEventButton.click();
    }


    @And("the user checks the All Day checkbox")
    public void theUserChecksTheAllDayCheckbox() {
        //checking all day, so I can simplify the event creation process
        calendarPage.allDayCheckBox.click();
    }

    @And("the user clicks on {string} in the calendar")
    public void theUserClicksOnInTheCalendar(String date) {
        //waiting until the element is visible
        BrowserUtils.waitForClickablility(calendarPage.selectDate, 10);
        calendarPage.selectDate.click();
        // here I have to use webelement instead of @findby since the webelement is dynamic
        String xpath = "//td[@title='" + date + "']";
        WebElement dateCell = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        dateCell.click();
    }

    @And("the user enters {string} as the event title")
    public void theUserEntersAsTheEventTitle(String event) {
        //naming our event
        calendarPage.eventTitle.sendKeys(event);
    }


    @When("the user clicks Save")
    public void the_user_clicks_save() {
        //saving the event
        calendarPage.saveButton.click();
    }

    @Then("the user should see the created {string} displayed on the selected day in the Monthly Calendar view")
    public void theUserShouldSeeTheCreatedDisplayedOnTheSelectedDayInTheMonthlyCalendarView(String eventTitle) {
        //the logic behind the code below is: creating the WebDriverWait for implicit waits
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        //creating a string for dynamic webelement
        String xpath = "//div[contains(@class, 'fc-event-title') and normalize-space(text())='" + eventTitle + "']";
        //passing that string to the webelement so each test we are looking for a specific event
        WebElement event = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        //making sure it's displayed
        Assert.assertTrue("Event '" + eventTitle + "' is not displayed", event.isDisplayed());

    }
//TODO last step


    @When("the user selects the created {string}")
    public void the_user_selects_the_created(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks the More button")
    public void the_user_clicks_the_more_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks the Actions button on the More page")
    public void the_user_clicks_the_actions_button_on_the_more_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should see {string} removed from the calendar")
    public void the_user_should_see_removed_from_the_calendar(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
