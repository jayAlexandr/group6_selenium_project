Feature: Folder View Functionality
  Agile story: As a user, I should be able to change folder view order by using Name/Size/Modified buttons
  #1. User can change folder view order by Name
  #2. User can change folder view order by Size
  #3. User can change folder view order by Modified
  #4. User can change the folder view by clicking the toggle-view button at the right corner of all files tab screen
  #5. User can select all the files at once and see the total values of all files in the first line when clicked on the
  # “select all” checkbox at the left top corner of the list

  Background: Be in the Home Page for all Scenarios
    Given user is successfully logged in
    And user navigate to files module
    And user verify files module page is displayed

  @ChangeOrderByName
  Scenario: change folder view order by Name
    When user clicks the order name Icon
    Then user see the the list in alphabetical order

  @ChangeOrderBySize
  Scenario: change folder view order by Size
    When user clicks the size Button
    Then user sees the list in order

  @ChangeOrderByModifiedDate
  Scenario:
    When user clicks the modified Module
    Then user see the list of modified in time order


