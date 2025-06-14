@us-08
Feature: Manage conversations and calls under the Talk module

  As a user,
  I want to create a new conversation, add participants, start and leave a call,
  So that I can communicate with others in the Talk module.

  Background:
    Given user is successfully logged in
    And user should see the dashboard
    And user navigates to the Talk module
    And user is on the Talk page

  Scenario Outline: User can create a new conversation
    When user clicks on the Create a new group conversation button
    And user enters "<Conversation name>" in the input field
    And user clicks on Add participants
    And user clicks on Create conversation
    Then the "<Expected Conversation name>" should appear in the conversation list
    Examples:
      | Conversation name                        | Expected Conversation name               |
      | Marketing Team                           | Marketing Team                           |
      | Conversation                             | Conversation                             |
      | Test_Conversation_01                     | Test_Conversation_01                     |
      | Group#1$Test                             | Group#1$Test                             |
      | !@#$%^&*()_+                             | !@#$%^&*()_+                             |
      | 1234567890123456789012345678901234567890 | 1234567890123456789012345678901234567890 |
      | _underscore                              | _underscore                              |
      | MixedCASE123                             | MixedCASE123                             |
      | Group.Name.Test                          | Group.Name.Test                          |

  Scenario: User cannot create a conversation without a name
    When user clicks on the Create a new group conversation button
    And user leaves the conversation name field blank
    And the Add participants button should be disabled
    Then the Create conversation button should be disabled

  Scenario: User can add participants to a conversation
    When user is in a conversation group
    And user clicks on Add Participant
    And user types valid participant
    Then user selects the participant and should appear in the participant list

  Scenario: User cannot add a participant that doesn't exist
    When user is in a conversation group
    And user clicks on the Add Participant input box
    And user types a non-existent participant name below
      | Sunisa |
    Then user should see a message No search results

  Scenario: Display all conversations in the Talk module
    When the user views the conversation list
    Then all existing conversations should be visible

  Scenario: User can start and leave a call
    When user is in a conversation group
    And user clicks on the Start call button
    And the call should start successfully
    And user clicks on the Leave call button
    And the call should end
    Then user should return to the conversation screen

  Scenario: User cannot delete a conversation without confirmation
    When user is in a conversation group
    And user clicks on the three vertical dots
    And user clicks on Delete conversation
    And user cancels the deletion
    Then the conversation group should still appear in the conversation list

  Scenario: User can delete a conversation
    When user is in a conversation group
    And user clicks on the three vertical dots
    And user clicks on Delete conversation
    And user confirms the deletion
    And the conversation group should no longer appear in the conversation list
    Then user should see message the conversation does not exist

  Scenario: User can delete all conversation except talk updates
    And user clicks on the three vertical dots and delete each conversation
    Then the conversations should no longer appear in the conversation list except talk updates

