package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        filesModulePage.fileThreeDots.click();
        filesModulePage.renameButton.click();
        filesModulePage.fileNameInputBox.sendKeys("newName" + Keys.ENTER);
    }




}
