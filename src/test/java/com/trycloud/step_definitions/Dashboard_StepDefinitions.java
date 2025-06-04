package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

import static com.trycloud.utilities.BrowserUtils.waitForVisibility;

public class Dashboard_StepDefinitions {

    DashboardPage dashboardPage = new DashboardPage();

    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String> expectedModuleNames) {
        List<String> actualModuleNames = dashboardPage.moduleNames(dashboardPage.modulesName);
        System.out.println("Expected modules: " + expectedModuleNames);
        System.out.println("Actual modules: " + actualModuleNames);
        Assert.assertEquals("Module names do not match", expectedModuleNames, actualModuleNames);
    }

    @And("user click on the user profile menu")
    public void user_click_on_the_user_profile_menu() {
        dashboardPage.profileMenu.click();
    }

    @Then("user should see their username")
    public void user_should_see_their_username() {
        Assert.assertTrue("Username is not displayed", dashboardPage.userName.isDisplayed());
    }

    @And("user click on Customize button")
    public void user_click_on_customize_button() {
        dashboardPage.customizeButton.click();
        waitForVisibility(dashboardPage.customizeButton, 2);
    }

    @And("user should see widgets")
    public void user_should_see_widgets() {
        dashboardPage.verifyWidgetsAreDisplayed();

    }

    @Then("user can select any widgets")
    public void user_can_select_any_widgets() {
        dashboardPage.selectAllWidgets();
    }

    @And("user should see background images")
    public void user_should_see_background_images() {
        dashboardPage.verifyBackgroundsAreDisplay();
    }

    @Then("user can select any background image")
    public void user_can_select_any_background_image() {
        dashboardPage.verifyBackgroundSelected();
        dashboardPage.verifyChooseBGFromFile();
    }
}
