@us-07
Feature: Calendar Functionality

  Background:
    When the user is logged into the app and on the Calendar page

  @tc1-2-3
  Scenario Outline: User can view the "<calendarView>" Calendar
    And the user clicks the View Selection menu button
    And the user selects "<calendarView>"
    Then the user should see the "<calendarView>" Calendar view displayed

    Examples:
      | calendarView |
      | Day          |
      | Week         |
      | Month        |

  @tc4
  Scenario Outline: User can create a new event "<event>" under the Calendar module and view it on the selected day "<date>" via the Monthly Calendar view
    And the user selects the Monthly Calendar view
    And the user selects the Personal event view
    And the user clicks on New Event button
    And the user checks the All Day checkbox
    And the user clicks on "<date>" in the calendar
    And the user enters "<event>" as the event title
    And the user clicks Save
    Then the user should see the created "<event>" displayed on the selected day in the Monthly Calendar view
    Examples:
      | date       | event                  |
      | 2025-06-14 | Prom                   |
      | 2025-06-15 | Birthday               |
      | 2025-06-16 | Wedding                |
      | 2025-06-17 | Blame Someone Else Day |


  @tc5
  Scenario Outline: User can delete an event "<event>" from the Monthly Calendar view by using the “More” option
    And the user selects the Monthly Calendar view
    And the user selects the Personal event view
    And the user selects the created "<event>"
    And the user clicks the More button
    And the user clicks the Actions button on the More page
    And the user clicks on Delete button
    Then the user should see "<event>" removed from the calendar
    Examples:
      | event                  |
      | Prom                   |
      | Birthday               |
      | Wedding                |
      | Blame Someone Else Day |
