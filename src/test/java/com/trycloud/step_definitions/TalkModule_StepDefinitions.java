package com.trycloud.step_definitions;

import com.trycloud.pages.TalkModulePage;

import static com.trycloud.utilities.BrowserUtils.*;

import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class TalkModule_StepDefinitions {

    public TalkModulePage talkModulePage = new TalkModulePage();
    String deletedConversation = "";
    String groupName = "";

    @And("user navigates to the Talk module")
    public void user_navigates_to_the_talk_module() {
        talkModulePage.talkModuleButton.click();
    }

    @And("user is on the Talk page")
    public void user_is_on_the_talk_page() {
        verifyTitleContains("Talk");
    }

    @When("user clicks on the Create a new group conversation button")
    public void user_clicks_on_the_create_a_new_group_conversation_button() {
        talkModulePage.newConversationButton.click();
    }

    @And("user enters {string} in the input field")
    public void user_enters_in_the_input_field(String conversationName) {
        talkModulePage.newConversationInputBox.sendKeys(conversationName);
        waitFor(2);
    }

    @And("user clicks on Add participants")
    public void user_clicks_on_add_participants() {
        talkModulePage.addParticipantsButton.click();
        waitFor(2);
    }

    @And("user clicks on Create conversation")
    public void user_clicks_on_create_conversation() {
        talkModulePage.createConversationButton.click();
        waitFor(2);
    }

    @Then("the {string} should appear in the conversation list")
    public void the_should_appear_in_the_conversation_list(String expectedConversationName) {
        waitFor(2);
        boolean isFound = false;
        for (WebElement conversationGroup : talkModulePage.conversationList) {
            String actualName = conversationGroup.getText().trim();
            System.out.println("Actual conversation group name: " + actualName);
            System.out.println("Expected conversation group name: " + expectedConversationName);

            if (actualName.equals(expectedConversationName)) {
                isFound = true;
                break;
            }
        }
        Assert.assertTrue("Expected conversation group name was not found: " + expectedConversationName, isFound);
    }

    @When("user leaves the conversation name field blank")
    public void user_leaves_the_conversation_name_field_blank() {
        talkModulePage.newConversationInputBox.clear();
    }

    @And("the Add participants button should be disabled")
    public void the_add_participants_button_should_be_disabled() {
        boolean isDisabled = !talkModulePage.addParticipantsButton.isEnabled();
        Assert.assertTrue("Add participants button should be disabled", isDisabled);
    }

    @Then("the Create conversation button should be disabled")
    public void the_create_conversation_button_should_be_disabled() {
        Assert.assertFalse(talkModulePage.createConversationButton.isEnabled());
    }


    @When("user is in a conversation group")
    public void user_is_in_a_conversation_group() {
        List<WebElement> conversationGroups = talkModulePage.conversationList;
        Assert.assertFalse("Conversation list is empty", conversationGroups.isEmpty());
        WebElement randomGroup;
        do {
            randomGroup = conversationGroups.get(new Random().nextInt(conversationGroups.size()));
            groupName = randomGroup.getText().trim();
        } while (groupName.equals("Talk updates ✅"));

        System.out.println("Randomly selected conversation group: " + groupName);
        randomGroup.click();
        waitFor(3);
    }

    @And("user clicks on Add Participant")
    public void user_clicks_on_add_participant() {
        waitFor(1);
        talkModulePage.addParticipantInputBox.click();
    }

    @And("user types valid participant")
    public void user_types_valid_participant() {
        waitFor(1);
        talkModulePage.addParticipantInputBox.click();
        waitFor(1);
        talkModulePage.addParticipantInputBox.sendKeys("e");
        waitFor(1);
    }

    @Then("user selects the participant and should appear in the participant list")
    public void user_selects_the_participant_and_should_appear_in_the_participant_list() {
        List<WebElement> participants = talkModulePage.participantsListAfterAdded;
        if (participants.isEmpty()) {
            Assert.fail("No participants found in the list");
        }
        Random random = new Random();
        int index = random.nextInt(participants.size());
        WebElement randomParticipant = participants.get(index);
        String expectedName = randomParticipant.getText();
        waitFor(1);
        System.out.println("Expected participant: " + expectedName);
        boolean isFound = false;
        for (WebElement participant : participants) {
            if (participant.getText().equals(expectedName)) {
                waitFor(1);
                System.out.println("Actual participant: " + participant.getText());
                Assert.assertTrue(participant.isDisplayed());
                waitFor(1);
                isFound = true;
                break;
            }
        }
        Assert.assertTrue("Expected participant was not found in the list: " + expectedName, isFound);
    }

    @When("user clicks on the Add Participant input box")
    public void user_clicks_on_the_add_participant_input_box() {
        talkModulePage.addParticipantInputBox.click();
    }

    @When("user types a non-existent participant name below")
    public void user_types_a_non_existent_participant_name_below(String nonExitName) {
        talkModulePage.addParticipantInputBox.sendKeys(nonExitName);
    }

    @Then("user should see a message No search results")
    public void user_should_see_a_message_No_search_results() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(talkModulePage.noSearchResult, "No search results"));

        String actualMessage = talkModulePage.noSearchResult.getText();
        System.out.println("No search results message expected: " + actualMessage);
        Assert.assertEquals("No search results", actualMessage);
    }


    @When("the user views the conversation list")
    public void the_user_views_the_conversation_list() {
        System.out.println("Total conversation list: " + talkModulePage.conversationList.size());
        int totalConversation = talkModulePage.conversationList.size();

        Assert.assertTrue("Conversation list should not be empty", totalConversation > 0);
    }

    @Then("all existing conversations should be visible")
    public void all_existing_conversations_should_be_visible() {
        for (WebElement conversation : talkModulePage.conversationList) {
            System.out.println("Visible conversation: " + conversation.getText());
            Assert.assertTrue("Conversation group is not visible: " + conversation.getText(), conversation.isDisplayed());
        }
    }

    @When("user clicks on the Start call button")
    public void user_clicks_on_the_start_call_button() {
        waitFor(2);
        talkModulePage.callButton.click();
        talkModulePage.threeBars.click();
        waitFor(2);
    }

    @When("the call should start successfully")
    public void the_call_should_start_successfully() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(talkModulePage.youStartedCallMessage, "You started a call"));

        String callStartedMessage = talkModulePage.youStartedCallMessage.getText();
        String expectedMessage = "You started a call";

        System.out.println("Actual call started message: " + callStartedMessage);
        System.out.println("Expected call started message: " + expectedMessage);

        Assert.assertEquals(callStartedMessage, expectedMessage);
        waitFor(2);
    }

    @When("user clicks on the Leave call button")
    public void user_clicks_on_the_leave_call_button() {
        talkModulePage.leaveCallButton.click();
        waitFor(2);
    }

    @When("the call should end")
    public void the_call_should_end() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(talkModulePage.youStartedCallMessage, "You left the call"));

        String callEndedMessage = talkModulePage.youStartedCallMessage.getText();
        String expectedMessage = "You left the call";

        System.out.println("Actual call ended message: " + callEndedMessage);
        System.out.println("Expected call ended message: " + expectedMessage);
        Assert.assertEquals(callEndedMessage, expectedMessage);
        waitFor(2);
    }

    @Then("user should return to the conversation screen")
    public void user_should_return_to_the_conversation_screen() {
        groupName = talkModulePage.groupName.getText();
        String expectedTitle = groupName + " - Talk - Trycloud QA";
        String actualTitle = Driver.getDriver().getTitle();

        System.out.println("Group name = " + groupName);
        System.out.println("Actual group title: " + actualTitle);
        System.out.println("Expected group title: " + expectedTitle);

        Assert.assertTrue("User is not on the conversation screen", talkModulePage.groupName.isDisplayed());
        waitFor(2);
    }

    @When("user clicks on the three vertical dots")
    public void user_clicks_on_the_three_vertical_dots() {

        for (int i = 0; i < talkModulePage.conversationList.size(); i++) {
            WebElement conversation = talkModulePage.conversationList.get(i);
            if (conversation.getText().equals(groupName)) {
                talkModulePage.threeVerticalDots.get(i).click();
                break;
            }
        }
    }

    @When("user clicks on Delete conversation")
    public void user_clicks_on_delete_conversation() {
        waitFor(2);
        talkModulePage.deleteButton.click();
        waitFor(2);
    }

    @When("user cancels the deletion")
    public void user_cancels_the_deletion() {
        talkModulePage.declinedButton.click();
        waitFor(2);
    }

    @Then("the conversation group should still appear in the conversation list")
    public void the_conversation_group_should_still_appear_in_the_conversation_list() {
        String selectedConversationName = Driver.getDriver().getTitle().split(" - ")[0].trim();
        System.out.println("Trimmed conversation name: " + selectedConversationName);

        boolean isPresent = false;
        for (WebElement conversation : talkModulePage.conversationList) {
            String conversationText = conversation.getText().trim();
            waitFor(1);
            System.out.println("Checking conversation: " + conversationText);

            if (conversationText.equals(selectedConversationName)) {
                waitFor(1);
                System.out.println("Conversation still appears in the list: " + conversationText);
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue("Conversation should still be visible after cancelling deletion", isPresent);
    }

    @When("user confirms the deletion")
    public void user_confirms_the_deletion() {
        talkModulePage.confirmDelete.click();
        waitFor(2);
    }

    @When("the conversation group should no longer appear in the conversation list")
    public void the_conversation_group_should_no_longer_appear_in_the_conversation_list() {
        String deletedConversationName = Driver.getDriver().getTitle().split(" - ")[0].trim();
        waitFor(2);
        System.out.println("Deleted conversation name:" + deletedConversationName);
        deletedConversation = deletedConversationName;

        boolean conversationStillExists = false;
        for (WebElement conversation : talkModulePage.conversationList) {
            if (conversation.getText().equals(deletedConversationName)) {
                waitFor(2);
                conversationStillExists = true;
                break;
            }
        }
        waitFor(3);
        Assert.assertFalse("Deleted conversation should NOT appear in the list", conversationStillExists);
    }

    @Then("user should see message the conversation does not exist")
    public void user_should_see_message_the_conversation_does_not_exist() {
        System.out.println("Searching for deleted conversation: " + deletedConversation);
        waitFor(2);
        talkModulePage.searchConversationInputBox.clear();
        waitFor(2);
        talkModulePage.searchConversationInputBox.sendKeys(deletedConversation);
        waitFor(2);
        talkModulePage.searchConversationInputBox.sendKeys(Keys.ENTER);
        waitFor(2);

        String expectedMessage = "No matches";
        String actualMessage = talkModulePage.noMatchesMessage.getText().trim();

        System.out.println("Actual message: " + actualMessage);
        System.out.println("Expected message = " + expectedMessage);

        Assert.assertEquals("Deleted conversation message is incorrect", expectedMessage, actualMessage);
    }

    @When("user clicks on the three vertical dots and delete each conversation")
    public void user_clicks_on_the_three_vertical_dots_and_delete_each_conversation() {
        while (talkModulePage.conversationList.size() > 1) {
            for (int i = 0; i < talkModulePage.conversationList.size(); i++) {
                String name = talkModulePage.conversationList.get(i).getText().trim();

                if (!name.equals("Talk updates ✅")) {
                    talkModulePage.threeVerticalDots.get(i).click();
                    talkModulePage.deleteButton.click();
                    talkModulePage.confirmDelete.click();
                    waitFor(2);
                } else {
                    break;
                }
            }
        }
    }

    @When("the conversations should no longer appear in the conversation list except talk updates")
    public void the_conversations_should_no_longer_appear_in_the_conversation_list_except_talk_updates() {
        if (talkModulePage.conversationList.size() == 1) {
            Assert.assertTrue(talkModulePage.conversationList.size() == 1);
        }
        for (WebElement conversation : talkModulePage.conversationList) {
            if (conversation.getText().trim().equals("Talk updates ✅")) {
                System.out.println("Expected talk update in the list: " + conversation.getText());
                Assert.assertTrue(conversation.isDisplayed());
                break;
            }
        }
    }
}


