@US_02
Feature: Log out Functionality


  Scenario:  users log out from the app after Clicking the “Log Out” button.
    Given user is successfully logged in
    When user clicks on profile name button
    And  user clicks on log out button
    Then user should land on log in page

  Scenario:   user can not go to the home page again by Clicking the step back button
    Given user is successfully logged in
    When user clicks on profile name button
    And  user clicks on log out button
    Then user should land on log in page
    When user clicks on step back button
    Then user should not land on Home  page anymore

  Scenario:   user logs out automatically when user leaves the page away from keyboard up to 3 minutes
    Given user is successfully logged in
    When  user does not do any mouse or keyboard action for 3 minutes
    Then user should land on log in page