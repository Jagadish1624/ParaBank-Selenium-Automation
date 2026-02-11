package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
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

        String browser = ConfigLoader.get("browser");

        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(options));
        }
        else {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
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
