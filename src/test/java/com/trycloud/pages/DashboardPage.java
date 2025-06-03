package com.trycloud.pages;


import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.trycloud.utilities.BrowserUtils.*;


public class DashboardPage extends BasePage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']//a")
    public List<WebElement> modulesName;

    @FindBy(className = "user-status-menu-item__header")
    public WebElement userName;

    @FindBy(partialLinkText = "Customize")
    public WebElement customizeButton;

    @FindBy(xpath = "//label[contains(@for,'checkbox')]")
    public List<WebElement> widgetCheckbox;

    @FindBy(css = "button.background")
    public List<WebElement> background;

    public List<String> moduleName(List<WebElement> webElement) {
        List<String> names = new ArrayList<>();
        for (WebElement each : webElement) {
            String label = each.getAttribute("aria-label");
            names.add(label);
        }
        return names;
    }

    public void verifyWidgets(List<String> expectedWidgetNames) {
        List<WebElement> widgets = this.widgetCheckbox;
        List<String> actualWidgetNames = new ArrayList<>();
        for (WebElement each : widgets) {
            waitForVisibility(each, 10);
            actualWidgetNames.add(each.getText());
        }
        Assert.assertEquals(expectedWidgetNames, actualWidgetNames);
    }

    public void verifyWidgetCheckbox() {
        List<WebElement> labels = this.widgetCheckbox;
        for (WebElement label : labels) {
            String forAttribute = label.getDomAttribute("for");
            WebElement checkbox = Driver.getDriver().findElement(By.id(forAttribute));
            if (!checkbox.isSelected()) {
                waitForClickablility(label, 10);
                label.click();
            }
            Assert.assertTrue(checkbox.isSelected());
            //"Checkbox not selected: " + forAttribute,
        }
    }
}
