package com.trycloud.step_definitions;

import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Create_New_Group {

    ContactsPage pageOfContacts = new ContactsPage();

    @When("user clicks the create group icon")
    public void user_clicks_the_create_group_icon() {

        pageOfContacts.CreateNewGroup_icon.click();

    }
    @When("user enters {string}")
    public void user_enters(String name) {

        pageOfContacts.addGroupName_box.sendKeys(name + Keys.ENTER);
    }

    @When("user clicks Groups Button and add the contact to {string}")
    public void user_clicks_groups_button_and_add_the_contact_to(String groupName) {

        // Click the Group button
        pageOfContacts.Group_button.click();

        //click the group name you want to add
        for (WebElement option : pageOfContacts.listOfGroups_Options) {

            if (option.getAttribute("title").equals(groupName)){

                option.click();
            }
        }

        BrowserUtils.sleep(2);
    }

    @Then("user should see the same lists in both options and first column")
    public void userShouldSeeTheSameListsInBothOptionsAndFirstColumn() {

        //Verify if the list shown is the same as in the first column
        Assert.assertTrue("The list is the same",
                pageOfContacts.webeElementList_To_StringList(pageOfContacts.
                        listOfGroups_Options).equals(pageOfContacts.listGroups_In_FirstColumn()));



    }



}
