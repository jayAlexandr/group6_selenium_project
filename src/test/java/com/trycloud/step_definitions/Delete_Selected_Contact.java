package com.trycloud.step_definitions;

import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Delete_Selected_Contact {

    ContactsPage pageOfContacts = new ContactsPage();

    @When("User clicks the menu button")
    public void user_clicks_the_menu_button() {

        pageOfContacts.actionsMenuButton.click();

    }
    @When("user clicks the delete button")
    public void user_clicks_the_delete_button() {

        pageOfContacts.deleteButton.click();
        BrowserUtils.sleep(3);
    }
    @Then("user shouldn't see {string} in the list")
    public void user_shouldn_t_see_in_the_list(String name) {

        for (WebElement each : pageOfContacts.contactsList) {
            Assert.assertFalse("Contact list should not contain: " + name, each.getText().contains(name));
        }
    }

}
