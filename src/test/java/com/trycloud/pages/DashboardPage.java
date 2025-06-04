package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.junit.Assert;
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

    @FindBy(xpath = "//button[@class='background filepicker']")
    public WebElement pickFromFile;

    @FindBy(xpath = "//td[@class='filename']")
    public WebElement image;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement choose;


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
            Assert.assertTrue(eachImage.isEnabled());
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
            System.out.println(actualBackground);
            Assert.assertTrue("Background not selected: " + text, actualBackground.contains(expectedBackground));
        }
    }

    public void verifyChooseBGFromFile() {
        customizeButton.click();
        pickFromFile.click();
        image.click();
        choose.click();
        Assert.assertTrue(image.isDisplayed());
    }
}