@us14
Feature: Add to Favorites/Rename/Comment on File Functionality

  Background: For all scenarios user is logged in and navigated to Files page
    Given user is successfully logged in
    When user navigate to files module

  Scenario: User can add any file to favorites from its own three dots menu
    When user clicks on three dots menu in the file
    And user can click on the menu option Add to favorites
    And click to favorites folder to check new added file is displayed


  Scenario: User can rename any file from its own three dots menu
    When user clicks on three dots menu in the file
    And user can click on the menu option to Rename
    And user can Rename any file "US-14_isk88"
    And user should be able to see renamed file "US-14_isk88"


  Scenario: User can put some comments on any file from the file details menu opened right side
    When user clicks on three dots menu in the file
    And user can click on the menu option to Details
    And user can click on the Comments
    And user can leave comment "Informative!" in the comments input box
    Then user can click to post button


  Scenario: User can delete the comments made on any file from the the file details menu opened right side
    When user clicks on three dots menu in the file
    And user can click on the menu option to Details
    And user can click on the Comments
    And user clicks to three dots menu by the persons name
    And user can choose from menu option Delete comment
    Then user can verify that comment is deleted








