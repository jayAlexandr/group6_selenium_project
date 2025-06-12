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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarViewAddDelete_StepDefinitions {

    //Background for all test cases
    @When("the user is logged into the app and on the Calendar page")
    public void the_user_is_logged_into_the_app_and_on_the_calendar_page() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        BasePage basePage = new BasePage();
        basePage.calendar.click();
    }

    CalendarPage calendarPage = new CalendarPage();

    //TC1-TC2-TC3
    @When("the user clicks the View Selection menu button")
    public void the_user_clicks_the_view_selection_menu_button() {
        calendarPage.openViewSelectionMenu();
    }

    @When("the user selects {string}")
    public void the_user_selects(String calendarView) {
        calendarPage.selectCalendarView(calendarView);
    }
    @Then("the user should see the {string} Calendar view displayed")
    public void theUserShouldSeeTheCalendarViewDisplayed(String view) {
        Assert.assertTrue("❌ Calendar view not as expected.",
                calendarPage.isCalendarViewDisplayed(view));
    }


    //TC4
    @When("the user selects the Monthly Calendar view")
    public void the_user_selects_the_monthly_calendar_view() {
        calendarPage.openViewSelectionMenu();
        //selecting Month view
        calendarPage.selectMonthView();
    }

    @When("the user selects the Personal event view")
    public void the_user_selects_the_personal_event_view() {
        BrowserUtils.waitForVisibility(calendarPage.personalEvents,10);
        if (calendarPage.personalEvents.getDomAttribute("class").contains("disabled")) {
            calendarPage.selectPersonalEventsView();
        }

    }

    @When("the user clicks on New Event button")
    public void the_user_clicks_on_New_Event_button() {
        calendarPage.newEventButton.click();
    }


    @When("the user checks the All Day checkbox")
    public void theUserChecksTheAllDayCheckbox() {
        //checking all day, so I can simplify the event creation process
        calendarPage.allDayCheckBox.click();
    }

    @When("the user clicks on {string} in the calendar")
    public void theUserClicksOnInTheCalendar(String date) {
        //waiting until the element is visible
        BrowserUtils.waitForClickablility(calendarPage.selectDate, 10);
        calendarPage.selectDate.click();
        calendarPage.clickDateCell(date);
    }

    @When("the user enters {string} as the event title")
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



    @When("the user selects the created {string}")
    public void the_user_selects_the_created(String eventTitle) {
        //the logic behind the code below is: creating the WebDriverWait for implicit waits
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        //creating a string for dynamic webelement
        String xpath = "//div[contains(@class, 'fc-event-title') and normalize-space(text())='" + eventTitle + "']";
        //passing that string to the webelement so each test we are looking for a specific event
        WebElement event = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        event.click();
    }

    @When("the user clicks the More button")
    public void the_user_clicks_the_more_button() {
        BrowserUtils.waitForClickablility(calendarPage.moreButton, 10);
        calendarPage.moreButton.click();
    }

    @When("the user clicks the Actions button on the More page")
    public void the_user_clicks_the_actions_button_on_the_more_page() {
        BrowserUtils.waitForClickablility(calendarPage.actionsButton, 10);
        calendarPage.actionsButton.click();
    }

    @And("the user clicks on Delete button")
    public void theUserClicksOnDeleteButton() {
        BrowserUtils.waitForClickablility(calendarPage.deleteButton, 10);
        calendarPage.deleteButton.click();
    }

    @Then("the user should see {string} removed from the calendar")
    public void the_user_should_see_removed_from_the_calendar(String eventTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        String xpath = "//div[contains(@class, 'fc-event-title') and normalize-space(text())='" + eventTitle + "']";

        try {
            // try to find the event first
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            // if found, now wait for it to disappear
            boolean isEventDeleted = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            Assert.assertTrue("❌ The event '" + eventTitle + "' was not removed from the calendar.", isEventDeleted);

        } catch (TimeoutException e) {
            // optional: the event is never existed if and only if the event in feature file is invalid
            throw new AssertionError("❌ The event '" + eventTitle + "' never existed on the calendar.");
        }

    }


}
