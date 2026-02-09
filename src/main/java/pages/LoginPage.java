package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.support.*;

import base.DriverSetup;
import utils.WaitUtil;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(
                DriverSetup.getDriver(), this);
    }

    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
     WebElement password;

    @FindBy(xpath="//input[@value='Log In']")
    WebElement loginBtn;

    @FindBy(xpath="//p[contains(@class,'error')]")
    WebElement errorMsg;


    @FindBy(linkText="Accounts Overview")
    WebElement accountsOverview;

    public void login(String user, String pass){

        WebElement userField = WaitUtil.waitForVisibility(username);
        userField.sendKeys(user);

        WebElement passField = WaitUtil.waitForVisibility(password);
        passField.clear();
        passField.sendKeys(pass);

        WaitUtil.waitForClickable(loginBtn).click();
    }

    public boolean isLoginSuccessful(){

        return DriverSetup.getDriver().getCurrentUrl().contains("overview");
    }
    public String getErrorMessage() {
        return WaitUtil.waitForVisibility(errorMsg).getText();
    }
}

