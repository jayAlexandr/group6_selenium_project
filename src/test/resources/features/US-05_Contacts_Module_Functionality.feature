Feature: Contacts Module Functionality
  Agile story: As a user, I should be able to create a new contact and edit/delete any contact under Contacts module
  # 1. User can create a new contact
  # 2. User can see all the contacts as a list inside the middle column and total number of the contacts near the “All Contacts” tab
  # 3. User can change the profile picture of any contact with a previously uploaded picture by using “Choose from files” option
  # 4. User can delete any selected contact

  Background: Be in the Home Page
    Given user is successfully logged in
    And user clicks the Contacts Tab

  @AddNewContacts
  Scenario Outline: Create new contacts
    When user clicks the New contact button
    And user enters "<fullName>" of the new contact
    Then user can see "<expectedName>" in the All contacts list

    Examples:
      | fullName   | expectedName |
      | Adam Smith | Adam Smith   |
      | Sarah K    | Sarah K      |
      | John LP    | John LP      |

  @changeProfileImage
  Scenario: User can change the profile picture of any contact
    When user clicks on "Adam Smith" contact
    And user clicks the image icon
    And user clicks choose from file button
    And user chooses the image and clicks choose
    Then user sees the image changed

  @DeleteAContact
  Scenario: Delete a contact
    When user clicks on "Adam Smith" contact
    And User clicks the menu button
    And user clicks the delete button
    Then user shouldn't see "David" in the list




