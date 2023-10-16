package pages;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigReader;
import utilities.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAccountPage extends BasePage {

    @FindBy(xpath = "//div[@id='transactionTable_length']")
    WebElement transactionHistory;

    @FindBy(xpath = "//table[@id='transactionTable']//tbody/tr[1]/td[4]")
    WebElement amountTransferred;

    @FindBy(xpath = "//table[@id='transactionTable']//tbody/tr[1]/td[3]")
    WebElement transactionHistoryDescription;

    public void verifyAccountPage() {
        Assert.assertTrue("View account page is not displayed", transactionHistory.isDisplayed());
    }

    public void verifyTransactionHistory(){
        String actualAmountFromUI = amountTransferred.getText().substring(1);
        String expectedAmountFromCode = ConfigReader.getConfigProperty("transfer.amount");

        Assert.assertEquals("Transaction amount mismatch", expectedAmountFromCode, actualAmountFromUI);

        System.out.println("========UI TESTING========");
        System.out.println("actual amount from UI = " + actualAmountFromUI);
        System.out.println("expected amount from CODE = " + actualAmountFromUI);
    }

    public void verifyDetailsIntoDatabase(){
        try {
            // get TRN and description from UI
            String descriptionAndTRN = transactionHistoryDescription.getText();
            String TRN = descriptionAndTRN.split("-")[0].replace(" (TRN) ", "");
            String descriptionFromUI = descriptionAndTRN.split("-")[1].trim();
            // execute query and store result
            String query = "SELECT * FROM account_transaction WHERE transaction_number = '"+ TRN +"';";
            ResultSet rs = DatabaseUtils.executeQuery(query);
            rs.next();
            // Test amount from code with DB
            String expAmountFromCode = ConfigReader.getConfigProperty("transfer.amount");
            String actualAmountFromDB = rs.getString("amount");
            Assert.assertEquals("Amount mismatch in Database", expAmountFromCode, actualAmountFromDB);

            System.out.println("========DB TESTING========");
            System.out.println("actual amount from DB = " + actualAmountFromDB);
            System.out.println("expected amount from CODE = " + expAmountFromCode);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
