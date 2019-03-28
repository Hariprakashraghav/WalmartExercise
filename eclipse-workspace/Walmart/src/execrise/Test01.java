package execrise;

import java.io.File;
import java.io.IOException;
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
this test is to check if all the sections are displayed for the given item page.
the mandatory sections validated are description, specifications, Return policy, Pickup, shipping, and Find in Store.
*/

public class Test01{

	public static WebDriver driver;
	
	@BeforeTest
	public void iniTest() {
		System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
		driver = new ChromeDriver();
		driver.get("https://www.walmart.ca/en/ip/intex-metal-frame-pool/6000166640889");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void mandatorySections() throws IOException {
		
		boolean description = driver.findElement(By.xpath("//*[text()=" + " \"Description\" " + "]")).isDisplayed();
		Assert.assertEquals(description, true, "Description section is Not displayed");
		
		boolean spec = driver.findElement(By.xpath("//*[text()=" + " \"Specifications\" " + "]")).isDisplayed();
		Assert.assertEquals(spec, true, "Specification section is Not displayed");
		
		boolean retunPolicy = driver.findElement(By.xpath("//*[text()=" + " \"Return policy\" " + "]")).isDisplayed();
		Assert.assertEquals(retunPolicy, true, "Return policy section is Not displayed");
		
		boolean pickUp = driver.findElement(By.xpath("//*[text()=" + " \"Pickup\" " + "]")).isDisplayed();
		Assert.assertEquals(pickUp, true, "pickUp section is Not displayed");
		
		boolean shipping = driver.findElement(By.xpath("//*[text()=" + " \"Shipping\" " + "]")).isDisplayed();
		Assert.assertEquals(shipping, true, "Shipping section is Not displayed");
		
		boolean findInStore = driver.findElement(By.xpath("//*[text()=" + " \"Find in-store\" " + "]")).isDisplayed();
		Assert.assertEquals(findInStore, true, "findInStore section is Not displayed");
		
		boolean ratingReview = driver.findElement(By.xpath("//*[text()=" + " \"Ratings & reviews\" " + "]")).isDisplayed();
		Assert.assertEquals(ratingReview, true, "ratingReview section is Not displayed");
		
		boolean questionAnswer = driver.findElement(By.xpath("//*[text()=" + " \"Questions & answers\" " + "]")).isDisplayed();
		Assert.assertEquals(questionAnswer, true, "questionAnswer section is Not displayed");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(Configuration.ScreenshotPath + "\\Test01.jpg"));
		
	}
	
	@AfterTest
	public void wrapper() {
		driver.close();
		driver.quit();
	}
	
}
