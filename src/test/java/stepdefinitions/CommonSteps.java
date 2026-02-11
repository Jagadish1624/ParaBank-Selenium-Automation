package stepdefinitions;

import base.ConfigLoader;
import io.cucumber.java.en.Given;
import pages.LoginPage;

public class CommonSteps {

    LoginPage login = new LoginPage();

    @Given("user is logged in")
    public void user_is_logged_in() {

            login.login(
                    ConfigLoader.get("username"),
                    ConfigLoader.get("password")
            );
        }
    }
