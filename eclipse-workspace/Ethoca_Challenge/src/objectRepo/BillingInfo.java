package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingInfo {
	public static WebElement txtEmail(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//label[@class = \"wpsc_email_address_label\"]//input"));
		return reqWE;
	}
	
	public static WebElement txtFirstname(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//input[@title = \"billingfirstname\"]"));
		return reqWE;
	}
	
	public static WebElement txtLastName(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//input[@title = \"billinglastname\"]"));
		return reqWE;
	}
	
	public static WebElement txtBillingAddress(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//textarea[@title = \"billingaddress\"]"));
		return reqWE;
	}
	
	public static WebElement txtBillingCity(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//input[@title = \"billingcity\"]"));
		return reqWE;
	}
	
	public static WebElement txtBillingState(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//input[@title = \"billingstate\"]"));
		return reqWE;
	}
	
	public static WebElement txtBillingCountry(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//select[@title = \"billingcountry\"]"));
		return reqWE;
	}
	
	public static WebElement txtBillingPhone(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//input[@title = \"billingphone\"]"));
		return reqWE;
	}
	
	public static WebElement txtshippingState(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//input[@placeholder = \"State/Province\"]"));
		return reqWE;
	}
}
