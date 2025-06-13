package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.openqa.selenium.JavascriptExecutor;

public class Log_Out_StepDefinitions {

    BasePage basePage = new BasePage();

    @When("user clicks on profile name button")
    public void user_clicks_on_profile_name_button() {

        basePage.userIcon.click();

    }

    @When("user clicks on log out button")
    public void user_clicks_on_log_out_button() {

        basePage.logOutButton.click();

    }

    @Then("user should land on log in page")
    public void user_should_land_on_log_in_page() {

        BrowserUtils.verifyTitle("Trycloud QA");

    }

    @When("user clicks on step back button")
    public void user_clicks_on_step_back_button() {

        Driver.getDriver().navigate().back();

    }

    @Then("user should not land on Home  page anymore")
    public void user_should_not_land_on_page_anymore() {

        BrowserUtils.verifyTitle("Trycloud QA");

    }

    @When("user does not do any mouse or keyboard action for 3 minutes")
    public void user_does_not_do_any_mouse_or_keyboard_action_for_minutes() {

        BrowserUtils.sleep(182);

        // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // js.executeScript("window.lastActivityTime = Date.now() - 180000;"); // simulate 3 mins ago

    }

}
