Feature: Transfer Fund feature

  #  login page
  @Smoke
  Scenario: Verify user is able to login with valid credentials
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on Sign In button
  #  homepage
    Then verify user is successfully logged in to the account
    When user clicks on transfer between accounts
  #  internal transfer page
    Then verify user is on Internal Transfer page
    When user select from account "transfer.from.account"
    And user select to account "transfer.to.account"
    And user enter amount "transfer.amount"
    And user clicks on submit button
  #  view account page
    Then verify user is on View Accounts Page
    And verify user has successfully created an account in the UI
    And verify a new checking account has been created in the database
