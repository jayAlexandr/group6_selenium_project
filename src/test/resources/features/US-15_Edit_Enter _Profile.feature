@us-15
Feature: Edit/Enter Profile Settings Functionality

  Background:
    When user is logged in the app and on the settings page


  Scenario: User can see at least following titles inside personal info under Profile Settings page =>Full name/Email/Phone Number
    Then user sees Full name, Email, Phone Number displayed


  Scenario: User can change "Full name" info under Profile Settings page using valid name format credentials
    And user enters a new name "John Pork" into the Full name field and presses Enter
    Then user sees a new name "John Pork" is saved in the Full name field


  Scenario: User can make "Phone number" info as private under Profile Settings page
    And user clicks on the options icon next to Phone number label
    And user selects private option
    Then user sees phone number settings changed to private


  Scenario Outline: User cannot pass any characters, except numbers, into the "Phone Number" input box
    And user enters "<phone>" to the phone number field and press Enter
    Then user sees his phone number is NOT saved
    Examples:
      | phone        |
      | 241-123-5434 |
      | 241-wrf-WEER |
      | lsa-241-a@#$ |
      | @SE-123-FLTl |

  Scenario: User can see the current local time under the Locale dropdown
    Then user sees correct webelement is displayed
















