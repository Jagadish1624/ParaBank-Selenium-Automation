Feature: Transfer Funds

Scenario: Navigate to transfer page
  Given user is logged in
  When user opens transfer funds
  Then transfer page should display


Scenario: Valid transfer
  Given user is logged in
  When user opens transfer funds
  And user transfers valid amount
  Then transfer success message should appear


Scenario: Invalid transfer
  Given user is logged in
  When user opens transfer funds
  And user transfers invalid amount
  Then error message should displayed
