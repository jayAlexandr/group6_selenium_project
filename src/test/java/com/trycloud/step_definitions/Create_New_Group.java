package com.trycloud.step_definitions;

import com.trycloud.pages.ContactsPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

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



}
