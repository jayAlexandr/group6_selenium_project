package com.trycloud.pages;


import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//TODO : locate all the interactive web elements
public class SettingsPage {
    public SettingsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//label[.='Full name']")
    public WebElement fullNameLabel;
    @FindBy(xpath = "//label[.='Email']")
    public WebElement emailLabel;
    @FindBy(xpath = "//label[.='Phone number']")
    public WebElement phoneNumberLabel;
    @FindBy(xpath = "//input[@id='displayname']")
    public WebElement fullNameInput;
    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneInput;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;
    @FindBy(xpath = "(//span[@class='icon-triangle-s'])[4]")
    public WebElement phoneSettingsIcon;
    @FindBy (xpath = "//strong[.='Private']")
    public WebElement privatePhoneSelection;

}
