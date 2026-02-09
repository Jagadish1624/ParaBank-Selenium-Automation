Feature: Login Module

Scenario: Login with valid credentials
Given user is on login page
When user enters valid username and password
Then user should navigate to account overview

Scenario: Login with invalid username
Given user is on login page
When user enters invalid username
Then error message should display

Scenario: Login with invalid password
Given user is on login page
When user enters invalid password
Then error message should display

Scenario: Login with blank credentials
Given user is on login page
When user clicks login without entering credentials
Then error message should display

Scenario: Verify UI elements
Given user is on login page
Then login page elements should be visible

