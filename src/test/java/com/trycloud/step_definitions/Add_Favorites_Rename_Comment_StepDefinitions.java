package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Add_Favorites_Rename_Comment_StepDefinitions {

    FilesPage filesModulePage = new FilesPage();

    @When("user clicks on three dots menu in the file")
    public void user_clicks_on_three_dots_menu_in_the_file() {
        filesModulePage.fileThreeDots.click();
    }
    @Then("user can click on the menu option Add to favorites")
    public void user_can_click_on_the_menu_option_add_to_favorites() {
        filesModulePage.addFavoriteButton.click();
    }
    @Then("click to favorites folder to check new added file is displayed")
    public void click_to_favorites_folder_to_check_new_added_file_is_displayed() {
        filesModulePage.favoritesFolder.click();
        BrowserUtils.sleep(2);
        filesModulePage.fileNameBox.isDisplayed();
        filesModulePage.threeDotsInFavorites.click();
        filesModulePage.addFavoriteButton.click();
    }

    @Then("user can click on the menu option to Rename")
    public void user_can_click_on_the_menu_option_to_rename() {
        filesModulePage.renameButton.click();
    }

    @When("user can Rename any file")
    public void user_can_rename_any_file() {
        Driver.getDriver().switchTo().activeElement().sendKeys(ConfigurationReader.getProperty("newNameInput") + Keys.ENTER);
        BrowserUtils.sleep(2);
    }

    @Then("user should be able to see renamed file")
    public void user_should_be_able_to_see_renamed_file() {
        String expectedText = ConfigurationReader.getProperty("newNameInput");
        String actualText = filesModulePage.fileNameInputBox.getText();
        BrowserUtils.sleep(2);

        Assert.assertEquals(expectedText, actualText);
    }

    @Then("user can click on the menu option to Details")
    public void user_can_click_on_the_menu_option_to_details() {
       filesModulePage.detailsButton.click();
    }

    @Then("user can click on the Comments")
    public void user_can_click_on_the_comments() {
        filesModulePage.commentButton.click();
    }

    @Then("user can leave any comment in the comments input box")
    public void user_can_leave_any_comment_in_the_comments_input_box() {
        filesModulePage.commentInputBox.sendKeys(ConfigurationReader.getProperty("comment"));
    }

    @Then("user can click to post button")
    public void user_can_click_to_post_button() {
        filesModulePage.commentSubmitButton.click();
    }

    @Then("user clicks to three dots menu by the persons name")
    public void user_clicks_to_three_dots_menu_by_the_persons_name() {
        filesModulePage.threeDotsInComments.click();
    }

    @Then("user can choose from menu option Delete comment")
    public void user_can_choose_from_menu_option_delete_comment() {
        filesModulePage.deleteButtonInComments.click();
    }

    @Then("user can verify that comment is deleted")
    public void user_can_verify_that_comment_is_deleted() {
        filesModulePage.noComments.isDisplayed();
    }


    @When("user navigate to files module")
    public void userNavigateToFilesModule() {
        filesModulePage.filesModuleButton.click();
    }

    @Then("user verify files module page is displayed")
    public void userVerifyFilesModulePageIsDisplayed() {
        filesModulePage.allFilesSelection.isDisplayed();

    }
}
