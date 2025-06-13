Feature: Contact Group Functionality under Contacts Module
    Agile story: As a user, I should be able to create a new group and add any contact into a group under Contacts module

    # 1. User can create a new group under Contacts Module
    # 2. User can add any existing contact from the groups dropdown menu existing inside that specific contact’s own info menu
    # 3. User can see all the available groups name through the groups dropdown menu existing in the contact’s own info menu
    # 4. User can add a new property as “Birthday” to the contact’s info page from the “Add new property” dropdown menu

    Background: Be in the Home Page
      Given user is successfully logged in
      And user clicks the Contacts Tab

    @CreateNewGroup
    Scenario: Create a new group under Contacts Module
      When user clicks the create group icon
      And user enters "Cinema"
      Then user sees "Cinema" in the list of group

    @AddContactToGroup
    Scenario: Add a new contact to a group
      And user clicks on "Adam Smith" contact
      And user clicks Groups Button and add the contact to "Cinema"
      Then user should see the same lists in both options and first column




