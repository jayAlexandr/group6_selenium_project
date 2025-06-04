package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class UploadEditDeleteFile_StepDefinitions {

    FilesPage filesModulePage = new FilesPage();

    //==========Acceptance Criteria 1 User can upload a file==========

    @When("user navigate to files module")
    public void user_navigate_to_files_module() {
        filesModulePage.filesModuleButton.click();

    }
    @Then("user verify files module page is displayed")
    public void user_verify_files_module_page_is_displayed() {
        filesModulePage.allFilesSelection.isDisplayed();

    }
    @When("user click on the plus button")
    public void user_click_on_the_button() {
        filesModulePage.plusButton.click();
        BrowserUtils.waitFor(1);

    }
    @When("user upload 1MB.txt file from the computer")
    public void user_upload_1MB_txt_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/1mb-examplefile.txt";
        filesModulePage.uploadFileButton.sendKeys(filePath);

    }
    @Then("user verify that uploaded 1MB.text file is visible under the item list")
    public void user_verify_that_uploaded_1MB_text_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.test1MBFile.isDisplayed());
    }

    @When("user upload 2MB.jpg file from the computer")
    public void user_upload_2mb_jpg_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/2mb-jpg-test-file.jpg";
        filesModulePage.uploadFileButton.sendKeys(filePath);

    }
    @Then("user verify that uploaded 2MB.jpg file is visible under the item list")
    public void user_verify_that_uploaded_2mb_jpg_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.test2MBFile.isDisplayed());
    }

    @When("user upload 3MB.pdf file from the computer")
    public void user_upload_3mb_pdf_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/3-mb-sample-pdf-file.pdf";
        filesModulePage.uploadFileButton.sendKeys(filePath);

    }
    @Then("user verify that uploaded 3MB.pdf file is visible under the item list")
    public void user_verify_that_uploaded_3mb_pdf_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.test3MBFile.isDisplayed());
    }

    @When("user upload 4MB.png file from the computer")
    public void user_upload_4mb_png_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/4mb.png";
        filesModulePage.uploadFileButton.sendKeys(filePath);
    }
    @Then("user verify that uploaded 4MB.png file is visible under the item list")
    public void user_verify_that_uploaded_4mb_png_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.test4MBFile.isDisplayed());
    }

    @When("user upload 5MB.docx file from the computer")
    public void user_upload_5mb_docx_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/5mb.docx";
        filesModulePage.uploadFileButton.sendKeys(filePath);
    }
    @Then("user verify that uploaded 5MB.docx file is visible under the item list")
    public void user_verify_that_uploaded_5mb_docx_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.test5MBFile.isDisplayed());
    }

    @When("user upload 6MB.mp4 file from the computer")
    public void user_upload_6mb_mp4_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/6mb-example-video-file.mp4";
        filesModulePage.uploadFileButton.sendKeys(filePath);
    }
    @Then("user verify that uploaded 6MB.mp4 file is visible under the item list")
    public void user_verify_that_uploaded_6mb_mp4_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.test6MBFile.isDisplayed());
    }

    @When("user upload 7MB.zip file from the computer")
    public void user_upload_7mb_zip_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/7mb.zip";
        filesModulePage.uploadFileButton.sendKeys(filePath);

    }
    @Then("user verify that uploaded 7MB.zip file is visible under the item list")
    public void user_verify_that_uploaded_7mb_zip_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.test7MBFile.isDisplayed());
    }

    @When("user upload 8MB.rar file from the computer")
    public void user_upload_8mb_rar_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/8mb.rar";
        filesModulePage.uploadFileButton.sendKeys(filePath);

    }
    @Then("user verify that uploaded 8MB.rar file is visible under the item list")
    public void user_verify_that_uploaded_8mb_rar_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.test8MBFile.isDisplayed());
    }

    @When("user upload 9MB.iso file from the computer")
    public void user_upload_9mb_iso_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/9mb.iso";
        filesModulePage.uploadFileButton.sendKeys(filePath);

    }
    @Then("user verify that uploaded 9MB.iso file is visible under the item list")
    public void user_verify_that_uploaded_9mb_iso_file_is_visible_under_the_item_list() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.test9MBFile.isDisplayed());
    }

    @When("user upload 10MB file from the computer")
    public void user_upload_10mb_file_from_the_computer() {
        String filePath = "/Users/nikolaj/Desktop/testFiles/10mb-example-jpg.jpg";
        filesModulePage.uploadFileButton.sendKeys(filePath);

    }
    @Then("user verify that error message is displayed")
    public void user_verify_that_error_message_is_displayed() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(filesModulePage.errorMessage.isDisplayed());
    }

    @When("user upload multiple two or more files from the computer")
    public void user_upload_multiple_two_or_more_files_from_the_computer() {
        String filePath1 = "/Users/nikolaj/Desktop/testFiles/textFile1.txt";
        String filePath2 = "/Users/nikolaj/Desktop/testFiles/textFile2.txt";
        filesModulePage.uploadFileButton.sendKeys(filePath1);
        filesModulePage.uploadFileButton.sendKeys(filePath2);

    }
    @Then("user verify that uploaded multiple files are visible under the item list")
    public void user_verify_that_uploaded_multiple_files_are_visible_under_the_item_list() {
        Assert.assertTrue(filesModulePage.testTextFile1.isDisplayed());
        Assert.assertTrue(filesModulePage.testTextFile2.isDisplayed());
    }

    @When("user upload a duplicate file from the computer")
    public void user_upload_a_duplicate_file_from_the_computer() {
        String filePath1 = "/Users/nikolaj/Desktop/testFiles/textFile1.txt";
        filesModulePage.uploadFileButton.sendKeys(filePath1);
    }
    @Then("User verify that warning message is displayed")
    public void user_verify_that_warning_message_is_displayed() {
        Assert.assertTrue(filesModulePage.warningMessage.isDisplayed());
    }

    //==========Acceptance Criteria 2 User can create a new folder==========

    @When("user click on the New folder in submenu")
    public void user_click_on_the_new_folder_in_submenu() {
        filesModulePage.newFolderButton.click();
    }
    @When("user enter New folder name")
    public void user_enter_new_folder_name() {
        filesModulePage.newFolderNameInput.sendKeys("Test folder");
    }
    @When("user click on arrow button")
    public void user_click_on_arrow_button() {
        filesModulePage.arrowButtonNewFolder.click();
    }
    @Then("user verify that created New folder is displayed under the item list")
    public void user_verify_that_created_new_folder_is_displayed_under_the_item_list() {
        Assert.assertTrue(filesModulePage.testFolder.isDisplayed());
    }

    @When("user enter New folder name and press Enter key")
    public void user_enter_new_folder_name_and_press_enter_key() {
        filesModulePage.newFolderNameInput.sendKeys("Test folder" + Keys.ENTER);
    }

}
