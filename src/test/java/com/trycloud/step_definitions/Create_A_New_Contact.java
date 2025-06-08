package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

public class Create_A_New_Contact {

    ContactsPage contactsPage = new ContactsPage();
    BasePage basePage = new BasePage();

    @When("user clicks the Contacts Tab")
    public void user_clicks_the_contacts_tab() {

        //click the contact module
        basePage.contactsTab.click();
    }
    @When("user clicks the New contact button")
    public void user_clicks_the_new_contact_button() {

        //click the add new contact button
        contactsPage.addNewContact_Button.click();
        BrowserUtils.sleep(1);

    }
    @And("user enters {string} in the company box")
    public void userEntersInTheCompanyBox(String name) {

        //Enter the name in the Company box
        contactsPage.newContact_CompanyBox.sendKeys(name);
        BrowserUtils.sleep(2);
    }


    @And("user enters {string} in the title box")
    public void userEntersInTheTitleBox(String lastName) {

        //enter the last name in the Title box
        contactsPage.newContact_TitleBox.sendKeys(lastName);
        BrowserUtils.sleep(2);

    }


    @Then("user can see the new contact in the All contacts list")
    public void userCanSeeTheInTheAllContactsList() {

        // click the all contacts button
        contactsPage.allContacts_Button.click();

        // Determine the size of the list and counter number
        int sizeOfList = contactsPage.contactsList.size();
        int counterOfList = Integer.parseInt(contactsPage.counter_List.getText());

        //check if the counter is the same as the size of the list
        Assert.assertTrue(contactsPage.isContactDisplayed(sizeOfList,counterOfList));

    }


}

