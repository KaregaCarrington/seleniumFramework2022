package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy (xpath = "//li[@class='active']")
    WebElement welcomeTestMessage;

    @FindBy (id = "transfer-menu-item")
    WebElement transferItemMenu;

    public void verifyPage(){
        Assert.assertTrue("Welcome test message not visible could be on wrong page", welcomeTestMessage.isDisplayed());
    }

    public void clickOnTransferBetweenAccounts(){
        transferItemMenu.click();
    }
}
