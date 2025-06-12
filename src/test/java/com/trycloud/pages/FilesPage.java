package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FilesPage extends BasePage{

    @FindBy(linkText = "All files")
    public WebElement allFilesSelection;

    @FindBy(linkText = "Deleted files")
    public WebElement deletedFilesSelection;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusButton;

    @FindBy(css = "#file_upload_start")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//a[@data-action='folder']")
    public WebElement newFolderButton;

    @FindBy(id = "view13-input-folder")
    public WebElement newFolderNameInput;

    @FindBy(xpath = "//form[@class='filenameform']/input[2]")
    public WebElement arrowButtonNewFolder;

    @FindBy(xpath = "//span[.='textFile1']")
    public WebElement testTextFile1;

    @FindBy(xpath = "//tbody//tr[@data-file='Test folder']")
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
        BrowserUtils.sleep(2);
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

    //================Deleted Files Tab====================

    @FindBy(id = "app-content-trashbin")
    public WebElement deletedFilesTab;

    @FindBy(xpath = "//a[@data-sort='mtime']//span[.='Deleted']")
    public WebElement sortByDateButton;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//span[.='Name']")
    public WebElement sortByNameButton;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//tbody//tr//span[@class='innernametext']")
    public WebElement firstLineOfTheDeletedFileList;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//tbody//tr//td[@class='date']//span")
    public List<WebElement> listOfFileDates;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//tbody//tr//td[@class='filename']//span[@class='innernametext']")
    public List<WebElement> listOfFileNames;

    @FindBy(xpath = "//a[@class='menuitem action action-delete permanent']")
    public WebElement deletePermanentlyThreeDotButton;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//a[@class='actions-selected']")
    public WebElement actionsButtonInDeleted;

    @FindBy(xpath = "//a[@data-action='restore']")
    public WebElement restoreActions;

    @FindBy(xpath = "//div[@id='app-content-trashbin']//a[@data-action='delete']")
    public WebElement deletePermanentlyActions;

    public boolean filesSortedByOldestToNewest(List<WebElement> listOfFileDates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a", Locale.US);

        List<LocalDateTime> actualDates = listOfFileDates.stream()
                .map(element -> element.getAttribute("data-original-title"))
                .map(dateString -> LocalDateTime.parse(dateString, formatter))
                .collect(Collectors.toList());

        List<LocalDateTime> sortedDates = new ArrayList<>(actualDates);
        Collections.sort(sortedDates);

        return actualDates.equals(sortedDates);
    }

    public boolean filesSortedByNewestToOldest(List<WebElement> listOfFileDates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a", Locale.US);

        List<LocalDateTime> actualDates = listOfFileDates.stream()
                .map(element -> element.getAttribute("data-original-title"))
                .map(dateString -> LocalDateTime.parse(dateString, formatter))
                .collect(Collectors.toList());

        List<LocalDateTime> sortedDates = new ArrayList<>(actualDates);
        sortedDates.sort(Comparator.reverseOrder());

        return actualDates.equals(sortedDates);
    }

    public boolean fileNamesSortedAlphabetically(List<WebElement> listOfFileNames) {
        List<String> actualNames = listOfFileNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedNames = new ArrayList<>(actualNames);
        Collections.sort(sortedNames, String.CASE_INSENSITIVE_ORDER);

        return actualNames.equals(sortedNames);
    }

    public boolean fileNamesSortedInReverseAlphabeticalOrder(List<WebElement> listOfFileNames) {
        List<String> actualNames = listOfFileNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedNames = new ArrayList<>(actualNames);
        sortedNames.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

        return actualNames.equals(sortedNames);
    }

    public WebElement getThreeDotMenuDeleted(String fileName) {
        String xpath = "//div[@id='app-content-trashbin']//tr[starts-with(@data-file, '" + fileName + "')]" +
                "//a[@data-action='menu']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement getRestoreButton(String fileName) {
        String xpath = "//div[@id='app-content-trashbin']//tr[starts-with(@data-file, '" + fileName + "')]" +
                "//a[@data-action='Restore']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public boolean fileNameNotPresent(String fileName, List<WebElement> listOfFileNames) {
        List<String> actualFileNames = listOfFileNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        return !actualFileNames.contains(fileName);
    }

    public WebElement getCheckBoxDeleted(String fileName) {
        String xpath = "//div[@id='app-content-trashbin']//tr[starts-with(@data-file, '" + fileName + "')]/td[@class='selection']";
        return Driver.getDriver().findElement(By.xpath(xpath));
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
