Feature: Calendar Functionality

  Background:
    When the user is logged into the app and on the Calendar page

  Scenario: User can view the Daily Calendar
    And the user clicks the View Selection menu button
    And the user selects "Day"
    Then the user should see the Daily Calendar view displayed

  Scenario: User can view the Weekly Calendar
    And the user clicks the View Selection menu button
    And the user selects "Week"
    Then the user should see the Weekly Calendar view displayed

  Scenario: User can view the Monthly Calendar
    And the user clicks the View Selection menu button
    And the user selects "Month"
    Then the user should see the Monthly Calendar view displayed

  Scenario Outline: User can create a new event under the Calendar module and view it on the selected day via the Monthly Calendar view
    And the user selects the Monthly Calendar view
    And the user selects the Personal event view
    And the user clicks on "<date>" in the calendar
    And the user enters "<event>" as the event title
    And the user checks the "All Day" checkbox
    And the user clicks Save
    Then the user should see the created event displayed on the selected day in the Monthly Calendar view
    Examples:
      | date       | event                  |
      | 2025-06-10 | Prom                   |
      | 2025-06-11 | Birthday               |
      | 2025-06-12 | Divorce                |
      | 2025-06-13 | Blame Someone Else Day |

  Scenario Outline: User can delete an event from the Monthly Calendar view by using the “More” option
    And the user selects the Monthly Calendar view
    And the user selects the Personal event view
    And the user selects the created "<event>"
    And the user clicks the More button
    And the user clicks the Actions button on the More page
    Then the user should see "<event>" removed from the calendar
    Examples:
      | event                  |
      | Prom                   |
      | Birthday               |
      | Divorce                |
      | Blame Someone Else Day |
