package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@id='settings']")
    public WebElement userIcon;
    @FindBy(xpath = "//a[@href='/index.php/settings/user']")
    public WebElement userSettings;


    @FindBy (xpath = "//li[@data-id='files']")
    public WebElement filesModuleButton;



}
