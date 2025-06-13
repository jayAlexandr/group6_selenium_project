package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Create_changeImage_Delete_Contact {

    ContactsPage contactsPage = new ContactsPage();
    BasePage basePage = new BasePage();

  //--------------Add New Contact-----------------------------------

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

    @And("user enters {string} of the new contact")
    public void userEntersOfTheNewContact(String fullName) {

        // enter the full name of the new contact
        contactsPage.newContactName_Box.clear();
        contactsPage.newContactName_Box.sendKeys(fullName);
    }

    @Then("user can see {string} in the All contacts list")
    public void userCanSeeInTheAllContactsList(String expectedName) {
        // click the all contacts button
        contactsPage.allContacts_Button.click();

        // Verify if the expected contact is in the list

        boolean isDisplayed = false;

        List<String> namesInList = contactsPage.
                webeElementList_To_StringList(contactsPage.contactsList);

        for (String each : namesInList) {

            if (each.equals(expectedName)){

                isDisplayed = true;
            }
        }

        Assert.assertTrue("contact is successfully added!",
                isDisplayed);

    }

    //_____________________________

    @And("user clicks on {string} contact")
    public void userClicksOnContact(String name) {

        for (WebElement each : contactsPage.contactsList) {

            //System.out.println(each.getText());

            if (each.getText().contains(name)){

                //System.out.println(each.getText());// be sure the correct name

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

