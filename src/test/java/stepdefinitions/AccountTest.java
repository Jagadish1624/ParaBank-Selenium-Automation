package stepdefinitions;

import static org.testng.AssertJUnit.assertTrue;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.AccountsPage;

public class AccountTest {

    LoginPage login = new LoginPage();
    AccountsPage acc = new AccountsPage();

    @Then("account overview should display")
    public void account_overview_should_display() {
        assertTrue(acc.isOverviewVisible());
    }

    @Then("account balances should be visible")
    public void account_balances_should_be_visible() {
        assertTrue(acc.areBalancesVisible());
    }
}
