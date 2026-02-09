package stepdefinitions;

import static org.testng.AssertJUnit.assertTrue;

import io.cucumber.java.en.*;
import pages.AccountsPage;

public class LogoutTest {

    AccountsPage acc = new AccountsPage();

    @When("user clicks logout")
    public void user_clicks_logout() {

        acc.logout();
    }

    @Then("session should terminate")
    public void session_should_terminate() {

        assertTrue(acc.isLoginDisplayed());
    }
}
