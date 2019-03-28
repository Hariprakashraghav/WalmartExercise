package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import config.Configuration;

public class Utilities {	
		public static void waitForPageLoad(WebDriver driver) {
	        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	}
		
		//this method is used to take the screenshot
		public static void takeScreenshot(WebDriver driver, String reqDesc) throws Exception {
			try {
				String timeStamp;
				File screenShotName;
				
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

				timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
				screenShotName = new File(Configuration.ScreenshotPath +timeStamp+ "-" + reqDesc + ".png");
				FileUtils.copyFile(scrFile, screenShotName);
				 
				String filePath = screenShotName.toString();
				String path = "<img src='" + filePath + "'";
				Reporter.log(path);
			}catch(Exception e) {
				Assert.fail("Error during screenshot");
			}

		}
}
