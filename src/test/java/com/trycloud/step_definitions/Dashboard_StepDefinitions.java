package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;

import static com.trycloud.utilities.BrowserUtils.*;

public class Dashboard_StepDefinitions {

    DashboardPage dashboardPage = new DashboardPage();

    @Then("user should be able to see following modules")
    public void user_should_be_able_to_see_following_modules(List<String> expectedModuleNames) {
        List<String> actualModuleNames = new ArrayList<>();
        for (WebElement each : dashboardPage.modulesName) {
            String module = each.getAttribute("aria-label");
            actualModuleNames.add(module);
        }
        System.out.println("Actual module names: " + actualModuleNames);
        System.out.println("Expected module names: " + expectedModuleNames);
        Assert.assertEquals("Module names do not match", expectedModuleNames, actualModuleNames);
    }

    @And("user clicks on the user profile menu")
    public void user_clicks_on_the_user_profile_menu() {
        dashboardPage.profileMenu.click();
    }

    @Then("user should see their username")
    public void user_should_see_their_username() {
        System.out.println("Username: " + dashboardPage.userName.getText());
        Assert.assertTrue("Username is not displayed", dashboardPage.userName.isDisplayed());
    }

    @And("user clicks on Customize button")
    public void user_clicks_on_customize_button() {
        dashboardPage.customizeButton.click();
        waitForVisibility(dashboardPage.customizeButton, 2);
    }

    @And("user should see widgets")
    public void user_should_see_widgets() {
        for (WebElement each : dashboardPage.widgetCheckbox) {
            System.out.println("Widget is visible: " + each.getAttribute("id"));
            Assert.assertTrue("Widget checkbox is not enabled: " + each.getAttribute("id"), each.isEnabled());
        }

    }

    @Then("user can select any widgets")
    public void user_can_select_any_widgets() {
        for (WebElement eachCheckbox : dashboardPage.widgetCheckbox) {
            if (eachCheckbox.isSelected()) {
                continue;
            }
            clickWithJS(eachCheckbox);
            System.out.println("Widget is selected: " + eachCheckbox.getAttribute("id"));
            Assert.assertTrue("Widget is not selected: " + eachCheckbox.getAttribute("for"), eachCheckbox.isSelected());
        }
    }

