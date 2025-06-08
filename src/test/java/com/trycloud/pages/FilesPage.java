package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage extends BasePage{

    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "All files")
    public WebElement allFilesSelection;

    @FindBy(linkText = "Deleted files")
    public WebElement deletedFilesSelection;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusButton;

    @FindBy(id = "file_upload_start")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//a[@data-action='folder']")
    public WebElement newFolderButton;

    @FindBy(id = "view13-input-folder")
    public WebElement newFolderNameInput;

    @FindBy(xpath = "//form[@class='filenameform']/input[2]")
    public WebElement arrowButtonNewFolder;

    @FindBy(xpath = "//span[.='textFile1']")
    public WebElement testTextFile1;

    @FindBy(xpath = "//span[.='Test folder']")
    public WebElement testFolder;

    @FindBy(xpath = "//span[.='~!@#$%^&*()_+-={}[]|,<>.?']")
    public WebElement testSpecChar;

    @FindBy(xpath = "//div[@class='toastify on dialogs error toastify-right toastify-top']")
    public WebElement errorMessage;

    @FindBy(className = "oc-dialog")
    public WebElement warningMessage;

    @FindBy(className = "tooltip-inner")
    public WebElement folderExistMessage;

    @FindBy(xpath = "//a[@data-action='MoveCopy']")
    public WebElement moveOrCopyButton;

    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteFileButton;

    @FindBy(className = "actions-selected")
    public WebElement actionsButton;

    @FindBy(xpath = "//a[@data-action='copyMove']")
    public WebElement moveOrCopyActions;

    @FindBy(xpath = "//a[@data-action='delete']")
    public WebElement deleteActions;

    @FindBy (xpath = "//div[@class='oc-dialog']//button")
    public WebElement ocCopyTo;

    @FindBy (xpath = "//button[@class='primary']")
    public WebElement ocMoveTo;

    @FindBy(xpath = "//tr[@data-entryname='Test folder']")
    public WebElement ocTestFolder;

    @FindBy(xpath = "//tr[@data-type='file']")
    public List<WebElement> listOfFiles;

    @FindBy(xpath = "//tr[@data-type='dir']")
    public List<WebElement> listOfFolders;

    @FindBy(className = "fileinfo")
    public WebElement filesCountTotal;

    @FindBy(className = "dirinfo")
    public WebElement foldersCountTotal;

    public int getActualFileCount() {
        return listOfFiles.size();
    }

    public int getActualFolderCount() {
        return listOfFolders.size();
    }

    public int getExpectedFileCount() {
        return extractNumberFromText(filesCountTotal.getText());
    }

    public int getExpectedFolderCount() {
        return extractNumberFromText(foldersCountTotal.getText());
    }

    public int extractNumberFromText(String text) {
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public void verifyFileIsDisplayed(String fileName) {
        BrowserUtils.sleep(2);
        String fileXpath = "//span[.='" + fileName + "']";
        WebElement fileElement = Driver.getDriver().findElement(By.xpath(fileXpath));
        BrowserUtils.waitForVisibility(fileElement, 5);
        Assert.assertTrue(fileElement.isDisplayed());
    }

    public void itemIsDisplayed(WebElement file){
        BrowserUtils.waitFor(2);
        Assert.assertTrue(file.isDisplayed());
    }

    public void messageIsDisplayed(WebElement element, String expectedMessage) {
        BrowserUtils.waitForVisibility(element, 20);
        Assert.assertTrue(element.getText().contains(expectedMessage));
    }

    public WebElement getThreeDotMenu(String fileName) {
        String xpath = "//tr[@data-file='" + fileName + "']//a[@data-action='menu']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement getCheckBox(String fileName) {
        String xpath = "//tr[@data-file='" + fileName + "']/td[@class='selection']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    //iskandar

    @FindBy (xpath = "//tr[@data-id='178201']")
    public WebElement fileNameBox;

    @FindBy (xpath = "//tr[@data-id='178201']/td[2]/a/span[1]/span[1]")
    public WebElement fileNameInputBox;

    @FindBy (xpath = "//tr[@data-id='178201']/td[2]/a/span[2]/a[2]")
    public WebElement fileThreeDots;

    @FindBy (xpath = "//li[@class=' action-favorite-container']")
    public WebElement addFavoriteButton;

    @FindBy (xpath = "//li[@class=' action-details-container']")
    public WebElement detailsButton;

    @FindBy (xpath = "//li[@class=' action-rename-container']")
    public WebElement renameButton;

    @FindBy (xpath = "//li[@data-id='favorites']")
    public WebElement favoritesFolder;

    @FindBy (xpath = "//tr[@data-id='178201']/td[1]/a/span[2]/a[2]")
    public WebElement threeDotsInFavorites;





}
