package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SignUpPage;

public class SignUpSteps {
    
    SignUpPage signUpPage = new SignUpPage();

    @Given("Verify user is on sign up page")
    public void verify_user_is_on_sign_up_page() {
        signUpPage.verifySignUpPage();
    }
    @Then("user clicks on title field")
    public void user_clicks_on_title_field() {
        signUpPage.clickOnTitleField();
    }
    @Then("user enters first name in first name field")
    public void user_enters_first_name_in_first_name_field() {
        signUpPage.enterFirstName();
    }
    @Then("user enters last name is last name field")
    public void user_enters_last_name_is_last_name_field() {
        signUpPage.enterLastName();
    }
    @Then("user clicks on gender")
    public void user_clicks_on_gender() {
        signUpPage.clickOnGender();
    }
    @Then("user enters valid date of birth")
    public void user_enters_valid_date_of_birth() {
        signUpPage.enterDOB();
    }
    @Then("user enters valid social security number")
    public void user_enters_valid_social_security_number() {
        signUpPage.enterSSN();
    }
    @Then("user enters valid email address {string}")
    public void user_enters_valid_email_address(String username) {
        signUpPage.enterEmailAddress(username);
    }
    @Then("user enters valid password {string}")
    public void user_enters_valid_password(String string) {
        signUpPage.enterValidPassword(string);
    }
    @Then("user confirms valid password {string}")
    public void user_confirms_valid_password(String string) {
        signUpPage.confirmPassword(string);
    }
    @Then("user clicks next button")
    public void user_clicks_next_button(){ signUpPage.clickOnNextBtn(); }
    @Then("user fills address field")
    public void user_fills_address_field(){
        signUpPage.enterAddressField();
    }
    @Then("user fills locality field")
    public void user_fills_locality_field(){
        signUpPage.enterLocalityField();
    }
    @Then("user fills region field")
    public void user_fills_region_field(){
        signUpPage.enterRegionField();
    }
    @Then("user fills postal code field")
    public void user_fills_postal_code_field(){
        signUpPage.enterPostalCode();
    }
    @Then("user fills country field")
    public void user_fills_country_field(){
        signUpPage.enterCountry();
    }
    @Then("user fills home phone field")
    public void user_fills_home_phone_field(){
        signUpPage.enterHomePhone();
    }
    @Then("user fills mobile phone field")
    public void user_fills_mobile_phone_field(){
        signUpPage.enterMobilePhone();
    }
    @Then("user fills work phone field")
    public void user_fills_work_phone_field(){
        signUpPage.enterWorkPhone();
    }
    @Then("user clicks agree button")
    public void user_clicks_agree_button(){
        signUpPage.clickAgreeBtn();
    }
    @Then("user clicks register button")
    public void user_clicks_register_button(){
        signUpPage.clickRegisterBtn();
    }

}
