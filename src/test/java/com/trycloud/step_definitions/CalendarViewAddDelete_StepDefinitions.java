package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.CalendarPage;
import com.trycloud.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


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
        Assert.assertTrue("Calendar view not as expected.",
                calendarPage.isCalendarViewDisplayed(view));
    }

    //TC4
    @Given("the user is on the Monthly Calendar view")
    public void the_user_is_on_the_monthly_calendar_view() {
        calendarPage.openViewSelectionMenu();
        calendarPage.selectMonthView();
    }

    @Given("the user filters to Personal events")
    public void the_user_filters_to_personal_events() {
        calendarPage.selectPersonalEventsView();
    }

    @When("the user creates a new all-day event titled {string} on {string}")
    public void the_user_creates_a_new_all_day_event_titled_on(String eventTitle, String date) {
        calendarPage.clickNewEventButton();
        calendarPage.selectAllDayCheckbox();
        calendarPage.selectDate.click();
        calendarPage.clickDateCell(date);
        calendarPage.eventTitle.sendKeys(eventTitle);
        calendarPage.saveButton.click();
    }

    @Then("the event {string} should be visible in the calendar")
    public void the_event_should_be_visible(String eventTitle) {
        Assert.assertTrue("Expected event '" + eventTitle + "' to be visible in the calendar.",
                calendarPage.isEventVisible(eventTitle));
    }


    //TC5

    @When("the user deletes the event titled {string}")
    public void the_user_deletes_the_event_titled(String eventTitle) {
        calendarPage.deleteEventByTitle(eventTitle);
    }

    @Then("the event {string} should no longer be visible in the calendar")
    public void the_event_should_no_longer_be_visible_in_the_calendar(String eventTitle) {
        calendarPage.verifyEventIsNotVisible(eventTitle);
    }

}
