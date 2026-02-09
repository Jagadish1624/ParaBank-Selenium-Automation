Feature: Account Overview

Scenario: Verify overview page
Given user is logged in
Then account overview should display

Scenario: Verify balances
Given user is logged in
Then account balances should be visible
