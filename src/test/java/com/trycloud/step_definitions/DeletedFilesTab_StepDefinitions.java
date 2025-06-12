package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeletedFilesTab_StepDefinitions {

    FilesPage filesPage = new FilesPage();

//=====AC1 - User can see the most recent deleted file in the first line
//of the deleted file list when deleted files are ordered by newest to oldest=====

    @Then("user verifies Deleted Files Tab is displayed")
    public void user_verifies_deleted_files_tab_is_displayed() {
        filesPage.deletedFilesTab.isDisplayed();
    }

    @When("user clicks on all files tab")
    public void user_clicks_on_all_files_tab() {
        filesPage.allFilesSelection.click();
    }

    @When("user clicks on Deleted sort button")
    public void user_clicks_on_deleted_sort_button() {
        BrowserUtils.sleep(2);
        BrowserUtils.clickWithJS(filesPage.sortByDateButton);
        BrowserUtils.clickWithJS(filesPage.sortByDateButton);
        BrowserUtils.sleep(2);
    }

    @Then("user verifies last deleted file {string} in the first line")
    public void user_verifies_last_deleted_file_in_the_first_line(String fileName) {
        BrowserUtils.sleep(2);
        Assert.assertTrue(fileName.contains(filesPage.firstLineOfTheDeletedFileList.getText()));
    }

//=========AC2 - User can order the all deleted files by newest to oldest or vice versa===========

    @Then("user verifies all deleted files ordered by oldest to newest")
    public void deleted_files_ordered_by_oldest_to_newest() {
        Assert.assertTrue("Files are not sorted from oldest to newest",
                filesPage.filesSortedByOldestToNewest(filesPage.listOfFileDates));
    }

    @Then("user verifies all deleted files ordered by newest to oldest")
    public void deleted_files_ordered_by_newest_to_oldest() {
        Assert.assertTrue("Files are not sorted from newest to oldest",
                filesPage.filesSortedByNewestToOldest(filesPage.listOfFileDates));
    }

//=======AC3 - User can order alphabetically all the deleted files based on their names============

    @When("user clicks on Name sort button")
    public void user_clicks_on_name_sort_button() {
        BrowserUtils.sleep(2);
        BrowserUtils.clickWithJS(filesPage.sortByNameButton);
        BrowserUtils.sleep(2);
    }

    @Then("user verifies all deleted files ordered alphabetically")
    public void deleted_files_ordered_alphabetically() {
        Assert.assertTrue("File names are not sorted alphabetically",
                filesPage.fileNamesSortedAlphabetically(filesPage.listOfFileNames));
    }

    @Then("user verifies all deleted files ordered reverse alphabetically")
    public void deleted_files_ordered_reverse_alphabetically() {
        Assert.assertTrue("File names are not sorted in reverse alphabetical order",
                filesPage.fileNamesSortedInReverseAlphabeticalOrder(filesPage.listOfFileNames));
    }

//======AC4 - User can delete any deleted file permanently by using the three dots icon in the file’s line

    @When("user clicks on {string} Three Dot menu in Deleted item list")
    public void user_clicks_on_three_dot_menu_in_deleted_item_list(String fileName) {
        filesPage.getThreeDotMenuDeleted(fileName).click();
    }

    @When("user clicks on Delete permanently")
    public void user_clicks_on_delete_permanently() {
        filesPage.deletePermanentlyThreeDotButton.click();
    }

    @Then("user verifies {string} file is deleted permanently")
    public void user_verifies_file_is_deleted_permanently(String fileName) {
        BrowserUtils.sleep(2);
        Assert.assertTrue("File '" + fileName + "' is still present in the list!",
                filesPage.fileNameNotPresent(fileName, filesPage.listOfFileNames));
    }

    @When("user marks CheckBoxes {string} and {string} of deleted items")
    public void user_marks_check_boxes_of_deleted_items(String fileName1, String fileName2) {
        filesPage.getCheckBoxDeleted(fileName1).click();
        filesPage.getCheckBoxDeleted(fileName2).click();
    }

    @When("user clicks on Actions button in Deleted files tab")
    public void user_clicks_on_actions_button_in_deleted_files_tab() {
        filesPage.actionsButtonInDeleted.click();
    }

    @When("user clicks on {string} Restore button")
    public void user_clicks_on_restore_button(String fileName) {
        filesPage.getRestoreButton(fileName).click();
    }

    @When("user clicks Restore action")
    public void user_clicks_restore() {
        filesPage.restoreActions.click();
    }

    @When("user clicks on Delete permanently action")
    public void user_clicks_on_delete_permanently_action() {
        filesPage.deletePermanentlyActions.click();
    }
}