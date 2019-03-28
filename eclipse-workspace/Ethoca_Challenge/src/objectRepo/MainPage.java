package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	public static WebElement product_category(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.linkText("Product Category"));
		return reqWE;
	}
	
	public static WebElement product_menu(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.linkText("Accessories"));
		return reqWE;
	}
	
	public static WebElement checkOut(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//*[@title= \"Checkout\"]"));
		return reqWE;
	}
	
	public static WebElement checkOutQuantity(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//input[@name=\"quantity\"]"));
		return reqWE;
	}
	
	public static WebElement checkOutItem(WebDriver driver, String reqItem) {
		WebElement reqWE = driver.findElement(By.xpath("//input[@name=\"quantity\"]/../../..//*[text()=\"" + reqItem + "\"]"));
		return reqWE;
	}	
	
	public static WebElement btnContinue(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]//*[text()=\"Continue\"]"));
		return reqWE;
	}
	
	public static WebElement btnPurchase(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//input[@value=\"Purchase\"]"));
		return reqWE;
	}
	
	public static WebElement staTranPageTitle(WebDriver driver) {
		WebElement reqWE = driver.findElement(By.xpath("//*[@class=\"entry-title\"]"));
		return reqWE;
	}
	
	public static WebElement staFinalOrderQty(WebDriver driver, String reqitem) {
		WebElement reqWE = driver.findElement(By.xpath("//*[text()=\"" + reqitem + "\"]/following-sibling::td[2]"));
		return reqWE;
	}
}
