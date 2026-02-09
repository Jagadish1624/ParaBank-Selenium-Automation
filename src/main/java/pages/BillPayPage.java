package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import base.DriverSetup;
import utils.WaitUtil;

public class BillPayPage {

    public BillPayPage(){
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    @FindBy(css="a[href*='billpay']")
    WebElement billPay;

    @FindBy(name="payee.name")
    WebElement payeeName;

    @FindBy(name="payee.address.street")
    WebElement address;

    @FindBy(name="payee.address.city")
    WebElement city;

    @FindBy(name="payee.address.state")
    WebElement state;

    @FindBy(name="payee.address.zipCode")
    WebElement zip;

    @FindBy(name="payee.phoneNumber")
    WebElement phone;

    @FindBy(name="payee.accountNumber")
    WebElement account;

    @FindBy(name="verifyAccount")
    WebElement verifyAccount;

    @FindBy(name="amount")
    WebElement amount;

    @FindBy(xpath="//input[@value='Send Payment']")
    WebElement sendPayment;

    @FindBy(xpath="//*[contains(text(),'Welcome')]")
    WebElement success;
    
    @FindBy(xpath="//h1[contains(text(),'Bill Payment Service')]")
    WebElement billPayHeader;

    @FindBy(xpath="//*[contains(@class,'error')]")
    WebElement error;

    public void openBillPay(){

        WebElement bill =
                WaitUtil.waitForVisibility(billPay);

        // tiny stabilization delay via re-check
        if(!bill.isDisplayed()){
            bill = WaitUtil.waitForVisibility(billPay);
        }

        bill.click();
    }
    public void payValidBill(){

        WaitUtil.waitForVisibility(payeeName).sendKeys("Test User");
        WaitUtil.waitForVisibility(address).sendKeys("Street");
        WaitUtil.waitForVisibility(city).sendKeys("City");
        WaitUtil.waitForVisibility(state).sendKeys("TS");
        WaitUtil.waitForVisibility(zip).sendKeys("500001");
        WaitUtil.waitForVisibility(phone).sendKeys("9999999999");

        WaitUtil.waitForVisibility(account).sendKeys("12345");
        WaitUtil.waitForVisibility(verifyAccount).sendKeys("12345");

        WaitUtil.waitForVisibility(amount).sendKeys("100");

        WaitUtil.waitForClickable(sendPayment).click();
    }

    public void payInvalidBill(){

        // Do NOT fill mandatory fields
        WaitUtil.waitForVisibility(amount).sendKeys("100");

        sendPayment.click();
    }
    public boolean isPaymentSuccess(){
        return WaitUtil.waitForVisibility(success).isDisplayed();
    }
    
    public boolean isBillPayPageDisplayed(){
        return WaitUtil.waitForVisibility(billPayHeader).isDisplayed();
    }
    
    public boolean isErrorDisplayed(){
        return WaitUtil.waitForVisibility(error).isDisplayed();
    }
}
