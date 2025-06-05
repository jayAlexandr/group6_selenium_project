#User Story:
#As a user, I should be able to upload a file, move or delete any selected file under the Files module
#Acceptance Criteria:
#1.User can upload a file
#2.User can create a new folder
#3.User can move or copy any selected item to any folder and see the item in the selected folder
#4.User can delete any selected item from its three dots menu
#5.User can see the total number of files and folders under the files list table
@fileModule
Feature: Upload/Edit/Delete File Module Functionality

  Background: For all scenarios user is on the Files Module page of the TRYCLOUD application
    Given user is successfully logged in
    Then user should see the dashboard
    When user navigate to files module
    Then user verify files module page is displayed

    #1.User can upload a file
  #========================================================================
  @uploadFile
  Scenario: Upload a valid 1MB.txt file
    When user click on the plus button
    And user upload 1MB.txt file from the computer
    Then user verify uploaded 1MB.text file is visible under the item list
  @uploadFile
  Scenario: Upload a valid 2MB.jpg file
    When user click on the plus button
    And user upload 2MB.jpg file from the computer
    Then user verify uploaded 2MB.jpg file is visible under the item list
  @uploadFile
  Scenario: Upload a valid 3MB.pdf file
    When user click on the plus button
    And user upload 3MB.pdf file from the computer
    Then user verify uploaded 3MB.pdf file is visible under the item list
  @uploadFile
  Scenario: Upload a valid 4MB.png file
    When user click on the plus button
    And user upload 4MB.png file from the computer
    Then user verify uploaded 4MB.png file is visible under the item list
  @uploadFile
  Scenario: Upload a valid 5MB.docx file
    When user click on the plus button
    And user upload 5MB.docx file from the computer
    Then user verify uploaded 5MB.docx file is visible under the item list
  @uploadFile
  Scenario: Upload a valid 6MB.mp4 file
    When user click on the plus button
    And user upload 6MB.mp4 file from the computer
    Then user verify uploaded 6MB.mp4 file is visible under the item list
  @uploadFile
  Scenario: Upload a valid 7MB.zip file
    When user click on the plus button
    And user upload 7MB.zip file from the computer
    Then user verify uploaded 7MB.zip file is visible under the item list
  @uploadFile
  Scenario: Upload a valid 8MB.rar file
    When user click on the plus button
    And user upload 8MB.rar file from the computer
    Then user verify uploaded 8MB.rar file is visible under the item list
  @uploadFile
  Scenario: Upload a valid 9MB.iso file
    When user click on the plus button
    And user upload 9MB.iso file from the computer
    Then user verify uploaded 9MB.iso file is visible under the item list
  @uploadFile
  Scenario: Upload a valid 10MB file
    When user click on the plus button
    And user upload 10MB file from the computer
    Then user verify error message "Operation is blocked by access control" is displayed
  @uploadFile
  Scenario: Upload multiple files at once
    When user click on the plus button
    And user upload multiple two or more files from the computer
    Then user verify uploaded multiple files are visible under the item list
  @uploadFile
  Scenario: upload duplicate file with existing file name
    When user click on the plus button
    And user upload a duplicate file from the computer
    Then user verify popup window with warning message is displayed

    #2.User can create a new folder
  #========================================================================
  @createFolder
  Scenario: Create a new folder using arrow button
    When user click on the plus button
    And user click on the New folder in submenu
    And user enter New folder name
    And user click on arrow button
    Then user verify created New folder is displayed under the item list
  @createFolder
  Scenario: Create a new folder using Enter key
    When user click on the plus button
    And user click on the New folder in submenu
    And user enter New folder name and press Enter key
    Then user verify created New folder is displayed under the item list
  @createFolder
  Scenario: Create new folder with an existing name
    When user click on the plus button
    And user click on the New folder in submenu
    And user enter New folder name and press Enter key
    Then user verify warning message "already exists" is displayed
  @createFolder
  Scenario: Create new folder with empty name
    When user click on the plus button
    And user click on the New folder in submenu
    And user clear the input field and press Enter
    Then user verify warning message "cannot be empty" is displayed
  @createFolder
  Scenario: Create new folder with specials characters in name
    When user click on the plus button
    And user click on the New folder in submenu
    And user enter New folder name with special characters and press Enter key
    Then user verify New folder with specChar is displayed under the item list
  @createFolder
  Scenario: Create new folder with Backslash in name
    When user click on the plus button
    And user click on the New folder in submenu
    And user enter New folder name with Backslash and press Enter key
    Then user verify error message "Could not create folder" is displayed
  @createFolder
  Scenario: Create new folder with Forward Slash in name
    When user click on the plus button
    And user click on the New folder in submenu
    And user enter New folder name with Forward Slash and press Enter key
    Then user verify warning message "is not allowed" is displayed

  #3 - User can move or copy any selected item to any folder
  #    and see the item in the selected folder
  #========================================================================





