package com.trycloud.step_definitions;

import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Add_Contact_To_Group {

    ContactsPage pageOfContacts = new ContactsPage();

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
