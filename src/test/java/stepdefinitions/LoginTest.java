package stepdefinitions;

import static org.testng.AssertJUnit.assertTrue;

import io.cucumber.java.en.*;
import pages.LoginPage;
import base.ConfigLoader;
import base.DriverSetup;

public class LoginTest {

    LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {

        DriverSetup.getDriver().get(
                ConfigLoader.get("url")
        );
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String user, String pass) {

        // Pull from config when placeholders used
        if(user.equals("${username}")){
            user = ConfigLoader.get("username");
        }

        if(pass.equals("${password}")){
            pass = ConfigLoader.get("password");
        }

        loginPage.login(user, pass);
    }

    @Then("{string} should be displayed")
    public void result_should_be_displayed(String result) {

        if(result.equalsIgnoreCase("success")){

            assertTrue(
                    "Login was expected to succeed but failed",
                    loginPage.isLoginSuccessful()
            );
        }
        else{

            assertTrue(
                    "Error message not displayed for invalid login",
                    loginPage.isErrorDisplayed()
            );
        }
    }

    @Then("login page elements should be visible")
    public void login_page_elements_should_be_visible() {

        assertTrue(loginPage.areLoginElementsVisible());
    }
}
