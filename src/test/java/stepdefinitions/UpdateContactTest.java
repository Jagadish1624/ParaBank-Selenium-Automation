package stepdefinitions;

import static org.testng.AssertJUnit.assertTrue;

import io.cucumber.java.en.*;
import pages.UpdateContactPage;

public class UpdateContactTest {

    UpdateContactPage update = new UpdateContactPage();

    @When("user opens update contact")
    public void user_opens_update_contact() {
        update.openUpdate();
        assertTrue(update.isUpdatePageDisplayed());
    }

    @Then("update page should display")
    public void update_page_should_display() {
        assertTrue(update.isUpdatePageDisplayed());
    }

    @When("user updates valid contact info")
    public void user_updates_valid_contact_info() {
        update.updateCity("Hyderabad");
    }

    @Then("updated info should be saved")
    public void updated_info_should_be_saved() {
        assertTrue(update.isUpdateSuccess());
    }

    @When("user enters invalid contact info")
    public void user_enters_invalid_contact_info() {
        update.updateCity(""); // blank value
    }

    @Then("validation errors appear")
    public void validation_errors_appear() {
        assertTrue(update.isErrorDisplayed());
    }
}
