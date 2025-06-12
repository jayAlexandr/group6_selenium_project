package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class UploadEditDeleteFile_StepDefinitions {

    FilesPage filesPage = new FilesPage();

    //===================AC1 - User can upload a file===============================

    @When("user navigates to files module")
    public void user_navigates_to_files_module() {
        filesPage.filesModuleButton.click();
    }

    @Then("user verifies files module page is displayed")
    public void user_verifies_files_module_page_is_displayed() {
        filesPage.allFilesSelection.isDisplayed();
    }

    @When("user clicks on the plus button")
    public void user_clicks_on_the_button() {
        filesPage.plusButton.click();
        BrowserUtils.waitFor(1);
    }

    @When("user upload {string} file from the computer")
    public void uploadFile(String fileKey) {
        filesPage.uploadFileButton.sendKeys(System.getProperty("user.dir")
                + ConfigurationReader.getProperty(fileKey));
    }

    @Then("user verifies item {string} is visible under the item list")
    public void user_verifies_item_is_visible_under_the_item_list(String expectedFileName) {
        filesPage.verifyFileIsDisplayed(expectedFileName);
    }

    @Then("user verify message {string} is displayed")
    public void user_verify_message_is_displayed(String expectedMessage) {
        filesPage.messageIsDisplayed(filesPage.errorMessage, expectedMessage);
    }

    @When("user upload {string} and {string} files from the computer")
    public void user_upload_and_files_from_the_computer(String file1, String file2) {
        filesPage.uploadFileButton.sendKeys(System.getProperty("user.dir")
                + ConfigurationReader.getProperty(file1));
        filesPage.uploadFileButton.sendKeys(System.getProperty("user.dir")
                + ConfigurationReader.getProperty(file2));
    }

    @Then("user verify files {string} and {string} are displayed")
    public void user_verify_files_are_visible(String expectedFile1, String expectedFile2) {
        filesPage.verifyFileIsDisplayed(expectedFile1);
        filesPage.verifyFileIsDisplayed(expectedFile2);
    }

    @Then("user verify popup window with warning message is displayed")
    public void user_verify_popup_window_with_warning_message_is_displayed() {
        filesPage.itemIsDisplayed(filesPage.warningMessage);
    }

    //===================AC2 - User can create a new folder===============================

    @When("user clicks on the New folder in submenu")
    public void user_clicks_on_the_new_folder_in_submenu() {
        filesPage.newFolderButton.click();
    }

    @When("user enter {string} new folder name")
    public void user_enter_new_folder_name(String folderName) {
        filesPage.newFolderNameInput.sendKeys(folderName);
    }

    @When("user clicks on arrow button")
    public void user_clicks_on_arrow_button() {
        filesPage.arrowButtonNewFolder.click();
    }

    @Then("user verify created New folder is displayed under the item list")
    public void user_verify_created_new_folder_is_displayed_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.testFolder);
    }

    @When("user enter New folder name and press Enter key")
    public void user_enter_new_folder_name_and_press_enter_key() {
        filesPage.newFolderNameInput.sendKeys("Test folder" + Keys.ENTER);
    }

    @Then("user verify warning message {string} is displayed")
    public void user_verify_warning_message_is_displayed(String expectedMessage) {
        filesPage.messageIsDisplayed(filesPage.folderExistMessage, expectedMessage);
    }

    @When("user clear the input field and press Enter")
    public void user_clear_the_input_field_and_press_enter() {
        filesPage.newFolderNameInput.sendKeys(Keys.BACK_SPACE, Keys.ENTER);
    }

    @When("user enter New folder name with special characters and press Enter key")
    public void user_enter_new_folder_name_with_special_characters_and_press_enter_key() {
        filesPage.newFolderNameInput.sendKeys("~!@#$%^&*()_+-={}[]|,<>.?" + Keys.ENTER);
    }

    @Then("user verify New folder with specChar is displayed under the item list")
    public void user_verify_new_folder_with_spec_char_is_displayed_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.testSpecChar);
    }

    @When("user enter New folder name with Backslash and press Enter key")
    public void user_enter_new_folder_name_with_backslash_and_press_enter_key() {
        filesPage.newFolderNameInput.sendKeys("Test Folder\\" + Keys.ENTER);
    }

    @When("user enter New folder name with Forward Slash and press Enter key")
    public void user_enter_new_folder_name_with_forward_slash_and_press_enter_key() {
        filesPage.newFolderNameInput.sendKeys("Test Folder/" + Keys.ENTER);
    }

    //=====AC3 - User can move or copy any selected item to any folder and see the
    //           item in the selected folder======

    @When("user clicks on {string} Three Dot menu")
    public void user_clicks_on_three_dot_menu(String itemName) {
        filesPage.getThreeDotMenu(itemName).click();
    }

    @When("user clicks on MoveOrCopy")
    public void user_clicks_on_MoveOrCopy() {
        filesPage.moveOrCopyButton.click();
    }

    @When("user clicks on selected folder")
    public void user_clicks_on_selected_folder() {
        filesPage.ocTestFolder.click();
    }

    @When("user clicks on MoveTo button")
    public void user_clicks_on_move_to_button() {
        filesPage.ocMoveTo.click();

    }
    @Then("user navigates to selected folder and verify item is displayed")
    public void user_navigates_to_selected_folder_and_verify_item_is_displayed() {
        filesPage.testFolder.click();
        filesPage.itemIsDisplayed(filesPage.testTextFile1);
    }

    @When("user clicks on CopyTo button")
    public void user_clicks_on_copy_to_button() {
        filesPage.ocCopyTo.click();
    }

    @When("user marks CheckBoxes {string} and {string} of items")
    public void user_marks_check_boxes_of_items(String itemName1, String itemName2) {
        filesPage.getCheckBox(itemName1).click();
        filesPage.getCheckBox(itemName2).click();
    }

    @When("user clicks on Actions button")
    public void user_clicks_on_actions_button() {
        filesPage.actionsButton.click();
    }

    @When("user clicks on MoveOrCopy button")
    public void user_clicks_on_move_or_copy_button() {
        filesPage.moveOrCopyActions.click();
    }

    @Then("user navigates to selected folder and verify {string} and {string} are displayed")
    public void user_navigates_to_selected_folder_and_verify_items_are_displayed(String itemName1, String itemName2) {
        filesPage.testFolder.click();
        filesPage.verifyFileIsDisplayed(itemName1);
        filesPage.verifyFileIsDisplayed(itemName2);
    }

    //=========AC4 - User can delete any selected item from its three dots menu=================

    @When("user clicks on Delete File")
    public void user_clicks_on_delete_file() {
        filesPage.deleteFileButton.click();
    }

    @When("user navigates to Deleted files")
    public void user_navigates_to_deleted_files() {
        filesPage.deletedFilesSelection.click();
    }

    @Then("user verify deleted {string} file is displayed under the deleted item list")
    public void user_verify_deleted_file_is_displayed_under_the_deleted_item_list(String fileName) {
        filesPage.verifyFileIsDisplayed(fileName);
    }

    @When("user clicks on Delete button")
    public void user_clicks_on_delete_button() {
        filesPage.deleteActions.click();
    }

    @Then("user verify files {string} and {string} are displayed under the deleted item list")
    public void user_verify_files_are_displayed_under_the_deleted_item_list(String itemName1, String itemName2) {
        filesPage.verifyFileIsDisplayed(itemName1);
        filesPage.verifyFileIsDisplayed(itemName2);
    }

    //=====AC5 - User can see the total number of files and folders under the files list table=====

    @When("user navigates to the bottom of the item list")
    public void user_navigates_to_the_bottom_of_the_item_list() {
        BrowserUtils.scrollToElement(filesPage.filesCountTotal);
    }

    @Then("user verify the total number of items should be displayed correctly")
    public void the_total_number_of_items_should_be_displayed_correctly() {

        int actualFiles = filesPage.getActualFileCount();
        int expectedFiles = filesPage.getExpectedFileCount();
        Assert.assertEquals("Mismatch in file count!", expectedFiles, actualFiles);

        int actualFolders = filesPage.getActualFolderCount();
        int expectedFolders = filesPage.getExpectedFolderCount();
        Assert.assertEquals("Mismatch in folder count!", expectedFolders, actualFolders);
    }

    @When("user marks CheckBox of {string} file")
    public void user_marks_check_boxes_of_file(String itemName) {
        filesPage.getCheckBox(itemName).click();
    }
}