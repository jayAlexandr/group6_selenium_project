package com.trycloud.step_definitions;

import com.trycloud.pages.ContactsPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Folder_View_Functionality {

    FilesPage filesPage = new FilesPage();
    ContactsPage contactsPage = new ContactsPage();

    //------------------------Order By Name-------------------------------------

    @When("user clicks the order name Icon")
    public void user_clicks_the_order_name_icon() {

        BrowserUtils.sleep(2);
        filesPage.nameOrder_Icon.click();
        BrowserUtils.sleep(1);
        filesPage.nameOrder_Icon.click();

    }

    @Then("user see the the list in alphabetical order")
    public void userSeeTheTheListInAlphabeticalOrder() {

        // Actual lists of folders and files
        List<String> folders = contactsPage.
                webeElementList_To_StringList(filesPage.folderRows);
        //System.out.println(folders);

       /* List<String> files = contactsPage.
                webeElementList_To_StringList(filesPage.fileRows);*/

        //Creat copies of both lists and sort them
        List<String> folders_Sorted = new ArrayList<>(folders);

        //List<String> files_Sorted = new ArrayList<>(files);
        //System.out.println(folders_Sorted);

        Collections.sort(folders_Sorted);
        //Collections.sort(files_Sorted);

        //Assert the lists are sorted

        Assert.assertEquals("List is not in alphabetical order!", folders, folders_Sorted);
        //Assert.assertEquals("List is not in alphabetical order!", files,files_Sorted);


    }

    //----------------------Order By Size-----------------------------

    @When("user clicks the size Button")
    public void userClicksTheSizeButton() {
        // descending
        BrowserUtils.sleep(1);
        filesPage.SizeOrder_Icon.click();

        //Ascending
        BrowserUtils.sleep(1);
        filesPage.SizeOrder_Icon.click();

    }


    @Then("user sees the list in order")
    public void userSeesTheListInOrder() {

        List<Long> sizes = new ArrayList<>();

        for (WebElement each : filesPage.allFileList_size) {

            String each_string = each.getText().trim();
            sizes.add(filesPage.convertToKB(each_string));

        }

        //Creat a copy of the list of sizes and sort it
        List<Long> expectedSizes = new ArrayList<>(sizes);

        Collections.sort(expectedSizes);

        Assert.assertEquals("The sizes are not in order", sizes,
                expectedSizes);

    }

    //-------------------By Modified Date------------------------------

    @When("user clicks the modified Module")
    public void userClicksTheModifiedModule() {

        BrowserUtils.sleep(1);
        //filesPage.modified_button.click();
        BrowserUtils.waitFor(2);
    }

    @Then("user see the list of modified in time order")
    public void userSeeTheListInModifiedTimeOrder() {
        List<Long> modified_time = new ArrayList<>();

        for (WebElement each : filesPage.allFileList_Modified) {

            if (!each.getText().trim().equals("")){

                System.out.println(each.getText());
                String each_string = each.getText().trim();
                modified_time.add(filesPage.convertToSeconds(each_string));
            }
        }

        //Creat a copy of the list of times and sort it
        List<Long> expectedTimes = new ArrayList<>(modified_time);

        Collections.sort(expectedTimes);

        Assert.assertEquals("The times are not in order",
                expectedTimes, modified_time);

    }



}
