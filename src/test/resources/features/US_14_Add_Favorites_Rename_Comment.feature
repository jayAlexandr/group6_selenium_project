
Feature: Add to Favorites/Rename/Comment on File Functionality

  Background: For all scenarios user is logged in and navigated to Files page
    Given user is successfully logged in
    Then user should see the dashboard
    When user navigate to files module
    Then user verify files module page is displayed


  Scenario: User can add any file to favorites from its own three dots menu
    When user clicks on three dots menu in the file
    Then user can click on the menu option Add to favorites
    And click to favorites folder to check new added file is displayed

  @us14
  Scenario: User can rename any file from its own three dots menu
    When user clicks on three dots menu in the file
    Then user can click on the menu option to Rename

  Scenario: User can put some comments on any file from the file details menu opened right side
    When user clicks on three dots menu in the file
    Then user can click on the menu option to Details
    Then user can click on the Comments
    And user can leave any comment in the comments input box
    Then user can click to post button

  Scenario: User can delete the comments made on any file from the the file details menu opened right side
    When user clicks on three dots menu in the file
    Then user can click on the menu option to Details
    Then user can click on the Comments
    And user clicks to three dots menu by the persons name
    And user can choose from menu option Delete comment
    Then user can verify that comment is deleted








