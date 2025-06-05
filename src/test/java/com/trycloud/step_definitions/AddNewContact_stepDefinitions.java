package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.ContactsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewContact_stepDefinitions {

    ContactsPage contactsPage = new ContactsPage();
    BasePage basePage = new BasePage();

    @When("user clicks the Contacts Tab")
    public void user_clicks_the_contacts_tab() {

        basePage.contactsTab.click();
    }
    @When("user clicks the New contact button")
    public void user_clicks_the_new_contact_button() {

    }
    @When("user write the {string} of New Contact")
    public void user_write_the_of_new_contact(String string) {

    }
    @Then("user can see the {string} in the All contacts list")
    public void user_can_see_the_in_the_all_contacts_list(String string) {

    }



}
