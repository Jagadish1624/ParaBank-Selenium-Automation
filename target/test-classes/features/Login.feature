Feature: Login Functionality

  Scenario Outline: Verify login with multiple credential combinations
    Given user is on login page
    When user enters username "<Username>" and password "<Password>"
    Then "<Result>" should be displayed

  Examples:
    | Username                  | Password                  | Result      |
    | ${username}              | ${password}              | success     |
    | invalidUser              | ${password}              | error       |
    | ${username}              | wrongPass                | error       |
    |                          |                          | error       |
    | invalidUser              | WrongPass                | error       |
