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
    And user click on user profile menu
    Then user can see username

  Scenario: user can click on Customize button and user can see status widgets and select any of them
    And user should see the dashboard
    And user click on Customize button
    Then user can see status widgets
    Then user can select any of them

  Scenario: user can click on Customize button and user can see background images and select any of them
    And user should see the dashboard
    And user click on Customize button
    Then user can see background images
    Then user can select any background image
