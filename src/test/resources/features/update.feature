Feature: Update Contact Info

Scenario: Navigate to contact update
  Given user is logged in
  When user opens update contact
  Then update page should display


Scenario: Update valid data
  Given user is logged in
  When user opens update contact
  And user updates valid contact info
  Then updated info should be saved


Scenario: Update invalid data
  Given user is logged in
  When user opens update contact
  And user enters invalid contact info
  Then validation errors appear
