package utils;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import base.ConfigLoader;
import base.DriverSetup;

public class WaitUtil {

    private static WebDriverWait getWait(){

        return new WebDriverWait(
                DriverSetup.getDriver(),
                Duration.ofSeconds(
                        Integer.parseInt(ConfigLoader.get("timeout"))
                )
        );
    }

    public static WebElement waitForVisibility(WebElement element){
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebElement element){
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
}
