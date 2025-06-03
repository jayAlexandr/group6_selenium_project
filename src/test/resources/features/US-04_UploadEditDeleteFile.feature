#User Story:
#As a user, I should be able to upload a file, move or delete any selected file under the Files module
#Acceptance Criteria:
#1.User can upload a file
#2.User can create a new folder
#3.User can move or copy any selected item to any folder and see the item in the selected folder
#4.User can delete any selected item from its three dots menu
#5.User can see the total number of files and folders under the files list table

Feature: Upload/Edit/Delete File Module Functionality

  Background: For all scenarios user is on the Files Module page of the TRYCLOUD application
    Given user is successfully logged in
    Then user should see the dashboard
    When user navigate to files module
    Then user verify files module page is displayed

    @upload
    #1.User can upload a file
    Scenario: Upload a valid file
    When user click on the plus button
    And user click on the upload file option in submenu
    And user selects a valid file from the computer
    Then user verify that selected file is uploaded
    Then user verify that uploaded file is visible under the item list
