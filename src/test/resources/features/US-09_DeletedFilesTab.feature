#User Story:
#As a user, I should be able to see all deleted files and delete/restore them permanently under the Deleted Files tab.
#Acceptance Criteria:
#1.User can see the most recent deleted file in the first line of the deleted file list when deleted files are ordered by newest to oldest
#2.User can order the all deleted files by newest to oldest or visa versa
#3.User can order alphabetically all the deleted files based on their names
#4.User can delete any deleted file permanently by using the three dots icon in the file’s line
#5.User can restore any deleted file and see it again under the All Files tab

@deletedFiles
Feature: Deleted Files Tab Functionality under Files Module

  Background: For all scenarios user is on Deleted Files Tab under Files Module
    Given user is successfully logged in
    Then user should see the dashboard
    And user navigates to files module
    And user navigates to Deleted files
    Then user verifies Deleted Files Tab is displayed

  #1.User can see the most recent deleted file in the first line of the deleted file list
  #  when deleted files are ordered by newest to oldest
  #===========================================================================================

  Scenario: Most recent Deleted File appears first
    When user clicks on all files tab
    And user marks CheckBox of "2mb-jpg-test-file.jpg" file
    And user clicks on Actions button
    And user clicks on Delete button
    And user navigates to Deleted files
    And user clicks on Deleted sort button
    Then user verifies last deleted file "2mb-jpg-test-file.jpg" in the first line

  #2.User can order the all deleted files by newest to oldest or visa versa
  #=============================================================================================

  Scenario: Sorting by Oldest to Newest
    Then user verifies all deleted files ordered by oldest to newest

  Scenario: Sorting by Newest to Oldest
    When user clicks on Deleted sort button
    Then user verifies all deleted files ordered by newest to oldest

  # 3.User can order alphabetically all the deleted files based on their names
  #===============================================================================================

  Scenario: All deleted files sorted alphabetical order (A-Z) based on their names
    When user clicks on Name sort button
    Then user verifies all deleted files ordered alphabetically

  Scenario: All deleted files sorted in reverse alphabetical order (Z-A) based on their names
    When user clicks on Name sort button
    And user clicks on Name sort button
    Then user verifies all deleted files ordered reverse alphabetically

  #4.User can delete any deleted file permanently by using the three dots icon in the file’s line
  #===============================================================================================
  
  Scenario: Delete file permanently by using the three dots icon
    When user clicks on "9mb.iso" Three Dot menu in Deleted item list
    And user clicks on Delete permanently
    Then user verifies "9mb" file is deleted permanently

  Scenario: Delete multiple files permanently
    When user marks CheckBoxes "textFile1" and "textFile2" of deleted items
    And user clicks on Actions button in Deleted files tab
    And user clicks on Delete permanently action

  #5.User can restore any deleted file and see it again under the All Files tab
  #===============================================================================================

  Scenario: Restore deleted file
    When user clicks on "8mb.rar" Restore button
    And user clicks on all files tab
    Then user verifies item "8mb.rar" is visible under the item list

  @inTest2
  Scenario: Restore multiple files at once
    When user marks CheckBoxes "4mb.png" and "7mb.zip" of deleted items
    And user clicks on Actions button in Deleted files tab
    And user clicks Restore action
    And user clicks on all files tab
    Then user verify files "4mb.png" and "7mb.zip" are displayed under the deleted item list