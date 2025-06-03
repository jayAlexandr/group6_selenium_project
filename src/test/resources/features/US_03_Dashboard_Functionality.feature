Feature: Dashboard Functionality

  Background:
    Given user is successfully logged in
    Then user should see the dashboard

  Scenario: user can see all modules
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
    And user click on user profile menu
    Then user can see username

  @wip
  Scenario: user can click on Customize button and user can see status widgets and select any of them
    And user click on Customize button
    Then user can see status widgets
    Then user can select any of them
