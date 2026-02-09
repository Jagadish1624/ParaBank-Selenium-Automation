package stepdefinitions;

import static org.testng.AssertJUnit.assertTrue;

import io.cucumber.java.en.*;
import pages.BillPayPage;

public class BillPayTest {

    BillPayPage bill = new BillPayPage();

    @When("user opens bill pay")
    public void user_opens_bill_pay() {

        bill.openBillPay();
        assertTrue(bill.isBillPayPageDisplayed());
    }

    @Then("bill pay page should display")
    public void bill_pay_page_should_display() {
        assertTrue(bill.isBillPayPageDisplayed());
    }

    @When("user pays bill with valid data")
    public void user_pays_bill_with_valid_data() {
        bill.payValidBill();
    }

    @Then("bill payment confirmation appears")
    public void bill_payment_confirmation_appears() {

        assertTrue(bill.isPaymentSuccess());
    }

    @When("user pays bill with invalid data")
    public void user_pays_bill_with_invalid_data() {

        bill.payInvalidBill();
    }

    @Then("error should display")
    public void error_should_display() {

        assertTrue(bill.isErrorDisplayed());
    }
}
