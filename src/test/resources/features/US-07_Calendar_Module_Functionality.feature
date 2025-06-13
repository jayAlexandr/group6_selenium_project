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
  Scenario Outline: User can create and view "<event>" on "<date>" in the Monthly Calendar view
    Given the user is on the Monthly Calendar view
    And the user filters to Personal events
    When the user creates a new all-day event titled "<event>" on "<date>"
    Then the event "<event>" should be visible in the calendar

    Examples:
      | date       | event                  |
      | 2025-06-14 | Prom                   |
      | 2025-06-15 | Birthday               |
      | 2025-06-16 | Wedding                |
      | 2025-06-17 | Blame Someone Else Day |



  @tc5
  Scenario Outline: User can delete an event "<event>" from the Monthly Calendar view
    Given the user is on the Monthly Calendar view
    And the user filters to Personal events
    When the user deletes the event titled "<event>"
    Then the event "<event>" should no longer be visible in the calendar

    Examples:
      | event                  |
      | Prom                   |
      | Birthday               |
      | Wedding                |
      | Blame Someone Else Day |
