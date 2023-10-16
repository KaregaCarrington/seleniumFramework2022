package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckingAccountCreationPage;

public class CheckingAccountCreationSteps {

    CheckingAccountCreationPage accountCreationPage = new CheckingAccountCreationPage();

    @Then("verify user is on Create Checking page")
    public void verify_user_is_on_create_checking_page() {
        accountCreationPage.verifyCreateCheckingTitle();
    }
    @Then("user clicks on Checking Account Type")
    public void user_clicks_on_checking_account_type() {
        accountCreationPage.clickOnCheckingAccountType();
    }
    @Then("user clicks on Account Ownership")
    public void user_clicks_on_account_ownership() {
        
        
    }
    @Then("user enters an Account Name with {string}")
    public void user_enters_an_account_name_with(String string) {
        
        
    }
    @Then("user enters an Initial Deposit Amount with {string}")
    public void user_enters_an_initial_deposit_amount_with(String string) {
        
        
    }
    @When("user clicks on Create Checking Submit Button")
    public void user_clicks_on_create_checking_submit_button() {
        
        
    }
}
