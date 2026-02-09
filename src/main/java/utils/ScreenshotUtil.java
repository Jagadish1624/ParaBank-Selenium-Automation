package utils;

import base.DriverSetup;
import org.openqa.selenium.*;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

	public static void capture(String name) {

	    try {

	        File folder = new File("screenshots");
	        if(!folder.exists()){
	            folder.mkdir();
	        }

	        TakesScreenshot ts =
	                (TakesScreenshot) DriverSetup.getDriver();

	        File src = ts.getScreenshotAs(OutputType.FILE);

	        File dest =
	                new File("screenshots/" + name + ".png");

	        FileUtils.copyFile(src, dest);

	    } catch (Exception e) {
	        System.out.println("Screenshot failed");
	    }
	}

}
