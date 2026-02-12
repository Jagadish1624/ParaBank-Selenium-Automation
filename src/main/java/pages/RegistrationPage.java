package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverSetup;
import utils.WaitUtil;

public class RegistrationPage {

    public RegistrationPage(){
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }
    public static String registeredUsername;
    public static String registeredPassword = "Jaggureddy";


    @FindBy(linkText="Register")
    WebElement registerLink;

    @FindBy(id="customer.firstName")
    WebElement firstName;

    @FindBy(id="customer.lastName")
    WebElement lastName;

    @FindBy(id="customer.address.street")
    WebElement address;

    @FindBy(id="customer.address.city")
    WebElement city;

    @FindBy(id="customer.address.state")
    WebElement state;

    @FindBy(id="customer.address.zipCode")
    WebElement zip;

    @FindBy(id="customer.phoneNumber")
    WebElement phone;

    @FindBy(id="customer.ssn")
    WebElement ssn;

    @FindBy(id="customer.username")
    WebElement username;

    @FindBy(id="customer.password")
    WebElement password;

    @FindBy(id="repeatedPassword")
    WebElement confirm;

    @FindBy(xpath="//input[@value='Register']")
    WebElement registerBtn;

    @FindBy(xpath="//h1[contains(text(),'Signing up is easy')]")
    WebElement registerHeader;

    @FindBy(xpath="//h1[contains(text(),'Welcome')]")
    WebElement success;

    @FindBy(css = ".error")
    List<WebElement> errors;

    public void openRegister(){
        WaitUtil.waitForVisibility(registerLink).click();
    }

    public void registerValidUser(){

        registeredUsername = "SkReddy" + System.currentTimeMillis();

        WaitUtil.waitForVisibility(firstName).sendKeys("ATLA JAGADISHWAR");
        lastName.sendKeys("REDDY");
        address.sendKeys("ALLAGADDA");
        city.sendKeys("NANDYAL");
        state.sendKeys("ANDHRA PRADESH");
        zip.sendKeys("518155");
        phone.sendKeys("9381822831");
        ssn.sendKeys("7789");

        username.sendKeys(registeredUsername);
        password.sendKeys(registeredPassword);
        confirm.sendKeys(registeredPassword);

        registerBtn.click();
    }

    public boolean isRegistrationSuccess(){
        return WaitUtil.waitForVisibility(success).isDisplayed();
    }
    	public void registerWithMissingFields(){
    	    WaitUtil.waitForVisibility(registerBtn).click();
    	}

    

    	public boolean areErrorsDisplayed(){
    	    try {
    	        WebDriverWait wait = new WebDriverWait(
    	            DriverSetup.getDriver(), 
    	            Duration.ofSeconds(10)
    	        );
    	        wait.until(ExpectedConditions.visibilityOfAllElements(errors));
    	        return errors.size() > 0;
    	    } catch (Exception e) {
    	        return errors.size() > 0;
    	    }
    	}
    public boolean isRegistrationPageDisplayed(){
        return WaitUtil.waitForVisibility(registerHeader).isDisplayed();
    }

}
