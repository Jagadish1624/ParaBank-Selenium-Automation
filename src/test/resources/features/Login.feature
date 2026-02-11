Feature: Login Functionality

Scenario Outline: Verify login with multiple credential combinations
Given user is on login page
When user enters username "<Username>" and password "<Password>"
Then "<Result>" should be displayed

Examples:
    | Username      | Password      | Result  |
    | ${username}   | ${password}   | success |
    | invalidUser   | ${password}   | error   |
    | ${username}   | wrongPass     | error   |
    |  invalidUser  | wrongPass     | error   |
    |               |               | error   |

Scenario: Verify login page elements are visible
Given user is on login page
Then login page elements should be visible

Scenario: Verify error message for invalid credentials
Given user is on login page
When user enters username "wronguser" and password "wrongpass"
Then "error" should be displayed
