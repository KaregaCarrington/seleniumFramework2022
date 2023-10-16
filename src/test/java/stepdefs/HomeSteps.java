package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Then("verify user is successfully logged in to the account")
    public void verify_user_is_successfully_logged_in_to_the_account() {
        homePage.verifyPage();
    }

    @Given("user clicks on Checking tab")
    public void user_clicks_on_checking_tab() {

    }
    @Given("user clicks on New Checking")
    public void user_clicks_on_new_checking() {
        
        
    }
    @When("user clicks on transfer between accounts")
    public void user_clicks_on_transfer_between_account(){
        homePage.clickOnTransferBetweenAccounts();
    }
}
