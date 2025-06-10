package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(xpath = "//div[@class='predefined-status']")
    public List<WebElement> messageOptions;

    @FindBy(xpath = "//div[@class='status-buttons']//button[1]")
    public WebElement clearStatusMessage;

    @FindBy(xpath = "//input[@class='multiselect__input']")
    public WebElement inputTimeOptionsDropdown;

    @FindBy(css = "div.name-parts")
    public List<WebElement> timeOptions;

    @FindBy(xpath = "//input[@maxlength='80']")
    public WebElement statusInputBox;

    @FindBy(xpath = "//button[contains(@class, 'user-status-menu-item__toggle')]")
    public WebElement statusText;

    @FindBy(xpath = "//input[@placeholder='Select option']")
    public WebElement inputBox;

    @FindBy(xpath = "//span[@class='multiselect__single']")
    public WebElement timeBox;

}

