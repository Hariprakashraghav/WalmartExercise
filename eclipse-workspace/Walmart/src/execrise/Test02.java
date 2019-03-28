package execrise;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Configuration;

/*
this test is to check if left pane images are clicked we get the enlarged picture of the same.
precondition of the test is to have the images available in the item page.
*/

public class Test02 {
	public static WebDriver driver;
	
	@BeforeTest
	public void iniTest() {
		System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
		driver = new ChromeDriver();
		driver.get("https://www.walmart.ca/en/ip/Intex-8-x-30-Easy-Set-Inflatable-Swimming-Pool-w-330-GPH-GFCI-Filter-Pump/PRD1AC2BNHQI0Y2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void imageClick() throws NoSuchElementException, InterruptedException, IOException {
		
		try {
			String currPresentedpic = null;
			String displayedPic;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			List<WebElement> img = driver.findElements(By.xpath("//div[contains(@aria-label,'view product image')]"));
			for(WebElement pic:img) {
				String line = pic.getAttribute("style");
				Pattern p = Pattern.compile("\"([^\"]*)\"");
				Matcher m = p.matcher(line);
				
				while (m.find()) {
					currPresentedpic = "";
					currPresentedpic = m.group(1);
				}
				
				js.executeScript("arguments[0].scrollIntoView();", pic);
				pic.click();
				Thread.sleep(2000);
				
				displayedPic = driver.findElement(By.xpath("//div[@tabindex =\"0\"]//div[@role=\"presentation\"]/img[1]")).getAttribute("src");
				
				Assert.assertEquals(displayedPic, currPresentedpic, "Clicked Picture is not displayed");
				
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Configuration.ScreenshotPath + "\\Test02.jpg"));
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@AfterTest
	public void wrapper() {
		driver.close();
		driver.quit();
	}

}
