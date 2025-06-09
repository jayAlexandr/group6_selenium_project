package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ContactsPage {

    public ContactsPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "new-contact-button")
    public WebElement addNewContact_Button;

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

    @FindBy(xpath = "//tr[@data-entryname='2mb-jpg-test-file.jpg']")
    public WebElement image_Link;


    @FindBy(xpath = "//button[@class='primary']")
    public WebElement chooseButton;

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


    public List<String> webeElementList_To_StringList(List<WebElement> listOfWebE){

        List<String> listOfNames = new ArrayList<>();

        for (WebElement each : listOfWebE) {

            listOfNames.add(each.getText());

        }

        return listOfNames;
    }

    public boolean isContactDisplayed(int sizeOfList, int counterList) {

        return sizeOfList == counterList;
    }

}
