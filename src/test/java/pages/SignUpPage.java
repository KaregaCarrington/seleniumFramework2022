package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;

import java.util.List;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//strong[contains(text(),'Title')]")
    WebElement titleLabel;

    @FindBy(xpath = "//select[@id='title']")
    WebElement titleField;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='dob']")
    WebElement dobField;

    @FindBy(xpath = "//input[@id='ssn']")
    WebElement ssnField;

    @FindBy(xpath = "//input[@id='emailAddress']")
    WebElement emailAddressField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/label[1]/input[1]")
    WebElement genderInput;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement nextBtn;

    @FindBy(xpath = "//input[@id='address']")
    WebElement addressField;

    @FindBy(xpath = "//input[@id='locality']")
    WebElement localityField;

    @FindBy(xpath = "//input[@id='region']")
    WebElement regionField;

    @FindBy(xpath = "//input[@id='postalCode']")
    WebElement postalCodeField;

    @FindBy(xpath = "//input[@id='country']")
    WebElement countryField;

    @FindBy(xpath = "//input[@id='homePhone']")
    WebElement homePhone;

    @FindBy(xpath = "//input[@id='mobilePhone']")
    WebElement mobilePhone;

    @FindBy(xpath = "//input[@id='workPhone']")
    WebElement workPhone;

    @FindBy(xpath = "//input[@id='agree-terms']")
    WebElement agreeTermsBtn;

    @FindBy(xpath = "//button")
    WebElement registerBtn;

    public void verifySignUpPage(){
        Assert.assertTrue("you are not on the sign up page", titleLabel.isDisplayed());
    }

    public void clickOnTitleField() {
        Select titlesDropdown = new Select(titleField);
        titlesDropdown.selectByVisibleText("Mr.");
    }

    public void enterFirstName() {
        firstNameField.sendKeys("Tester");
    }

    public void enterLastName() {
        lastNameField.sendKeys("Testing");
    }

    public void clickOnGender() {
        genderInput.click();
    }

    public void enterDOB() {
        dobField.sendKeys("01/01/2001");
    }

    public void enterSSN() {
        ssnField.sendKeys("123456789");
    }

    public void enterEmailAddress(String username) {
        emailAddressField.sendKeys(ConfigReader.getConfigProperty(username));
    }

    public void enterValidPassword(String password) {
        passwordField.sendKeys(ConfigReader.getConfigProperty(password));
    }

    public void confirmPassword(String password) {
        confirmPasswordField.sendKeys(ConfigReader.getConfigProperty(password));
    }

    public void clickOnNextBtn(){
        nextBtn.click();
    }

    public void enterAddressField() {
        addressField.sendKeys("123 Digital Lane");
    }

    public void enterLocalityField() {
        localityField.sendKeys("Internet City");
    }

    public void enterRegionField() {
        regionField.sendKeys("CA");
    }

    public void enterPostalCode() {
        postalCodeField.sendKeys("12345");
    }

    public void enterCountry() {
        countryField.sendKeys("US");
    }

    public void enterHomePhone() {
        homePhone.sendKeys("(123) 123-4567");
    }

    public void enterMobilePhone() {
        mobilePhone.sendKeys("(123) 123-4567");
    }

    public void enterWorkPhone() {
        workPhone.sendKeys("(123) 123-4567");
    }

    public void clickAgreeBtn() {
        agreeTermsBtn.click();
    }

    public void clickRegisterBtn() {
        registerBtn.click();
    }
}
