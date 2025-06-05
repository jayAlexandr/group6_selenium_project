package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.trycloud.utilities.BrowserUtils.*;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//ul[@id='appmenu']//a")
    public List<WebElement> modulesName;

    @FindBy(className = "user-status-menu-item__header")
    public WebElement userName;

    @FindBy(partialLinkText = "Customize")
    public WebElement customizeButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> widgetCheckbox;

    @FindBy(xpath = "//button[@tabindex='0']")
    public List<WebElement> background;

    @FindBy(xpath = "//button[@href='#']")
    public WebElement setStatusButton;

    @FindBy(xpath = "//div[@class='user-status-online-select']")
    public List<WebElement> statusOptionElements;

    @FindBy(xpath = "//button[@class='status-buttons__primary primary']")
    public WebElement setStatus;

    public List<String> moduleNames(List<WebElement> webElement) {
        List<String> names = new ArrayList<>();
        for (WebElement each : webElement) {
            String module = each.getAttribute("aria-label");
            names.add(module);
        }
        return names;
    }

    public void verifyWidgetsAreDisplayed() {
        for (WebElement each : widgetCheckbox) {
            Assert.assertTrue("Widget checkbox is not enabled: " + each.getAttribute("id"), each.isEnabled());
        }
    }

    public void selectAllWidgets() {
        for (WebElement eachCheckbox : widgetCheckbox) {
            if (eachCheckbox.isSelected()) {
                continue;
            }
            clickWithJS(eachCheckbox);
            Assert.assertTrue(eachCheckbox.isSelected());
        }
    }

    public void verifyBackgroundsAreDisplay() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, 200);");
        for (WebElement eachImage : background) {
            Assert.assertTrue("Background is not enabled: " + eachImage.getAttribute("style"), eachImage.isEnabled());
        }
    }

    public void verifyBackgroundSelected() {
        for (WebElement eachImage : background) {
            String text = eachImage.getText();
            if (text.contains("Pick from files")) {
                continue;
            }
            clickWithJS(eachImage);
            String actualBackground = eachImage.getAttribute("class");
            String expectedBackground = "background";
            Assert.assertTrue("Background is not selected: " + text, actualBackground.contains(expectedBackground));
        }
    }

    public void verifyOptionsAreDisplayed() {
        for (WebElement eachOption : statusOptionElements) {
            waitForVisibility(eachOption, 2);
            Assert.assertTrue("Status option is not displayed: " + eachOption.getText(), eachOption.isDisplayed());
        }
    }

    public void selectStatusOptions() {
        for (WebElement eachOption : statusOptionElements) {
            waitForClickablility(eachOption, 2);
            eachOption.click();
            sleep(1);
            String classAfterClick = eachOption.getAttribute("class");

            Assert.assertTrue("Button should have 'active' class after click", classAfterClick.contains("status"));
        }
        setStatus.click();
    }

    public void verifySelectedIsVisible() {
        List<String> actualOptions = new ArrayList<>();
        List<String> expectedOption = new ArrayList<>();
        for (int i = 0; i < statusOptionElements.size(); i++) {
            List<WebElement> options = this.statusOptionElements;
            WebElement eachOption = options.get(i);
            eachOption.click();
            sleep(1);
            setStatus.click();
            actualOptions.add(eachOption.getText().split("\n")[0].trim());
            expectedOption.add(setStatusButton.getText());
            setStatusButton.click();
        }
        Assert.assertEquals(expectedOption, actualOptions);
    }
    //TODO: Look in to how to verify clicking
}

