package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import base.DriverSetup;
import utils.WaitUtil;

public class UpdateContactPage {

    public UpdateContactPage(){
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    @FindBy(css="a[href*='updateprofile']")
    WebElement updateLink;

    @FindBy(id="customer.address.city")
    WebElement city;

    @FindBy(xpath="//input[@value='Update Profile']")
    WebElement updateBtn;

    @FindBy(xpath="//h1[contains(text(),'Profile')]")
    WebElement profileHeader;

    @FindBy(xpath="//*[contains(@class,'error')]")
    WebElement error;

    @FindBy(xpath="//h1[contains(text(),'Update Profile')]")
    WebElement updateHeader;

    public void openUpdate(){
        WaitUtil.waitForVisibility(updateLink).click();
    }

    public void updateCity(String newCity){

        WebElement cityField = WaitUtil.waitForVisibility(city);

        cityField.clear();
        cityField.sendKeys(newCity);

        WaitUtil.waitForVisibility(updateBtn).click();
    }

    public boolean isUpdateSuccess(){
        return WaitUtil.waitForVisibility(profileHeader).isDisplayed();
    }

    public boolean isErrorDisplayed(){
        return WaitUtil.waitForVisibility(error).isDisplayed();
    }

    public boolean isUpdatePageDisplayed(){
        return WaitUtil.waitForVisibility(updateHeader).isDisplayed();
    }
}
