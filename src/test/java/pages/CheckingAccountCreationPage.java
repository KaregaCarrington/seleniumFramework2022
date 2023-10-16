package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckingAccountCreationPage {

    @FindBy(xpath = "//h1[@id='page-title']")
    WebElement CreateCheckingTitle;


    public void verifyCreateCheckingTitle() {
        Assert.assertTrue("Title is not displayed", CreateCheckingTitle.isDisplayed());
        Assert.assertTrue("Create Checking title does not match", CreateCheckingTitle.getText().equalsIgnoreCase("Create Checking"));
    }


    public void clickOnCheckingAccountType() {

    }
}
