
Feature: Contacts Module Functionality
  Agile story: As a user, I should be able to create a new contact and edit/delete any contact under Contacts module
  # 1. User can create a new contact
  # 2. User can see all the contacts as a list inside the middle column and total number of the contacts near the “All Contacts” tab
  # 3. User can change the profile picture of any contact with a previously uploaded picture by using “Choose from files” option
  # 4. User can delete any selected contact

  Background: Be in the Home Page
    Given user is successfully logged in

  @AddNewContacts
  Scenario: Create new contacts
    When user clicks the Contacts Tab
    And user clicks the New contact button
    And user enters "David" in the company box
    And user enters "Smith" in the title box
    Then user can see the new contact in the All contacts list

  @changeProfileImage
  Scenario: User can change the profile picture of any contact
    When user clicks the Contacts Tab
    And user clicks on "David" contact
    And user clicks the image icon
    Then user clicks choose from file button

  @DeleteAContact
  Scenario: Delete a contact
    When user clicks the Contacts Tab
    And user clicks on "David" contact
    And User clicks the menu button
    And user clicks the delete button
    Then user shouldn't see "David" in the list




