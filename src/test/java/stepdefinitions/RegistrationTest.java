package stepdefinitions;

import static org.testng.AssertJUnit.assertTrue;

import io.cucumber.java.en.*;
import pages.RegistrationPage;

public class RegistrationTest {

    RegistrationPage reg = new RegistrationPage();

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        // Driver already opens URL via Hooks
    }

    @When("the user clicks on the register link")
    public void the_user_clicks_on_the_register_link() {

        reg.openRegister();
        assertTrue(reg.isRegistrationPageDisplayed());
    }

    @Then("the registration page should be displayed")
    public void the_registration_page_should_be_displayed() {
        assertTrue(reg.isRegistrationPageDisplayed());
    }

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        reg.openRegister();
        assertTrue(reg.isRegistrationPageDisplayed());
    }

    @When("the user enters valid registration details")
    public void the_user_enters_valid_registration_details() {
        reg.registerValidUser();
    }

    @When("submits the registration form")
    public void submits_the_registration_form() {
        // Already clicked inside registerValidUser
    }

    @Then("a success message should be displayed")
    public void a_success_message_should_be_displayed() {
        assertTrue(reg.isRegistrationSuccess());
    }

    @When("the user submits the form without mandatory fields")
    public void the_user_submits_the_form_without_mandatory_fields() {
        reg.registerWithMissingFields();
        try { Thread.sleep(2000); } 
        catch (InterruptedException e) { 
        	e.printStackTrace(); 
        	}
    }

    @Then("validation error messages should be displayed")
    public void validation_error_messages_should_be_displayed() {
    	assertTrue(reg.areErrorsDisplayed());
    }
}
