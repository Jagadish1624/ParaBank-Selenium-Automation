package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import base.DriverSetup;
import utils.WaitUtil;

public class AccountsPage {

    public AccountsPage(){
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    @FindBy(xpath="//a[contains(text(),'Log Out')]")
    WebElement overview;

    @FindBy(id="accountTable")
    WebElement accountsTable;

    @FindBy(css="a[href*='logout']")
    WebElement logout;
    
    @FindBy(name = "username")
    WebElement usernameField;

    public boolean isLoginDisplayed() {
        return WaitUtil.waitForVisibility(usernameField).isDisplayed();
    }

    public boolean isOverviewVisible(){
        return WaitUtil.waitForVisibility(overview).isDisplayed();
    }

    public boolean areBalancesVisible(){
        return WaitUtil.waitForVisibility(accountsTable).isDisplayed();
    }

    public void logout(){
        WaitUtil.waitForVisibility(logout).click();

        // optional but VERY stabilizing
        WaitUtil.waitForVisibility(usernameField);
    }
   
}
