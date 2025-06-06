package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class UploadEditDeleteFile_StepDefinitions {

    FilesPage filesPage = new FilesPage();

    //===============Acceptance Criteria 1 - User can upload a file==================

    @When("user navigate to files module")
    public void user_navigate_to_files_module() {
        filesPage.filesModuleButton.click();
    }

    @Then("user verify files module page is displayed")
    public void user_verify_files_module_page_is_displayed() {
        filesPage.allFilesSelection.isDisplayed();
    }

    @When("user click on the plus button")
    public void user_click_on_the_button() {
        filesPage.plusButton.click();
        BrowserUtils.waitFor(1);
    }

    @When("user upload {string} file from the computer")
    public void user_upload_file_from_the_computer(String file) {
        filesPage.uploadFileButton.sendKeys(ConfigurationReader.getProperty(file));
    }

    @Then("user verify uploaded 1MB.text file is visible under the item list")
    public void user_verify_uploaded_1MB_text_file_is_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.test1MBFile);
    }

    @Then("user verify uploaded 2MB.jpg file is visible under the item list")
    public void user_verify_uploaded_2mb_jpg_file_is_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.test2MBFile);
    }

    @Then("user verify uploaded 3MB.pdf file is visible under the item list")
    public void user_verify_uploaded_3mb_pdf_file_is_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.test3MBFile);
    }

    @Then("user verify uploaded 4MB.png file is visible under the item list")
    public void user_verify_uploaded_4mb_png_file_is_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.test4MBFile);
    }

    @Then("user verify uploaded 5MB.docx file is visible under the item list")
    public void user_verify_uploaded_5mb_docx_file_is_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.test5MBFile);
    }

    @Then("user verify uploaded 6MB.mp4 file is visible under the item list")
    public void user_verify_uploaded_6mb_mp4_file_is_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.test6MBFile);
    }

    @Then("user verify uploaded 7MB.zip file is visible under the item list")
    public void user_verify_uploaded_7mb_zip_file_is_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.test7MBFile);
    }

    @Then("user verify uploaded 8MB.rar file is visible under the item list")
    public void user_verify_uploaded_8mb_rar_file_is_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.test8MBFile);
    }

    @Then("user verify uploaded 9MB.iso file is visible under the item list")
    public void user_verify_uploaded_9mb_iso_file_is_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.test9MBFile);
    }

    @Then("user verify message {string} is displayed")
    public void user_verify_message_is_displayed(String expectedMessage) {
        filesPage.messageIsDisplayed(filesPage.errorMessage, expectedMessage);
    }

    @When("user upload {string} and {string} files from the computer")
    public void user_upload_and_files_from_the_computer(String file1, String file2) {
        filesPage.uploadFileButton.sendKeys(ConfigurationReader.getProperty(file1));
        filesPage.uploadFileButton.sendKeys(ConfigurationReader.getProperty(file2));

    }
    @Then("user verify uploaded multiple files are visible under the item list")
    public void user_verify_uploaded_multiple_files_are_visible_under_the_item_list() {
        filesPage.itemIsDisplayed(filesPage.testTextFile1);
        filesPage.itemIsDisplayed(filesPage.testTextFile2);
    }

    @Then("user verify popup window with warning message is displayed")
    public void user_verify_popup_window_with_warning_message_is_displayed() {
        filesPage.itemIsDisplayed(filesPage.warningMessage);
    }

    //===============Acceptance Criteria 2 - User can create a new folder==================

    @When("user click on the New folder in submenu")
    public void user_click_on_the_new_folder_in_submenu() {
        filesPage.newFolderButton.click();
    }

    @When("user enter New folder name")
    public void user_enter_new_folder_name() {
        filesPage.newFolderNameInput.sendKeys("Test folder");
    }

    @When("user click on arrow button")
    public void user_click_on_arrow_button() {
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

    //Acceptance Criteria 3 - User can move or copy any selected item to any folder and see the
    //                        item in the selected folder

    @When("user click on ThreeDot menu alongside an item which want to move")
    public void user_click_on_three_dot_menu_alongside_an_item_which_want_to_move() {
        filesPage.threeDotMenuTF1.click();
    }

    @When("user click on MoveOrCopy")
    public void user_click_on_MoveOrCopy() {
        filesPage.moveOrCopyButton.click();
    }

    @When("user click on selected folder")
    public void user_click_on_selected_folder() {
        filesPage.ocTestFolder.click();
    }

    @When("user click on MoveTo button")
    public void user_click_on_move_to_button() {
        filesPage.ocMoveTo.click();

    }
    @Then("user navigate to selected folder and verify item is displayed")
    public void user_to_selected_folder_and_verify_item_is_displayed() {
        filesPage.testFolder.click();
        filesPage.itemIsDisplayed(filesPage.testTextFile1);
    }

    @When("user click on ThreeDot menu alongside an item which want to copy")
    public void user_click_on_three_dot_menu_alongside_an_item_which_want_to_copy() {
        filesPage.threeDotMenu7MB.click();
    }

    @When("user click on CopyTo button")
    public void user_click_on_copy_to_button() {
        filesPage.ocCopyTo.click();
    }

    @When("user click on ThreeDot menu alongside an existing item which want to move")
    public void user_click_on_three_dot_menu_alongside_an_existing_item_which_want_to_move() {
        filesPage.threeDotMenu7MB.click();
    }

    @When("user click on ThreeDot menu alongside an existing item which want to copy")
    public void user_click_on_three_dot_menu_alongside_an_existing_item_which_want_to_copy() {
        filesPage.threeDotMenu7MB.click();
    }

    @When("user marks CheckBoxes of items which wants to move")
    public void user_marks_check_boxes_of_items_which_wants_to_move() {
        filesPage.itemCheckBoxTF2.click();
        filesPage.itemCheckBox1MB.click();
    }

    @When("user click on Actions button")
    public void user_click_on_actions_button() {
        filesPage.actionsButton.click();
    }

    @When("user click on MoveOrCopy button")
    public void user_click_on_move_or_copy_button() {
        filesPage.moveOrCopyActions.click();
    }

    @Then("user navigate to selected folder and verify moved items are displayed")
    public void user_navigate_to_selected_folder_and_verify_items_are_displayed() {
        filesPage.testFolder.click();
        filesPage.itemIsDisplayed(filesPage.testTextFile2);
        filesPage.itemIsDisplayed(filesPage.test1MBFile);
    }

    @When("user marks CheckBoxes of items which wants to copy")
    public void user_marks_check_boxes_of_items_which_wants_to_copy() {
        filesPage.itemCheckBox8MB.click();
        filesPage.itemCheckBox9MB.click();
    }

    @Then("user navigate to selected folder and verify copied items are displayed")
    public void user_navigate_to_selected_folder_and_verify_copied_items_are_displayed() {
        filesPage.testFolder.click();
        filesPage.itemIsDisplayed(filesPage.test8MBFile);
        filesPage.itemIsDisplayed(filesPage.test9MBFile);
    }

    //=====Acceptance Criteria 4 - User can delete any selected item from its three dots menu=====

    @When("user click on ThreeDot menu alongside an item which want to delete")
    public void user_click_on_three_dot_menu_alongside_an_item_which_want_to_delete() {
        filesPage.threeDotMenu7MB.click();
    }

    @When("user click on DeleteFile")
    public void user_click_on_delete_file() {
        filesPage.deleteFileButton.click();
    }

    @When("user navigate to Deleted files")
    public void user_navigate_to_deleted_files() {
        filesPage.deletedFilesSelection.click();
    }

    @Then("user verify deleted item is displayed under the deleted item list")
    public void user_verify_deleted_item_is_displayed_under_the_deleted_item_list() {
        filesPage.itemIsDisplayed(filesPage.test7MBFile);
    }

    @When("user marks CheckBoxes of items which wants to delete")
    public void user_marks_check_boxes_of_items_which_wants_to_delete() {
        filesPage.itemCheckBox8MB.click();
        filesPage.itemCheckBox9MB.click();
    }

    @When("user click on Delete button")
    public void user_click_on_delete_button() {
        filesPage.deleteActions.click();
    }

    @Then("user verify deleted items is displayed under the deleted item list")
    public void user_verify_deleted_items_is_displayed_under_the_deleted_item_list() {
        filesPage.itemIsDisplayed(filesPage.test8MBFile);
        filesPage.itemIsDisplayed(filesPage.test9MBFile);
    }
}
