package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactsPage {

    public ContactsPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "new-contact-button")
    public WebElement addNewContact_Button;

    @FindBy(id = "contact-fullname")
    public WebElement newContactName_Box;

    @FindBy(xpath = "//a[@class='header-icon icon-error header-icon--pulse has-tooltip']")
    public WebElement errorMessage;

    @FindBy(id = "contact-org")
    public WebElement newContact_CompanyBox;

    @FindBy(id = "contact-title")
    public  WebElement newContact_TitleBox;

    @FindBy(xpath = "//div[@class='app-content-list-item-line-one']")
    public List<WebElement> contactsList;

    @FindBy(xpath = "//span[@title='All contacts']")
    public WebElement allContacts_Button;

    @FindBy(xpath = "//div[@class='app-navigation-entry__counter']")
    public WebElement counter_List;

    @FindBy(xpath = "//button[@class='icon action-item__menutoggle icon-picture-force-white']")
    public WebElement image_Icon;

    @FindBy(xpath = "(//div[@class='popover__inner']//button)[2]")
    public WebElement chooseFromFile;

    @FindBy(xpath = "//tr[@data-entryname='pinkRose.jpg']")
    public WebElement image_Link;


    @FindBy(xpath = "//button[@class='primary']")
    public WebElement chooseButton;

    @FindBy(xpath = "//div[@class='contact-header-avatar__photo']")
    public WebElement image_exist;

    @FindBy(xpath = "//div[@class='contact-header__actions']")
    public WebElement actionsMenuButton;

    @FindBy(xpath = "(//div[@class='popover__inner']//div//li)[3]//span[.='Delete']")
    public WebElement deleteButton;

    @FindBy(id = "newgroup")
    public WebElement CreateNewGroup_icon;

    @FindBy(xpath = "//span[@class='action-input']//input[@type='text']")
    public WebElement addGroupName_box;

    @FindBy(xpath = "//input[@placeholder='Add contact in group']")
    public WebElement Group_button;

    @FindBy(xpath = "//input[@placeholder='Add contact in group']/../following-sibling::*//li/span/div")
    public List<WebElement> listOfGroups_Options;

    @FindBy(xpath = "//li[@id='everyone']/../li//span")
    public List<WebElement> elementsInFirstColumn;



    // get the list of string from a list of webElements
    public List<String> webeElementList_To_StringList(List<WebElement> listOfWebE){

        List<String> listOfNames = new ArrayList<>();

        for (WebElement each : listOfWebE) {

            listOfNames.add(each.getText());

        }

        return listOfNames;
    }


    //verify if a contact is added to the list
    public boolean isContactDisplayed(int sizeOfList, int counterList) {

        return sizeOfList == counterList;
    }

    //verify if a contact exist in the list

    public boolean isExistingInList(List<String> list, String contactName){

        boolean isDisplayed = false;

        if (list == null || list.isEmpty() || contactName == null) {
            return false;
        }

        for (String each : list) {

            if (each.equals(contactName)){

                isDisplayed = true;
            }
        }

        return isDisplayed;

    }

    //return how many contacts with same name
    public int calculateDuplicateContact(List<String> list, String contactName){

        int counter = 0;

        if (list == null || list.isEmpty() || contactName == null) {
            return counter;
        }

        for (String each : list) {

            if (each.equals(contactName)){

                counter++;
            }
        }

        return counter;

    }
    // invalidName to validName
    public String toProcessedName(String invalidName) {
        if (invalidName == null) {
            return "";
        }

        switch(invalidName) {
            case "\\name":
                return Keys.BACK_SPACE + "name";

            case "Name\\nWithNewline":  // Standardized format
                return "Name" + Keys.RETURN + "WithNewline";

            case "#{'A' * 500}":
                return new String(new char[500]).replace("\0", "A");

            case "\"\"":  // Explicit empty string case
                return "";

            case "\"   \"":  // Whitespace case
                return "   ";

            default:
                // Handle other special patterns or return as-is
                return invalidName;
        }
    }

    //verify if a message is displayed
    public boolean isErrorMessageDisplayed(WebElement errorElement, String errorMessageText) {
        try {

            return errorElement.isDisplayed() &&
                    errorElement.getAttribute("class").contains(errorMessageText);

        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // get the groups' names in the first column
    public List<String> listGroups_In_FirstColumn(){

        int elementOfFirstColumn = elementsInFirstColumn.size();
        //System.out.println("elementOfFirstColumn = " + elementOfFirstColumn);

        List<String> listOfGroups_FirstColumn = new ArrayList<>();

        for (int i = 2; i < elementOfFirstColumn-1; i++) {

            listOfGroups_FirstColumn.add(elementsInFirstColumn.get(i).
                    getAttribute("title"));

        }

        return listOfGroups_FirstColumn;

    }

}
