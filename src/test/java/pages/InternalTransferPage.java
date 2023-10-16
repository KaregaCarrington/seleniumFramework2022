package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;


public class InternalTransferPage extends BasePage {

    @FindBy(id = "fromAccount")
    WebElement fromAccountDropdown;

    @FindBy(id = "toAccount")
    WebElement toAccountDropdown;

    @FindBy(id = "amount")
    WebElement amountInput;

    @FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
    WebElement submitBtn;

    public void verifyInternalTransferPage() {
        Assert.assertTrue("Internal transfer page is not displayed", fromAccountDropdown.isDisplayed());
        Assert.assertTrue("Internal transfer page is not displayed", toAccountDropdown.isDisplayed());
    }

    public void selectFromAccount(String fromAccount) {
        Select select = new Select(fromAccountDropdown);
        select.selectByVisibleText(ConfigReader.getConfigProperty(fromAccount));
    }

    public void selectToAccount(String toAccount) {
        Select select = new Select(toAccountDropdown);
        select.selectByVisibleText(ConfigReader.getConfigProperty(toAccount));
    }

    public void enterAmount(String amount) {
        amountInput.sendKeys(ConfigReader.getConfigProperty(amount));
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }
}

