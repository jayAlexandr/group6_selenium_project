package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
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

    @FindBy(className = "oc-dialog-close")
    public WebElement exit;

    public List<String> moduleNames(List<WebElement> webElement) {
        List<String> names = new ArrayList<>();
        for (WebElement each : webElement) {
            String module = each.getAttribute("aria-label");
            names.add(module);
        }
        return names;
    }

    public void verifyWidgetsIsDisplayed() {
        for (WebElement each : widgetCheckbox) {
            Assert.assertTrue(each.isSelected());
        }
    }

    public void checkboxesSelected() {
        for (WebElement eachCheckbox : widgetCheckbox) {
            if (eachCheckbox.isSelected()) {
                continue;
            }
            BrowserUtils.clickWithJS(eachCheckbox);
        }
    }

    public void verifyBackgroundIsDisplay() {
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
        }
    }
}

