package stepdefinitions;

import static org.testng.AssertJUnit.assertTrue;

import io.cucumber.java.en.*;
import pages.TransferFundsPage;

public class TransferFundsTest {

    TransferFundsPage transfer = new TransferFundsPage();

    @When("user opens transfer funds")
    public void user_opens_transfer_funds() {
        transfer.openTransfer();
        assertTrue(transfer.isTransferPageDisplayed());
    }


    @Then("transfer page should display")
    public void transfer_page_should_display() {
        assertTrue(transfer.isTransferPageDisplayed());
    }

    @When("user transfers valid amount")
    public void user_transfers_valid_amount() {
        transfer.transferValidAmount();
    }


    @Then("transfer success message should appear")
    public void transfer_success_message_should_appear() {
        assertTrue(transfer.isTransferSuccess());
    }

    @When("user transfers invalid amount")
    public void user_transfers_invalid_amount() {
        transfer.transferInvalidAmount();
    }

    @Then("error message should displayed")
    public void error_message_should_displayed() {
        assertTrue(transfer.isErrorDisplayed());
    }
}
