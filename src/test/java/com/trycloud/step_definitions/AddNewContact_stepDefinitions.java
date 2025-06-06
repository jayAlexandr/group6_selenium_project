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

public class AddNewContact_stepDefinitions {

    ContactsPage contactsPage = new ContactsPage();
    BasePage basePage = new BasePage();

    @When("user clicks the Contacts Tab")
    public void user_clicks_the_contacts_tab() {

        basePage.contactsTab.click();
    }
    @When("user clicks the New contact button")
    public void user_clicks_the_new_contact_button() {

        contactsPage.addNewContact_Button.click();
        BrowserUtils.sleep(2);

    }
    @And("user write the {string} in the company box")
    public void userWriteTheInTheCompanyBox(String firstName) {

        contactsPage.newContact_CompanyBox.sendKeys(firstName);

        BrowserUtils.sleep(1);

    }

    @And("user write the {string} in the title box")
    public void userWriteTheInTheTitleBox(String lastName) {

        contactsPage.newContact_TitleBox.sendKeys(lastName);
        BrowserUtils.sleep(1);
    }

    @Then("user can see the {string} in the All contacts list")
    public void user_can_see_the_in_the_all_contacts_list(String expectedNewContact) {

        contactsPage.allContacts.click();

        BrowserUtils.sleep(2);

        List<String> currentContacts = new ArrayList<>();
        currentContacts = contactsPage.webeElementList_To_StringList(contactsPage.contactsList);

        //System.out.println(currentContacts.size());// number of contacts
        //System.out.println(currentContacts);// print the list of contacts

        Driver.getDriver().navigate().refresh();

        BrowserUtils.sleep(3);

        // assertion if the expected new contact is in the list
        Assert.assertTrue(currentContacts.contains(expectedNewContact));
    }



}
