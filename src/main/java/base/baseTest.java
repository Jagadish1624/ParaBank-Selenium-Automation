//package base;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//import utils.ScreenshotUtil;
//
//import java.lang.reflect.Method;
//
//public class baseTest {
//
//    @BeforeMethod
//    public void setup() {
//        DriverSetup.initDriver();
//    }
//
//    @AfterMethod
//    public void tearDown(Method method) {
//
//        // Capture screenshot if test fails
//        if(org.testng.Reporter.getCurrentTestResult().getStatus() == 2) {
//            ScreenshotUtil.capture(method.getName());
//        }
//
//        DriverSetup.quit();
//    }
//}