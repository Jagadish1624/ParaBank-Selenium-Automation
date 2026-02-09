package stepdefinitions;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.ConfigLoader;

public class LoginTest {

    LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {

        loginPage.login(ConfigLoader.get("username"),ConfigLoader.get("password"));
    }

    @Then("user should navigate to account overview")
    public void user_should_navigate_to_account_overview() {

        assertTrue(loginPage.isLoginSuccessful());
    }

    @When("user enters invalid username")
    public void user_enters_invalid_username() {

        loginPage.login("rajudanger3", ConfigLoader.get("password"));
    }

    @When("user enters invalid password")
    public void user_enters_invalid_password() {

        loginPage.login(ConfigLoader.get("username"), "skr");
    }

    @When("user clicks login without entering credentials")
    public void user_clicks_login_without_entering_credentials() {

        loginPage.login("", "");
    }

    @Then("error message should display")
    public void error_message_should_display() {

    	assertTrue(
    		    loginPage.getErrorMessage().length() > 0
    		);
    }

    @Then("login page elements should be visible")
    public void login_page_elements_should_be_visible() {

        assertFalse(loginPage.isLoginSuccessful());
    }
}
