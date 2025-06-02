package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesModulePage extends BasePage{

    public FilesModulePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "All files")
    public WebElement allFilesSelection;



}
