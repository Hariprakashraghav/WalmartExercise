package execrise;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import config.Configuration;

/*
Add couple of items in the cart and verify if the sub-total is displayed correctly.
precondition of the test is the item should be available to add to cart
*/

public class Test03{

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
	public void priceCheck() throws NoSuchElementException, InterruptedException {
		try {
			driver.findElement(By.xpath("//button[@data-automation=\"cta-button\"]")).click();
			String currPrice = driver.findElement(By.xpath("//Span[@data-automation=\"atcmodal-price\"]")).getText();
			driver.findElement(By.xpath("//*[@id=\"atc-root\"]//button[@data-automation=\"increase-qty\"]")).click();
			
			String totItems;
			for(int i = 0 ; i< 10 ; i++) {
				totItems = driver.findElement(By.xpath("//*[@id=\"atc-root\"]//div[@data-automation=\"atcmodal-cart-count\"]")).getText();
				if(totItems.contentEquals("2 items")) {
					break;
				}
				Thread.sleep(1000);
			}
			
			String newCurrPrice = driver.findElement(By.xpath("//div[@data-automation=\"atcmodal-subtotal\"]//span[contains(@aria-label,\"Now\")]")).getText();
			
			currPrice = currPrice.substring(1, currPrice.length());
			newCurrPrice = newCurrPrice.substring(1, newCurrPrice.length());
			float expectedTotal = Float.parseFloat(currPrice)*2;
			float actualTotal = Float.parseFloat(newCurrPrice);
			
			Assert.assertEquals(expectedTotal, actualTotal, "Subtotal is not expected");
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Configuration.ScreenshotPath + "\\Test03.jpg"));
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
