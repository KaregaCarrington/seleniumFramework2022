Feature: Account creation feature

  Background: Verify user is able to login with valid credentials
    Given user enters valid "valid.username" and "valid.password"
    When user clicks on Sign In button
    Then verify user is successfully logged in to the account

    Scenario: Verify a new account can be created with valid information (account type, ownership type, account name, initial deposit amount)
      Given user clicks on Checking tab
      And user clicks on New Checking

      Then verify user is on Create Checking page
      Then user clicks on Checking Account Type
      And user clicks on Account Ownership
      And user enters an Account Name with "checking.name"
      Then user enters an Initial Deposit Amount with "deposit.amount"
      When user clicks on Create Checking Submit Button

      Then verify user has successfully created an account in the UI
      And verify a new checking account has been created in the database