package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import base.DriverSetup;
import utils.WaitUtil;

public class TransferFundsPage {

    public TransferFundsPage(){
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    @FindBy(css="a[href*='transfer']")
    WebElement transferLink;

    @FindBy(id="amount")
    WebElement amount;

    @FindBy(xpath="//input[@value='Transfer']")
    WebElement transferBtn;

    @FindBy(xpath="//h1[contains(text(),'Transfer')]")
    WebElement success;

    @FindBy(xpath="//*[contains(text(),'error') or contains(text(),'Error')]")
    WebElement error;

    @FindBy(xpath="//h1[contains(text(),'Transfer Funds')]")
    WebElement transferHeader;


    // ---------- Navigation ----------

    public void openTransfer(){
        WaitUtil.waitForVisibility(transferLink).click();
    }


    // ---------- VALID TRANSFER ----------

    public void transferValidAmount(){

        WebElement amtField = WaitUtil.waitForVisibility(amount);

        amtField.clear();
        amtField.sendKeys("100");  

        WaitUtil.waitForVisibility(transferBtn).click();
    }


    // ---------- INVALID TRANSFER ----------

    public void transferInvalidAmount(){

        WebElement amtField = WaitUtil.waitForVisibility(amount);

        amtField.clear(); 

        WaitUtil.waitForVisibility(transferBtn).click();
    }


    // ---------- VALIDATIONS ----------

    public boolean isTransferSuccess(){
        return WaitUtil.waitForVisibility(success).isDisplayed();
    }

    public boolean isErrorDisplayed(){
        return WaitUtil.waitForVisibility(error).isDisplayed();
    }

    public boolean isTransferPageDisplayed(){
        return WaitUtil.waitForVisibility(transferHeader).isDisplayed();
    }
}
