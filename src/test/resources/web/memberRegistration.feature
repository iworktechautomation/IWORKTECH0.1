Feature: Member Registration
  As a user
  I want to add a member
  Sp that the user should be successfully registered

  Scenario: Register the user
    When user is on the site
    When user enters basic information
      | Institution Name | Country | Postal Address      | City  | Zip Code | Country Code | Telephone |
      | Test Institute   | INDIA   | 411058, Main Street | Delhi | 4100108  | 91           | 2555555   |
    And clicks save button
    Then the Institutional Expertise page should open

