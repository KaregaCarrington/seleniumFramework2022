package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InternalTransferPage;

public class InternalTransferSteps {
    InternalTransferPage internalTransferPage =  new InternalTransferPage();


    @Then("verify user is on Internal Transfer page")
    public void verify_user_is_on_internal_transfer_page() {
        internalTransferPage.verifyInternalTransferPage();

    }

    @When("user select from account {string}")
    public void user_select_from_account(String fromAccount) {
        internalTransferPage.selectFromAccount(fromAccount);
    }

    @When("user select to account {string}")
    public void user_select_to_account(String toAccount) {
        internalTransferPage.selectToAccount(toAccount);
    }

    @When("user enter amount {string}")
    public void user_enter_amount(String amount) {
        internalTransferPage.enterAmount(amount);
    }

    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        internalTransferPage.clickOnSubmitBtn();
    }


    @Then("verify transaction history displayed for the new transaction")
    public void verify_transaction_history_displayed_for_the_new_transaction() {

    }
    @Then("verify transaction details getting updated into the database")
    public void verify_transaction_details_getting_updated_into_the_database() {

    }
}

