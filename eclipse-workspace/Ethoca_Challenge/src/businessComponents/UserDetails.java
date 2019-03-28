package businessComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import objectRepo.BillingInfo;

public class UserDetails {
	public static void enterUserDetails(WebDriver driver) {
		BillingInfo.txtEmail(driver).sendKeys("test@gmail.com");
		BillingInfo.txtFirstname(driver).sendKeys("Fname");
		BillingInfo.txtLastName(driver).sendKeys("Lname");
		BillingInfo.txtBillingAddress(driver).sendKeys("45 Kingst.");
		BillingInfo.txtBillingCity(driver).sendKeys("Toronto");
		BillingInfo.txtBillingState(driver).sendKeys("ON");
		
		Select Country = new Select(BillingInfo.txtBillingCountry(driver));
		Country.selectByVisibleText("Canada");
		
		BillingInfo.txtBillingPhone(driver).sendKeys("6475235400");
		BillingInfo.txtshippingState(driver).sendKeys("ON");
	}
}
