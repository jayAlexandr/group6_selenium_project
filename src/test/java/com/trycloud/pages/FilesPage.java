package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//tr[@data-file='textFile1.txt']//a[@data-action='menu']")
    public WebElement threeDotMenuTF1;

    @FindBy(xpath = "//tr[@data-file='7mb.zip']//a[@data-action='menu']")
    public WebElement threeDotMenu7MB;

    @FindBy(xpath = "//a[@data-action='MoveCopy']")
    public WebElement moveOrCopyButton;

    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteFileButton;

    @FindBy(xpath = "//tr[@data-file='textFile2.txt']/td[@class='selection']")
    public WebElement itemCheckBoxTF2;

    @FindBy(xpath = "//tr[@data-file='1mb-examplefile.txt']/td[@class='selection']")
    public WebElement itemCheckBox1MB;

    @FindBy(xpath = "//tr[@data-file='8mb.rar']/td[@class='selection']")
    public WebElement itemCheckBox8MB;

    @FindBy(xpath = "//tr[@data-file='9mb.iso']/td[@class='selection']")
    public WebElement itemCheckBox9MB;

    @FindBy(className = "actions-selected")
    public WebElement actionsButton;

    @FindBy(xpath = "//a[@data-action='copyMove']")
    public WebElement moveOrCopyActions;

    @FindBy(xpath = "//a[@data-action='delete']")
    public WebElement deleteActions;

    @FindBy(xpath = "//div[@class='oc-dialog']//button")
    public WebElement ocCopyButton;

    @FindBy(xpath = "//button[.='Move']")
    public WebElement ocMoveButton;

    @FindBy (xpath = "//div[@class='oc-dialog']//button")
    public WebElement ocCopyTo;

    @FindBy (xpath = "//button[@class='primary']")
    public WebElement ocMoveTo;

    @FindBy(xpath = "//tr[@data-entryname='Test folder']")
    public WebElement ocTestFolder;

    public void itemIsDisplayed(WebElement file){
        BrowserUtils.waitFor(2);
        Assert.assertTrue(file.isDisplayed());
    }
    public void messageIsDisplayed(WebElement file, String message){
        BrowserUtils.waitFor(2);
        Assert.assertTrue(file.getText().contains(message));
    }


    //iskandar

    @FindBy (xpath = "//tr[@data-id='180499']")
    public WebElement fileNameBox;

    @FindBy (xpath = "//tr[@data-id='180499']/td[2]/a/span[1]/span[1]")
    public WebElement fileNameInputBox;

    @FindBy (xpath = "//tr[@data-id='180499']/td[2]/a/span[2]/a[2]")
    public WebElement fileThreeDots;

    @FindBy (xpath = "//li[@class=' action-favorite-container']")
    public WebElement addFavoriteButton;

    @FindBy (xpath = "//li[@class=' action-details-container']")
    public WebElement detailsButton;

    @FindBy (xpath = "//li[@class=' action-rename-container']")
    public WebElement renameButton;

    @FindBy (xpath = "//li[@data-id='favorites']")
    public WebElement favoritesFolder;

    @FindBy (xpath = "//tr[@data-id='180499']/td[1]/a/span[2]/a[2]")
    public WebElement threeDotsInFavorites;

    @FindBy (xpath = "//a[@id='commentsTabView']")
    public WebElement commentButton;

    @FindBy (xpath = "//div[@data-placeholder='New comment …']")
    public WebElement commentInputBox;

    @FindBy (xpath = "//input[@class='submit icon-confirm has-tooltip']")
    public WebElement commentSubmitButton;

    @FindBy (xpath = "//a[@class='action more icon icon-more has-tooltip']")
    public WebElement threeDotsInComments;

    @FindBy (xpath = "(//a[@class='menuitem action delete permanent'])[2]")
    public WebElement deleteButtonInComments;

    @FindBy (xpath = "(//div[@class='emptycontent'])[2]")
    public WebElement noComments;





}
