@AddNewContacts
Feature: Contacts Module Functionality

  Agile story: As a user, I should be able to create a new contact and edit/delete any contact under Contacts module
  # 1. User can create a new contact
  # 2. User can see all the contacts as a list inside the middle column and total number of the contacts near the “All Contacts” tab
  # 3. User can change the profile picture of any contact with a previously uploaded picture by using “Choose from files” option
  # 4. User can delete any selected contact

  Background: Be in the Home Page
    Given user is successfully logged in

  Scenario Outline: create new contacts
    When user clicks the Contacts Tab
    And user clicks the New contact button
    And user write the "<firstName>" of New Contact
    And user write the "<lastName>" of New Contact
    Then user can see the "<expectedNewContact>" in the All contacts list

    Examples:
      | firstName | lastName | expectedNewContact |
      | John       | Smith     | John Smith           |
      #| Marry      | Jones     | Marry Jones          |
      #| David      | Williams  | David Williams       |

