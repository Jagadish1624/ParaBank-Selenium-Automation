package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless=new");
    	options.addArguments("--disable-notifications");
    	options.addArguments("--disable-save-password-bubble");
    	options.addArguments("--disable-infobars");
    	options.addArguments("--disable-autofill");

    	EdgeOptions edgeoptions = new EdgeOptions();
    	 edgeoptions.addArguments("--headless=new");
         edgeoptions.addArguments("--disable-gpu");
         edgeoptions.addArguments("--window-size=1920,1080");
         edgeoptions.addArguments("--disable-notifications");
     	edgeoptions.addArguments("--disable-save-password-bubble");
     	edgeoptions.addArguments("--disable-infobars");
     	edgeoptions.addArguments("--disable-autofill");

        String browser = ConfigLoader.get("browser");

        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
        else {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver(edgeoptions));
        }

        getDriver().manage().window().maximize();

        // ALWAYS navigate after driver is fully ready
        getDriver().get(ConfigLoader.get("url"));
    }

    public static void quit() {

        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}
