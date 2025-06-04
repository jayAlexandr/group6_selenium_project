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

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusButton;

    @FindBy(id = "file_upload_start")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//span[.='1mb-examplefile']")
    public WebElement test1MBFile;

    @FindBy(xpath = "//span[.='2mb-jpg-test-file']")
    public WebElement test2MBFile;

    @FindBy(xpath = "//span[.='3-mb-sample-pdf-file']")
    public WebElement test3MBFile;

    @FindBy(xpath = "//span[.='4mb']")
    public WebElement test4MBFile;

    @FindBy(xpath = "//span[.='5mb']")
    public WebElement test5MBFile;

    @FindBy(xpath = "//span[.='6mb-example-video-file']")
    public WebElement test6MBFile;

    @FindBy(xpath = "//span[.='7mb']")
    public WebElement test7MBFile;

    @FindBy(xpath = "//span[.='8mb']")
    public WebElement test8MBFile;

    @FindBy(xpath = "//span[.='9mb']")
    public WebElement test9MBFile;

    @FindBy(xpath = "//span[.='textFile1']")
    public WebElement testTextFile1;

    @FindBy(xpath = "//span[.='textFile2']")
    public WebElement testTextFile2;

    @FindBy(xpath = "//div[@class='toastify on dialogs error toastify-right toastify-top']")
    public WebElement errorMessage;

    @FindBy(className = "oc-dialog")
    public WebElement warningMessage;

    //iskandar

    @FindBy(className = "oc-dialog")
    public WebElement warninggMessage;


}
