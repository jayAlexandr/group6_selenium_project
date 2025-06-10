package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalendarViewAddDelete_StepDefinitions {
    //TODO all these steps
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
    @When("the user clicks the View Selection menu button")
    public void the_user_clicks_the_view_selection_menu_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user selects {string}")
    public void the_user_selects(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see the Daily Calendar view displayed")
    public void the_user_should_see_the_daily_calendar_view_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should see the Weekly Calendar view displayed")
    public void the_user_should_see_the_weekly_calendar_view_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see the Monthly Calendar view displayed")
    public void the_user_should_see_the_monthly_calendar_view_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user selects the Monthly Calendar view")
    public void the_user_selects_the_monthly_calendar_view() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user selects the Personal event view")
    public void the_user_selects_the_personal_event_view() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks on {string} in the calendar")
    public void the_user_clicks_on_in_the_calendar(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters {string} as the event title")
    public void the_user_enters_as_the_event_title(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user checks the {string} checkbox")
    public void the_user_checks_the_checkbox(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks Save")
    public void the_user_clicks_save() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should see the created event displayed on the selected day in the Monthly Calendar view")
    public void the_user_should_see_the_created_event_displayed_on_the_selected_day_in_the_monthly_calendar_view() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

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
