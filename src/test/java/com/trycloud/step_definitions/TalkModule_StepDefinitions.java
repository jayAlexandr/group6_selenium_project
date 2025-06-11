package com.trycloud.step_definitions;

import com.trycloud.pages.TalkModulePage;

import static com.trycloud.utilities.BrowserUtils.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class TalkModule_StepDefinitions {

    public TalkModulePage talkModulePage = new TalkModulePage();

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
        sleep(2);
        talkModulePage.newConversationButton.click();
    }

    @And("user enters {string} in the input field")
    public void user_enters_in_the_input_field(String conversationName) {
        talkModulePage.newConversationInputBox.sendKeys(conversationName);
    }

    @And("user clicks on Add participants")
    public void user_clicks_on_add_participants() {
        talkModulePage.addParticipantsButton.click();
    }

    @And("user selects participants")
    public void user_selects_participants() {
        for (WebElement participant : talkModulePage.participantsList) {
            if (participant.getText().equals("admin")) {
                participant.click();
            }
        }
    }

    @And("user clicks on Create conversation")
    public void user_clicks_on_create_conversation() {
        talkModulePage.createConversationButton.click();
    }

    @Then("the {string} should appear in the conversation list")
    public void the_should_appear_in_the_conversation_list(String expectedConversationName) {
        for (WebElement conversationGroup : talkModulePage.conversationList) {
            if (conversationGroup.equals(expectedConversationName)) {
                System.out.println("Actual conversation group name = " + conversationGroup.getText());
                System.out.println("Expected conversation group name = " + expectedConversationName);
                Assert.assertTrue(conversationGroup.getText().equals(expectedConversationName));
            }
        }
    }

    @Given("user is in a conversation group")
    public void user_is_in_a_conversation_group() {
        List<WebElement> conversationGroups = talkModulePage.conversationList;
        Assert.assertFalse("Conversation list is empty!", conversationGroups.isEmpty());

        WebElement randomGroup = conversationGroups.get(new Random().nextInt(conversationGroups.size()));
        String groupName = randomGroup.getText();

        System.out.println("Randomly selected conversation group = " + groupName);
        randomGroup.click();
    }

    @When("user clicks on Add Participant")
    public void user_clicks_on_add_participant() {
        waitFor(1);
        talkModulePage.addParticipantInputBox.click();
    }

    @When("user types valid participant")
    public void user_types_valid_participant() {
        waitFor(1);
        talkModulePage.addParticipantInputBox.click();
        waitFor(1);
        talkModulePage.addParticipantInputBox.sendKeys("e");
        waitFor(1);
    }

    @When("user selects the participant and should appear in the participant list")
    public void user_selects_the_participant_and_should_appear_in_the_participant_list() {
        List<WebElement> participants = talkModulePage.participantsListAfterAdded;
        if (participants.isEmpty()) {
            Assert.fail("No participants found in the list.");
        }
        Random random = new Random();
        int index = random.nextInt(participants.size());
        WebElement randomParticipant = participants.get(index);
        String expectedName = randomParticipant.getText();
        waitFor(1);
        System.out.println("Expected participant = " + expectedName);
        boolean isFound = false;
        for (WebElement participant : participants) {
            if (participant.getText().equals(expectedName)) {
                waitFor(1);
                System.out.println("Actual participant = " + participant.getText());
                Assert.assertTrue(participant.isDisplayed());
                waitFor(1);
                isFound = true;
                break;
            }
        }
        Assert.assertTrue("Expected participant was not found in the list: " + expectedName, isFound);
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
}

