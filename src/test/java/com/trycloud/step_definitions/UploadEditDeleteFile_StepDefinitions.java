package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class UploadEditDeleteFile_StepDefinitions {

    FilesPage filesPage = new FilesPage();

    //==========Acceptance Criteria 1 User can upload a file==========

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

    @When("user upload 1MB.txt file from the computer")
    public void user_upload_1MB_txt_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/1mb-examplefile.txt";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify uploaded 1MB.text file is visible under the item list")
    public void user_verify_uploaded_1MB_text_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.test1MBFile.isDisplayed());
    }

    @When("user upload 2MB.jpg file from the computer")
    public void user_upload_2mb_jpg_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/2mb-jpg-test-file.jpg";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify uploaded 2MB.jpg file is visible under the item list")
    public void user_verify_uploaded_2mb_jpg_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.test2MBFile.isDisplayed());
    }

    @When("user upload 3MB.pdf file from the computer")
    public void user_upload_3mb_pdf_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/3-mb-sample-pdf-file.pdf";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify uploaded 3MB.pdf file is visible under the item list")
    public void user_verify_uploaded_3mb_pdf_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.test3MBFile.isDisplayed());
    }

    @When("user upload 4MB.png file from the computer")
    public void user_upload_4mb_png_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/4mb.png";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify uploaded 4MB.png file is visible under the item list")
    public void user_verify_uploaded_4mb_png_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.test4MBFile.isDisplayed());
    }

    @When("user upload 5MB.docx file from the computer")
    public void user_upload_5mb_docx_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/5mb.docx";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify uploaded 5MB.docx file is visible under the item list")
    public void user_verify_uploaded_5mb_docx_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.test5MBFile.isDisplayed());
    }

    @When("user upload 6MB.mp4 file from the computer")
    public void user_upload_6mb_mp4_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/6mb-example-video-file.mp4";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify uploaded 6MB.mp4 file is visible under the item list")
    public void user_verify_uploaded_6mb_mp4_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.test6MBFile.isDisplayed());
    }

    @When("user upload 7MB.zip file from the computer")
    public void user_upload_7mb_zip_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/7mb.zip";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify uploaded 7MB.zip file is visible under the item list")
    public void user_verify_uploaded_7mb_zip_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.test7MBFile.isDisplayed());
    }

    @When("user upload 8MB.rar file from the computer")
    public void user_upload_8mb_rar_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/8mb.rar";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify uploaded 8MB.rar file is visible under the item list")
    public void user_verify_uploaded_8mb_rar_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.test8MBFile.isDisplayed());
    }

    @When("user upload 9MB.iso file from the computer")
    public void user_upload_9mb_iso_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/9mb.iso";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify uploaded 9MB.iso file is visible under the item list")
    public void user_verify_uploaded_9mb_iso_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.test9MBFile.isDisplayed());
    }

    @When("user upload 10MB file from the computer")
    public void user_upload_10mb_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/10mb-example-jpg.jpg";
        filesPage.uploadFileButton.sendKeys(filePath);
    }

    @Then("user verify error message {string} is displayed")
    public void user_verify_error_message_is_displayed(String expectMessage) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesPage.errorMessage.getText().contains(expectMessage));
    }

    @When("user upload multiple two or more files from the computer")
    public void user_upload_multiple_two_or_more_files_from_the_computer() {
        String filePath1 = "/Users/nikolaj/Desktop/testFiles/textFile1.txt";
        String filePath2 = "/Users/nikolaj/Desktop/testFiles/textFile2.txt";
        filesPage.uploadFileButton.sendKeys(filePath1);
        filesPage.uploadFileButton.sendKeys(filePath2);

    }
    @Then("user verify uploaded multiple files are visible under the item list")
    public void user_verify_uploaded_multiple_files_are_visible_under_the_item_list() {
        Assert.assertTrue(filesPage.testTextFile1.isDisplayed());
        Assert.assertTrue(filesPage.testTextFile2.isDisplayed());
    }

    @When("user upload a duplicate file from the computer")
    public void user_upload_a_duplicate_file_from_the_computer() {
        String filePath1 = "/Users/nikolaj/Desktop/testFiles/textFile1.txt";
        filesPage.uploadFileButton.sendKeys(filePath1);
    }

    @Then("user verify popup window with warning message is displayed")
    public void user_verify_popup_window_with_warning_message_is_displayed() {
        Assert.assertTrue(filesPage.warningMessage.isDisplayed());
    }

    //==========Acceptance Criteria 2 User can create a new folder==========

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
        Assert.assertTrue(filesPage.testFolder.isDisplayed());
    }

    @When("user enter New folder name and press Enter key")
    public void user_enter_new_folder_name_and_press_enter_key() {
        filesPage.newFolderNameInput.sendKeys("Test folder" + Keys.ENTER);
    }

    @Then("user verify warning message {string} is displayed")
    public void user_verify_warning_message_is_displayed(String expectedMessage) {
        Assert.assertTrue(filesPage.folderExistMessage.getText().contains(expectedMessage));
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
        Assert.assertTrue(filesPage.testSpecChar.isDisplayed());
    }

    @When("user enter New folder name with Backslash and press Enter key")
    public void user_enter_new_folder_name_with_backslash_and_press_enter_key() {
        filesPage.newFolderNameInput.sendKeys("Test Folder\\" + Keys.ENTER);
    }

    @When("user enter New folder name with Forward Slash and press Enter key")
    public void user_enter_new_folder_name_with_forward_slash_and_press_enter_key() {
        filesPage.newFolderNameInput.sendKeys("Test Folder/" + Keys.ENTER);
    }


}
