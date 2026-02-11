Feature: User Registration

Scenario: Navigate to registration page
Given the user is on the home page
When the user clicks on the register link
Then the registration page should be displayed

Scenario: Register a new user with valid information
Given the user is on the registration page
When the user enters valid registration details
Then a success message should be displayed

Scenario: Register user with missing mandatory fields
Given the user is on the registration page
When the user submits the form without mandatory fields
Then validation error messages should be displayed

Scenario: Verify registration page displays correctly
Given the user is on the home page
When the user clicks on the register link
Then the registration page should be displayed
