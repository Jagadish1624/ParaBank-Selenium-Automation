Feature: Bill Pay

Scenario: Navigate to bill pay
Given user is logged in
When user opens bill pay
Then bill pay page should display


Scenario: Valid bill payment
Given user is logged in
When user opens bill pay
And user pays bill with valid data
Then bill payment confirmation appears


Scenario: Invalid bill payment
Given user is logged in
When user opens bill pay
And user pays bill with invalid data
Then error should display
  
Scenario: Bill payment with amount greater than balance
Given user is logged in
When user opens bill pay
And user pays bill with amount greater than balance
Then bill payment should fail