    @And("user should see background images")
    public void user_should_see_background_images() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 200);");
        for (WebElement eachImage : dashboardPage.background) {
            System.out.println("Image is visible: " + eachImage.getAttribute("style"));
            Assert.assertTrue("Background is not enabled: " + eachImage.getAttribute("style"), eachImage.isEnabled());
        }
    }

    @Then("user can select any background image")
    public void user_can_select_any_background_image() {
        for (WebElement eachImage : dashboardPage.background) {
            String text = eachImage.getText();
            if (text.contains("Pick from files")) {
                continue;
            }
            clickWithJS(eachImage);
            String actualBackground = eachImage.getAttribute("class");
            String expectedBackground = "background";
            System.out.println("Actual Background: " + actualBackground);
            System.out.println("Expected Background: " + expectedBackground);
            Assert.assertTrue("Background is not selected: " + text, actualBackground.contains(expectedBackground));
        }
    }

    @When("user clicks on the Set Status button")
    public void user_clicks_on_the_set_status_button() {
        dashboardPage.setStatusButton.click();
    }

    @And("user should see status options")
    public void user_should_see_status_options_() {
        clickWithJS(dashboardPage.clearStatusMessage);
        dashboardPage.setStatusButton.click();
        for (WebElement eachOption : dashboardPage.statusOptionElements) {
            waitForVisibility(eachOption, 2);
            System.out.println("Status is visible: " + eachOption.getText());
            Assert.assertTrue("Status option is not displayed: " + eachOption.getText(), eachOption.isDisplayed());
        }
    }

    @When("user can select any status options")
    public void user_can_select_any_status_options() {
        for (WebElement eachOption : dashboardPage.statusOptionElements) {
            waitForClickablility(eachOption, 2);
            eachOption.click();
            sleep(1);
            String classAfterClick = eachOption.getAttribute("class");
            System.out.println("Status is selected: " + eachOption.getText());
            Assert.assertTrue("Status option is not selected: " + eachOption.getText(), classAfterClick.contains("status"));
        }
        dashboardPage.setStatus.click();
    }

    @Then("the selected status should be applied and visible")
    public void the_selected_status_should_be_applied_and_visible() {
        dashboardPage.setStatusButton.click();
        List<String> actualOptions = new ArrayList<>();
        List<String> expectedOption = new ArrayList<>();
        for (int i = 0; i < dashboardPage.statusOptionElements.size(); i++) {
            List<WebElement> options = dashboardPage.statusOptionElements;
            WebElement eachOption = options.get(i);
            eachOption.click();
            sleep(1);
            dashboardPage.setStatus.click();

            actualOptions.add(eachOption.getText().split("\n")[0].trim());
            expectedOption.add(dashboardPage.setStatusButton.getText());

            dashboardPage.setStatusButton.click();
        }
        System.out.println("Actual status options: " + actualOptions);
        System.out.println("Expected status options: " + expectedOption);
        Assert.assertEquals(expectedOption, actualOptions);
    }

    @And("user should see status message options")
    public void user_should_see_status_message_options() {
        for (WebElement message : dashboardPage.messageOptions) {
            waitForClickablility(message, 2);
            message.click();
            sleep(1);
            String classAfterClick = message.getAttribute("class");
            System.out.println("Status message is visible: " + message.getAttribute("class"));
            Assert.assertTrue("Status message option is not selected: " + message.getText(), classAfterClick.contains("predefined-status"));
        }
        dashboardPage.setStatus.click();
    }

    @When("user can select any status message options")
    public void user_can_select_any_status_message_options() {
        dashboardPage.setStatusButton.click();
        clickWithJS(dashboardPage.clearStatusMessage);
        dashboardPage.setStatusButton.click();
        for (WebElement message : dashboardPage.messageOptions) {
            waitForClickablility(message, 2);
            message.click();
            sleep(1);
            String classAfterClick = message.getAttribute("class");
            System.out.println("Status message is selected: " + message.getAttribute("class"));
            Assert.assertTrue("Status message option is not selected: " + message.getText(), classAfterClick.contains("predefined-status"));
        }
        dashboardPage.setStatus.click();
    }

    @Then("the selected status message should be applied and visible")
    public void the_selected_status_message_should_be_applied_and_visible() {
        dashboardPage.setStatusButton.click();
        clickWithJS(dashboardPage.clearStatusMessage);
        dashboardPage.setStatusButton.click();
        List<String> actualOptions = new ArrayList<>();
        List<String> expectedOption = new ArrayList<>();
        for (int i = 0; i < dashboardPage.messageOptions.size(); i++) {
            List<WebElement> options = dashboardPage.messageOptions;
            WebElement eachOption = options.get(i);
            eachOption.click();
            sleep(1);
            dashboardPage.setStatus.click();
            String fullText = eachOption.getText().trim();

            if (fullText.contains("\n")) {
                String[] parts = fullText.split("\n");
                fullText = parts[0] + " " + parts[1];
            }
            actualOptions.add(fullText);
            dashboardPage.setStatusButton.click();
            expectedOption.add(dashboardPage.setStatusButton.getText());
        }
        System.out.println("Actual status message options: " + actualOptions);
        System.out.println("Expected status message options: " + expectedOption);
        Assert.assertEquals("Status messages don't match", expectedOption, actualOptions);
    }

    @When("user type {string} and set status")
    public void user_type_and_set_status(String expectedMessage) {
        clickWithJS(dashboardPage.clearStatusMessage);
        dashboardPage.setStatusButton.click();
        waitFor(2);
        dashboardPage.statusInputBox.sendKeys(expectedMessage);
        waitFor(2);
        dashboardPage.setStatus.click();
    }

    @Then("the {string} should be applied and visible")
    public void the_should_be_applied_and_visible(String expectedMessage) {
        waitFor(2);
        String actualMessage = dashboardPage.statusText.getText().trim();
        System.out.println("Actual status message applies and visible: " + actualMessage);
        System.out.println("Expected status message applies and visible: " + expectedMessage);
        waitFor(2);
        Assert.assertEquals("Status messages don't match", expectedMessage, actualMessage);
    }

    @And("user clicks on clear status time options")
    public void user_clicks_on_clear_status_time_options() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", dashboardPage.setStatus);
        js.executeScript("arguments[0].scrollIntoView(true);", dashboardPage.timeBox);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.timeBox));
        dashboardPage.timeBox.click();
    }

    @And("user should see time options below")
    public void user_should_see_time_options_below(List<String> expectedTime) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        List<String> actualTimes = new ArrayList<>();

        for (WebElement eachTime : dashboardPage.timeOptions) {
            String firstText = "", lastText = "";

            try {
                firstText = (String) js.executeScript("return arguments[0].textContent;", eachTime.findElement(By.cssSelector(".name-parts__first")));
            } catch (Exception ignored) {
            }

            try {
                lastText = (String) js.executeScript("return arguments[0].textContent;", eachTime.findElement(By.cssSelector(".name-parts__last")));
            } catch (Exception ignored) {
            }
            actualTimes.add((firstText + lastText).trim());
        }
        Assert.assertEquals("Time options do not match", expectedTime, actualTimes);
        System.out.println("Actual times visible: " + actualTimes);
        System.out.println("Expected times visible: " + expectedTime);
    }

    @And("user selects any time option")
    public void user_selects_any_time_option() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", dashboardPage.setStatus);
        for (WebElement each : dashboardPage.timeOptions) {
            waitFor(1);
            clickWithJS(each);
            waitFor(1);
            System.out.println("Time is selected: " + each.getDomAttribute("title"));
        }
    }

    @Then("the selected time should be applied and visible in the time input field")
    public void the_selected_time_should_be_applied_and_visible_in_the_time_input_field() {
        for (WebElement each : dashboardPage.timeOptions) {
            dashboardPage.timeBox.click();
            waitFor(1);
            each.click();
            waitFor(1);
            Assert.assertTrue(dashboardPage.timeBox.isDisplayed());
            System.out.println("Time is displayed: " + dashboardPage.timeBox.getText());
        }
    }
}
