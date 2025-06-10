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
    And user clicks on the user profile menu
    Then user should see their username

  Scenario: user can see status widgets and select any of them
    And user should see the dashboard
    And user clicks on Customize button
    And user should see widgets
    Then user can select any widgets

  Scenario: user can see background images and select any of them
    And user should see the dashboard
    And user clicks on Customize button
    And user should see background images
    Then user can select any background image

  Scenario: user can see Online status options and select any of them
    And user should see the dashboard
    When user clicks on the Set Status button
    And user should see status options
    When user can select any status options
    Then the selected status should be applied and visible

  Scenario: user can see status message options and select any of them
    And user should see the dashboard
    When user clicks on the Set Status button
    And user should see status message options
    When user can select any status message options
    Then the selected status message should be applied and visible


  Scenario: user can clear status message
    And user should see the dashboard
    When user clicks on the Set Status button
    And user should see status message options
    When user can select any status message options
    Then the selected status message should be applied and visible

  Scenario Outline: user can see type status message and set status
    And user should see the dashboard
    When user clicks on the Set Status button
    And user type "<status message>" and set status
    Then the "<expected status message>" should be applied and visible

    Examples:
      | status message                                      | expected status message                             |
      | Hello                                               | Hello                                               |
      | ~!@#$%^&*()_+                                       | ~!@#$%^&*()_+                                       |
      | Hello world                                         | Hello world                                         |
      | 1234567890                                          | 1234567890                                          |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |

  Scenario: user can see clear status with time options and select any of them
    And user should see the dashboard
    And user clicks on the Set Status button
    And user clicks on clear status time options
    And user should see time options below
      | Don't clear |
      | 30 minutes  |
      | 1 hour      |
      | 4 hours     |
      | Today       |
      | This week   |
    And user selects any time option
    Then the selected time should be applied and visible in the time input field
