package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Create_changeImage_Delete_Contact {

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


    @Then("user clicks choose from file button")
    public void userClicksChooseFromFileButton() {

        //click the choose from file button
        contactsPage.chooseFromFile.click();
        BrowserUtils.sleep(1);

        //click the image link
        contactsPage.image_Link.click();
        BrowserUtils.sleep(1);

        //click the choose button
        contactsPage.chooseButton.click();

    }

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

