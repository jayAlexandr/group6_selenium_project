package com.trycloud.step_definitions;

import com.trycloud.pages.FilesModulePage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadEditDeleteFile_StepDefinitions {

    FilesModulePage filesModulePage = new FilesModulePage();

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

    }
    @When("user click on the upload file option in submenu")
    public void user_click_on_the_upload_file_option_in_submenu() {

    }
    @When("user selects a valid file from the computer")
    public void user_selects_a_valid_file_from_the_computer() {

    }
    @Then("user verify that selected file is uploaded")
    public void user_verify_that_selected_file_is_uploaded() {

    }
    @Then("user verify that uploaded file is visible under the item list")
    public void user_verify_that_uploaded_file_is_visible_under_the_item_list() {

    }
}
