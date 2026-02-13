Feature: Account Overview

Scenario: Verify overview page
Given user is logged in
Then account overview should display

Scenario: Verify account overview and balances
Given user is logged in
Then account overview should display
And account balances should be visible

