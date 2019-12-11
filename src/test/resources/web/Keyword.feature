Feature: Member Registration
  As a admin user
  I want to create Keyword
  So that the user can use it

  Scenario Outline: Create the new Keyword in the admin section
    When user is on the site
    And user loggs in into the admin portal using Email Id "<Email Id>" and Password "<Password>"
    And proceeds to create the keyword
    Then record should be successfully created

    Examples:
      | Email Id       | Password |
      | admin@demo.com | demo123  |

  Scenario: Create the new Keyword in the admin section using the existing word
    When user is on the site
    And user loggs in into the admin portal using Email Id "<Email Id>" and Password "<Password>"
    And proceeds to create the keyword using the existing word
    Then record should be successfully created