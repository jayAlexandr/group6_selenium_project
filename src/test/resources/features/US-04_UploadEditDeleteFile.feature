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
    When user navigates to files module
    Then user verifies files module page is displayed

  #AC1 - User can upload a file
  #========================================================================

  @ac1
  Scenario Outline: Upload a valid "<file_name>" and verify it's visible
    When user clicks on the plus button
    And user upload "<file_key>" file from the computer
    Then user verify uploaded "<file_name>" is visible under the item list

    Examples:
      | file_key      | file_name                  |
      | file_1mb_txt  | 1mb-examplefile.txt        |
      | file_2mb_jpg  | 2mb-jpg-test-file.jpg      |
      | file_3mb_pdf  | 3-mb-sample-pdf-file.pdf   |
      | file_4mb_png  | 4mb.png                    |
      | file_5mb_docx | 5mb.docx                   |
      | file_6mb_mp4  | 6mb-example-video-file.mp4 |
      | file_7mb_zip  | 7mb.zip                    |
      | file_8mb_rar  | 8mb.rar                    |
      | file_9mb_iso  | 9mb.iso                    |

  @ac1
  Scenario: Upload a valid 10MB file
    When user clicks on the plus button
    And user upload "file_10mb_jpg" file from the computer
    Then user verify message "Operation is blocked by access control" is displayed

  @ac1
  Scenario: Upload multiple files at once
    When user clicks on the plus button
    And user upload "file_text_1" and "file_text_2" files from the computer
    Then user verify files "textFile1.txt" and "textFile2.txt" are displayed

  @ac1
  Scenario: Upload duplicate file with existing file name
    When user clicks on the plus button
    And user upload "file_text_1" file from the computer
    Then user verify popup window with warning message is displayed

  #AC2 - User can create a new folder
  #========================================================================

  @ac2
  Scenario: Create a new folder using arrow button
    When user clicks on the plus button
    And user clicks on the New folder in submenu
    And user enter "GR6" new folder name
    And user clicks on arrow button
    Then user verify created New folder is displayed under the item list

  @ac2
  Scenario: Create a new folder using Enter key
    When user clicks on the plus button
    And user clicks on the New folder in submenu
    And user enter New folder name and press Enter key
    Then user verify created New folder is displayed under the item list

  @ac2
  Scenario: Create new folder with an existing name
    When user clicks on the plus button
    And user clicks on the New folder in submenu
    And user enter New folder name and press Enter key
    Then user verify warning message "already exists" is displayed

  @ac2
  Scenario: Create new folder with empty name
    When user clicks on the plus button
    And user clicks on the New folder in submenu
    And user clear the input field and press Enter
    Then user verify warning message "cannot be empty" is displayed

  @ac2
  Scenario: Create new folder with specials characters in name
    When user clicks on the plus button
    And user clicks on the New folder in submenu
    And user enter New folder name with special characters and press Enter key
    Then user verify New folder with specChar is displayed under the item list

  @ac2
  Scenario: Create new folder with Backslash in name
    When user clicks on the plus button
    And user clicks on the New folder in submenu
    And user enter New folder name with Backslash and press Enter key
    Then user verify message "Could not create folder" is displayed

  @ac2
  Scenario: Create new folder with Forward Slash in name
    When user clicks on the plus button
    And user clicks on the New folder in submenu
    And user enter New folder name with Forward Slash and press Enter key
    Then user verify warning message "is not allowed" is displayed

  #AC3 - User can move or copy any selected item to any folder
  #      and see the item in the selected folder
  #========================================================================

  @ac3
  Scenario: Move an item to a folder
    When user clicks on "textFile1.txt" Three Dot menu
    And  user clicks on MoveOrCopy
    And user clicks on selected folder
    And user clicks on MoveTo button
    Then user navigates to selected folder and verify item is displayed

  @ac3
  Scenario: Copy an item to a folder
    When user clicks on "4mb.png" Three Dot menu
    And user clicks on MoveOrCopy
    And user clicks on selected folder
    And user clicks on CopyTo button
    Then user navigates to selected folder and verify item is displayed

  @ac3
  Scenario: Move an item that already exists in the folder
    When user clicks on "4mb.png" Three Dot menu
    And user clicks on MoveOrCopy
    And user clicks on selected folder
    And user clicks on MoveTo button
    Then user verify message "Could not move" is displayed

  @ac3
  Scenario: Copy an item that already exists in the folder
    When user clicks on "4mb.png" Three Dot menu
    And user clicks on MoveOrCopy
    And user clicks on selected folder
    And user clicks on CopyTo button
    Then user verify message "Could not copy" is displayed

  @ac3
  Scenario: Move multiple items at once
    When user marks CheckBoxes "textFile2.txt" and "1mb-examplefile.txt" of items
    And user clicks on Actions button
    And user clicks on MoveOrCopy button
    And user clicks on selected folder
    And user clicks on MoveTo button
    Then user navigates to selected folder and verify "textFile2.txt" and "1mb-examplefile.txt" are displayed

  @ac3
  Scenario: Copy multiple items at once
    When user marks CheckBoxes "8mb.rar" and "9mb.iso" of items
    And user clicks on Actions button
    And user clicks on MoveOrCopy button
    And user clicks on selected folder
    And user clicks on CopyTo button
    Then user navigates to selected folder and verify "8mb.rar" and "9mb.iso" are displayed

  #AC4 - User can delete any selected item from its three dots menu
  #================================================================================

  @ac4 @inTest
  Scenario: Delete an item
    When user clicks on "7mb.zip" Three Dot menu
    And user clicks on Delete File
    And user navigates to Deleted files
    Then user verify deleted "7mb.zip" file is displayed under the deleted item list

  @ac4
  Scenario: Delete multiple items at once
    When user marks CheckBoxes "5mb.docx" and "6mb-example-video-file.mp4" of items
    And user clicks on Actions button
    And user clicks on Delete button
    And user navigates to Deleted files
    Then user verify files "5mb.docx" and "6mb-example-video-file.mp4" are displayed under the deleted item list

  #AC5 - User can see the total number of files and folders under the files list table
  #====================================================================================

  @ac5
  Scenario: Verify the total number of files and folders
    When user navigates to the bottom of the item list
    Then user verify the total number of items should be displayed correctly

  @ac5
  Scenario: Verify the total number of files and folders after adding the item
    When user clicks on the plus button
    And user upload "file_text_3" file from the computer
    And user navigates to the bottom of the item list
    Then user verify the total number of items should be displayed correctly

  @ac5
  Scenario: Verify the total number of files and folders after deleting the item
    When user marks CheckBox of "textFile3.txt" file
    And user clicks on Actions button
    And user clicks on Delete button
    And user navigates to the bottom of the item list
    Then user verify the total number of items should be displayed correctly