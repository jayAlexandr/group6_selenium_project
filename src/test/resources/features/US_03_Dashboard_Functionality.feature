@us-03
Feature: Dashboard Functionality

  Background:
    Given user is successfully logged in

  Scenario: user can see all modules
    And user should see the dashboard
    Then user should be able to see following modules
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Mail      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |
      | More apps |

  Scenario: user can see username
    And user should see the dashboard
    And user click on the user profile menu
    Then user should see their username

  Scenario: user can see status widgets and select any of them
    And user should see the dashboard
    And user click on Customize button
    And user should see widgets
    Then user can select any widgets

  Scenario: user can see background images and select any of them
    And user should see the dashboard
    And user click on Customize button
    And user should see background images
    Then user can select any background image

  Scenario: user can sees Online status options and select any of them
    And user should see the dashboard
    When user clicks on the Set Status button
    Then user should see status options
    When user selects a status option
    Then each selected status should be applied and visible

  Scenario: user can sees Online status message options and select any of them
    And user should see the dashboard
    When user clicks on the Set Status button
    Then user should see status message options
    When user selects a status message option
    Then the selected status message should be applied and visible