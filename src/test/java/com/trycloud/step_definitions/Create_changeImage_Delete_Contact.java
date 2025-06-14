package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Create_changeImage_Delete_Contact {

    ContactsPage contactsPage = new ContactsPage();
    BasePage basePage = new BasePage();

    //------------------Click the contact Module--------------------------------

    @When("user clicks the Contacts Tab")
    public void user_clicks_the_contacts_tab() {

        //click the contact module
        basePage.contactsTab.click();
    }

    //------------------Add New Contact (POSITIVE Scenario)----------------------

    @When("user clicks the New contact button")
    public void user_clicks_the_new_contact_button() {

        //click the add new contact button
        contactsPage.addNewContact_Button.click();
        BrowserUtils.sleep(1);

    }

    @And("user enters {string} of the new contact")
    public void userEntersOfTheNewContact(String validName) {

        List<String> namesInList = contactsPage.
                webeElementList_To_StringList(contactsPage.contactsList);

        // enter the valid name
        //Verify if it is already in the list
        if (!contactsPage.isExistingInList(namesInList, validName)){

            contactsPage.newContactName_Box.clear();
            contactsPage.newContactName_Box.sendKeys(validName);
            BrowserUtils.waitFor(1);

        }else{
            System.out.println("Skipped - Contact already exists: " + validName);
        }

    }

    @Then("user can see {string} in the All contacts list")
    public void userCanSeeInTheAllContactsList(String expectedName) {
        // click the all contacts button
        contactsPage.allContacts_Button.click();
        BrowserUtils.waitFor(1);

        //see the list in the second column
        List<String> namesInList = contactsPage.
                webeElementList_To_StringList(contactsPage.contactsList);

        // Verify if the expected contact is in the list
        Assert.assertTrue("contact is successfully added!",
                contactsPage.isExistingInList(namesInList, expectedName));

    }

    //------------------Add New Contact (NEGATIVE Scenario 1) Invalid names----------------------

    //---------------------Add an empty contact-----------------------------

    @And("user attempts to create contact empty")
    public void userAttemptsToCreateContactEmpty() {

        contactsPage.newContactName_Box.
                sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        contactsPage.newContactName_Box.
                sendKeys(Keys.DELETE); // delete selected

        contactsPage.newContactName_Box.
                sendKeys("");

        BrowserUtils.waitFor(1);
        Driver.getDriver().navigate().refresh();

    }

    @Then("user couldn't see empty contact in the all contact list")
    public void userCouldnTSeeEmptyContactInTheAllContactList() {

        // click the all contacts button
        contactsPage.allContacts_Button.click();
        BrowserUtils.waitFor(1);

        //see the list in the second column
        List<String> namesInList = contactsPage.
                webeElementList_To_StringList(contactsPage.contactsList);

        // Verify if the invalid name is in the list
        Assert.assertFalse("BUG: System incorrectly saved an Empty name '",
                contactsPage.isExistingInList(namesInList, ""));

    }
    @And("the system should immediately show an errorMessage")
    public void theSystemShouldImmediatelyShowAnErrorMessage() {

        // Verify an error message

        if (contactsPage.isErrorMessageDisplayed(contactsPage.errorMessage,
                "error")){

            System.out.println("Error message is successfully Displayed!!!");
        }else {

            System.out.println("Error message is Not Displayed!!");

        }

    }
    //========================================================================
    //------------Add WhiteSpace as a new contact------------

    @And("user attempts to create contact space")
    public void userAttemptsToCreateContactSpace() {

        contactsPage.newContactName_Box.
                sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        contactsPage.newContactName_Box.
                sendKeys(Keys.DELETE); // delete selected

        contactsPage.newContactName_Box.
                sendKeys(" ");
        BrowserUtils.waitFor(1);
        contactsPage.newContactName_Box.
                sendKeys(" ");//it registers as an empty contact

        Driver.getDriver().navigate().refresh();
    }

    @Then("user couldn't see space in the all contact list")
    public void userCouldnTSeeSpaceInTheAllContactList() {
        // click the all contacts button
        contactsPage.allContacts_Button.click();
        BrowserUtils.waitFor(1);

        //see the list in the second column
        List<String> namesInList = contactsPage.
                webeElementList_To_StringList(contactsPage.contactsList);

        // Verify if the invalid name is in the list
        Assert.assertFalse("BUG: System incorrectly saved an Empty name '",
                contactsPage.isExistingInList(namesInList, ""));

    }

    //======================================================================
    //

    @And("user attempts to create contact {string}")
    public void userAttemptsToCreateContact(String invalidName) {

        List<String> namesInList = contactsPage.
                webeElementList_To_StringList(contactsPage.contactsList);

        if (!contactsPage.isExistingInList(namesInList, invalidName)){

            contactsPage.newContactName_Box.clear();

            //processing the invalidName
            String processedName = contactsPage.toProcessedName(invalidName);
            contactsPage.newContactName_Box.
                    sendKeys(processedName);
            BrowserUtils.waitFor(1);

        }else{
            System.out.println("Skipped - Contact already exists: " + invalidName);
        }


    }
    @Then("user couldn't see {string} in the all contact list")
    public void userCouldnTSeeInTheAllContactList(String invalidName) {

        // click the all contacts button
        contactsPage.allContacts_Button.click();
        BrowserUtils.waitFor(1);

        //see the list in the second column
        List<String> namesInList = contactsPage.
                webeElementList_To_StringList(contactsPage.contactsList);


        // Verify if the invalid name is in the list
        Assert.assertFalse("BUG: System incorrectly saved invalid name '" +
                        contactsPage.toProcessedName(invalidName)+ "'",
                contactsPage.isExistingInList(namesInList, contactsPage.
                        toProcessedName(invalidName)));
    }

    //===================================================================
    //--------------------Create a duplicate contact--------------------

    @Given("a contact {string} already exists")
    public void aContactAlreadyExists(String existingName) {

        //see the list in the second column
        List<String> namesInList = contactsPage.
                webeElementList_To_StringList(contactsPage.contactsList);

        // Verify if the existing name is still in the list
        Assert.assertTrue("contact is still in the list!",
                contactsPage.isExistingInList(namesInList, existingName));

    }

    @When("user tries to create another contact {string}")
    public void userTriesToCreateAnotherContact(String existingName) {

        contactsPage.newContactName_Box.clear();
        contactsPage.newContactName_Box.sendKeys(existingName);
        BrowserUtils.waitFor(1);

    }

    @And("only one {string} should exist in the list")
    public void onlyOneShouldExistInTheList(String existingName) {

        //see the list in the second column
        List<String> namesInList = contactsPage.
                webeElementList_To_StringList(contactsPage.contactsList);

        Assert.assertTrue("No Duplicated Names!",contactsPage.
                calculateDuplicateContact(namesInList, existingName)==1);
    }


    //_________________________Change Profile Image-----------------------------

    @And("user clicks on {string} contact")
    public void userClicksOnContact(String name) {

        for (WebElement each : contactsPage.contactsList) {

            //System.out.println(each.getText());

            if (each.getText().contains(name)){

                //System.out.println(each.getText());// be sure it is the correct name

                // verify the element has been clicked
                BrowserUtils.waitForClickablility(each, 3).click();
                break;
            }

        }
    }

    @When("user clicks the image icon")
    public void user_clicks_the_image_icon() {

        //click the image icon

        contactsPage.image_Icon.click();
        BrowserUtils.sleep(1);

    }


    @And("user clicks choose from file button")
    public void userClicksChooseFromFileButton() {

        //click the choose from file button
        contactsPage.chooseFromFile.click();
        BrowserUtils.sleep(1);

    }
    @And("user chooses the image and clicks choose")
    public void userChoosesTheImageAndClicksChoose() {

        //click the image link
        contactsPage.image_Link.click();
        BrowserUtils.sleep(1);

        //click the choose button
        contactsPage.chooseButton.click();
    }

    @Then("user sees the image changed")
    public void userSeesTheImageChanged() {

        Assert.assertTrue("Image WebElement should be visible on the page",
                contactsPage.image_exist.isDisplayed());

    }
    //---------------------Delete a contact--------------------------------

    @When("User clicks the menu button")
    public void user_clicks_the_menu_button() {

        contactsPage.actionsMenuButton.click();

    }
    @When("user clicks the delete button")
    public void user_clicks_the_delete_button() {

        contactsPage.deleteButton.click();
        BrowserUtils.sleep(3);
    }
    @Then("user shouldn't see {string} in the list")
    public void user_shouldn_t_see_in_the_list(String name) {

        for (WebElement each : contactsPage.contactsList) {
            Assert.assertFalse("Contact list should not contain: " + name, each.getText().contains(name));
        }
    }



}

