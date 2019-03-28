package businessComponents;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import config.Configuration;
import objectRepo.Accessories;
import objectRepo.MainPage;
import utilities.Utilities;


public class BusinessComponents {

	
//this method is to login into application
	
	public void login(WebDriver driver) {
		driver.get(Configuration.testURL);
		
		Utilities.waitForPageLoad(driver);
		
		String actPgTitle = driver.getTitle();
		
		Assert.assertTrue(actPgTitle.contains("Toolsqa"), "Page Not dispalyed");

	}
	
//this method is to select a item in the page
	public void selectItem(WebDriver driver, String reqItem) {
        WebElement mainMenu = MainPage.product_category(driver);
        
        try {
            Actions action = new Actions(driver);
            action.moveToElement(mainMenu).build().perform();
            
            MainPage.product_menu(driver).click();
            
            Utilities.waitForPageLoad(driver);
            
            Accessories.reqItem(driver, reqItem).click();

            Utilities.waitForPageLoad(driver);
            
            MainPage.checkOut(driver).click();
            
            Utilities.waitForPageLoad(driver);
            
        }catch (Exception e) {
			System.out.println(e);
			Assert.fail("Error has occured during product selection");
        	System.out.println("Error has occured during product selection");
        }
        
	}
	

//this method is to validate if only one item is selected and proceed further
	
	public void validateProductSelect(WebDriver driver, String reqItem) {
		boolean present;
		try {
			//to check the quantity is 1
			WebElement checkout_quantity = MainPage.checkOutQuantity(driver);
	        int totquantity = Integer.parseInt(checkout_quantity.getAttribute("value"));
	        Assert.assertEquals(totquantity, 1);
	        
	        //to check the required quantity is present
	        try {
	        	MainPage.checkOutItem(driver, reqItem);
	        	present = true;
	        }catch (NoSuchElementException e) {
	        	present = false;
	        }
	        
	        if (totquantity == 1 && present == true) {
	        	Utilities.takeScreenshot(driver, "ValdiateProduct");
	        	MainPage.btnContinue(driver).click();;
	        	MainPage.checkOut(driver);
	        	Utilities.waitForPageLoad(driver);
	        }
	        else {
				Assert.fail("Required number of item not selected");
	        }
		}catch (Exception e) {
				System.out.println(e);
				Assert.fail("Error has occured during Validating product");
				System.out.println("Error has occured during Validating product");
		}

	}

//this method is to enter the user details and purchase the product

	public void enterUserDetails(WebDriver driver) {
		try {
	        UserDetails.enterUserDetails(driver);
			MainPage.btnPurchase(driver).click();
			
			Utilities.waitForPageLoad(driver);
		}catch (Exception e) {
			System.out.println(e);
			Assert.fail("Error has occured during User entry details page");
			System.out.println("Error has occured during User entry details page");			
		}

	}
	
//this method is to validate if transaction page is displayed ensure only one item is selected for the ordered quantity
	public void validateTranPage(WebDriver driver, String reqItem) {
		try {
			String reqPgName= "Transaction Results";
	        String actPgName = MainPage.staTranPageTitle(driver).getText();
	        Assert.assertTrue(reqPgName.equals(actPgName), "Transaction page NOT displayed");
	        
	        String totQtyOrdered = MainPage.staFinalOrderQty(driver, reqItem).getText();
	        Assert.assertEquals(totQtyOrdered, "1");
			Utilities.takeScreenshot(driver,"TransactionPage");
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail("Error has occured during Transaction detail page");
			System.out.println("Error has occured during Transaction detail page");				
		}
	}

	

	
}

	
	