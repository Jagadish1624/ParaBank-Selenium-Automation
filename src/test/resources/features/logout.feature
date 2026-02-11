Feature: Logout

Scenario: Verify logout
Given user is logged in
When user clicks logout
Then session should terminate

Scenario: Verify session ends after logout
Given user is logged in
When user clicks logout
Then session should terminate
