package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "user")
    public WebElement usernameInput;

    @FindBy (id = "password")
    public WebElement passwordInput;

    @FindBy (id = "submit-form")
    public WebElement loginButton;

    // US - 1
    @FindBy
    public WebElement blankCredentialMessage;

    @FindBy (xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement invalidCredentialMessage;

    @FindBy (xpath = "//a[@class='toggle-password']")
    public WebElement togglePassword;

    @FindBy (id = "lost-password")
    public WebElement forgotPasswordButton;

    @FindBy (id = "reset-password-submit")
    public WebElement resetPasswordButton;



    public void login(){
        usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }


}
