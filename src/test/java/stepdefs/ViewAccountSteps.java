package stepdefs;

import io.cucumber.java.en.Then;
import pages.ViewAccountPage;

public class ViewAccountSteps {

    ViewAccountPage viewAccountPage = new ViewAccountPage();
    @Then("verify user has successfully created an account in the UI")
    public void verify_user_has_successfully_created_an_account_in_the_ui() {
        viewAccountPage.verifyAccountPage();
    }
    @Then("verify a new checking account has been created in the database")
    public void verify_a_new_checking_account_has_been_created_in_the_database() {
        viewAccountPage.verifyDetailsIntoDatabase();
    }

    @Then("verify user is on View Accounts Page")
    public void verify_user_is_on_view_accounts_page() {
        viewAccountPage.verifyAccountPage();
    }
}
