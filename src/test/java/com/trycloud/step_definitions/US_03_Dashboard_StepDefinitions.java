package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US_03_Dashboard_StepDefinitions {

    DashboardPage dashboardPage = new DashboardPage();

    @Then("user should be able to see following modules")
    public void user_user_should_be_able_to_see_following_modules(List<String> expectedModuleNames) {
        List<String> actualModuleNames = dashboardPage.moduleNames(dashboardPage.modulesName);
        Assert.assertEquals(expectedModuleNames, actualModuleNames);
    }

    @Then("user click on user profile menu")
    public void user_click_on_user_profile_menu() {
        dashboardPage.profileMenu.click();
    }

    @Then("user can see username")
    public void user_can_see_username() {
        Assert.assertTrue(dashboardPage.userName.isDisplayed());
    }

    @Then("user click on Customize button")
    public void user_click_on_customize_button() {
        dashboardPage.customizeButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("user can see status widgets")
    public void user_can_see_status_widgets() {
        dashboardPage.verifyWidgetsIsDisplayed();

    }

    @Then("user can select any of them")
    public void user_can_select_any_of_them() {
        dashboardPage.checkboxesSelected();
    }

    @Then("user can see background images")
    public void user_can_see_background_images() {
        dashboardPage.verifyBackgroundIsDisplay();
    }

    @Then("user can select any background image")
    public void user_can_select_any_background_image() {
        dashboardPage.verifyBackgroundSelected();
    }

}
