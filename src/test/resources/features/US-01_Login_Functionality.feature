
Feature: Login Functionality

  Background: For all scenarios user is log in page

  Scenario: 1- User can login with valid credentials by clicking on the "Login button".
    When user is on the login page
    And user enters valid username
    And user enters valid password
    Then user clicks on log in button

  Scenario: 1- User can login with valid credentials by hitting "Enter" key from the keyboard.
    When user is on the login page
    And user enters valid username
    And user enters valid password
    Then user can log in by clicking Enter button


  Scenario Outline: 2 - Log in with invalid credential
    Given user is on the login page
    When user enters the username "<username>" and password "<password>"
    Then the user should not be able to log in
    Then user should blankCredentialMessage or invalidCredentialMessage

    Examples:
      | username      | password      |
      | wrongUserName | Employee123   |
      | Employee16    | wrongPassword |
      | wrongUserName | wrongPassword |
      | wrongUserName |               |
      |               | wrongPassword |


  Scenario: 3-User can see the password in a form of dots by default
    Given user is on the login page
    When user enters valid username
    And user enters valid password
    Then user can see the password in the input in a form of dots


  Scenario: 4-User can see the password explicitly if needed
    Given user is on the login page
    When user enters valid username
    And user enters valid password
    And user clicks on toggle password icon
    Then user can see entered password clearly

  @us1
  Scenario: 5-User can see the "Forgot password?" link on the login page and can see the
            "Reset Password" button on the next page after clicking on forget password link
    When user is on the login page
    And user click on the forgot password button
    Then user can see in the next page reset password button



