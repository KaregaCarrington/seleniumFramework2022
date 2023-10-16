Feature: Sign up Feature

  Scenario: Verify user is able to sign up to the site
    Given user clicks on sign up button
    And Verify user is on sign up page
    Then user clicks on title field
    Then user enters first name in first name field
    Then user enters last name is last name field
    Then user clicks on gender
    Then user enters valid date of birth
    And user enters valid social security number
    And user enters valid email address "valid.username"
    And user enters valid password "valid.password"
    Then user confirms valid password "valid.password"
    Then user clicks next button
    Then user fills address field
    Then user fills locality field
    Then user fills region field
    Then user fills postal code field
    Then user fills country field
    Then user fills home phone field
    Then user fills mobile phone field
    Then user fills work phone field
    Then user clicks agree button
    Then user clicks register button

