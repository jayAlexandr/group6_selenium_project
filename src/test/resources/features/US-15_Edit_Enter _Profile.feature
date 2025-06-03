@us-15
Feature: Edit/Enter Profile Settings Functionality

  Background:
    When user is logged in the app and on the settings page


  Scenario: User can see at least following titles inside personal info under Profile Settings page =>Full name/Email/Phone Number
    Then user sees Full name, Email, Phone Number displayed


  Scenario:
