package com.trycloud.step_definitions;

import com.trycloud.pages.ContactsPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v133.browser.Browser;

import java.util.ArrayList;
import java.util.List;

public class Change_Profile_Picture_Using_ChooseFromFile {

    ContactsPage pageContact = new ContactsPage();

    @And("user clicks on {string} contact")
    public void userClicksOnContact(String name) {

        for (WebElement each : pageContact.contactsList) {

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

        pageContact.image_Icon.click();
        BrowserUtils.sleep(1);

    }


    @Then("user clicks choose from file button")
    public void userClicksChooseFromFileButton() {

                //click the choose from file button
                pageContact.chooseFromFile.click();
                BrowserUtils.sleep(1);

                //click the image link
                pageContact.image_Link.click();
                BrowserUtils.sleep(1);

                //click the choose button
                pageContact.chooseButton.click();

    }

}
