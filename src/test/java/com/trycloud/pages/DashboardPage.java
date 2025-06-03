package com.trycloud.pages;


import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.trycloud.utilities.BrowserUtils.waitForVisibility;


public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']//a")
    public List<WebElement> modulesName;

    @FindBy(id = "expand")
    public WebElement profileMenu;

    @FindBy(className = "user-status-menu-item__header")
    public WebElement userName;

    @FindBy(partialLinkText = "Customize")
    public WebElement customizeButton;

    @FindBy(xpath = "//label[contains(@for,'checkbox')]")
    public List<WebElement> widget;

    @FindBy(css = "button.background")
    public List<WebElement> background;

    public List<String> moduleName(List<WebElement> webElement, String attribute) {
        List<String> names = new ArrayList<>();
        for (WebElement each : webElement) {
            waitForVisibility(each, 30);
            String label = each.getAttribute(attribute);
            names.add(label);
        }
        return names;
    }

    public void verifyWidgets() {
        List<WebElement> widgets = this.widget;
        for (WebElement each : widgets) {
            waitForVisibility(each, 10);
            Assert.assertTrue(each.isDisplayed());
        }
    }
}
