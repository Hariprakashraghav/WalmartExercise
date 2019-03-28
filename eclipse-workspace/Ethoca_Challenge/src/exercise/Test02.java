package exercise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import businessComponents.BusinessComponents;
import utilities.SingletonDriver;

////this test is to order a Apple TV using the main methods

public class Test02 {

		public static WebDriver driver = null;
		BusinessComponents tc02 = new BusinessComponents();
		
		@BeforeTest
		public void iniTest() {
			driver = SingletonDriver.getInstanceOfDriver();
		}
		
		@Test(priority=1)
		public void login() {
			tc02.login(driver);
		}
		
		@Test(priority=2)
		public void SelectItem() {
			tc02.selectItem(driver,"Apple TV");
		}
		
		@Test(priority=3)
		public void validateProduct_Select() {
			tc02.validateProductSelect(driver,"Apple TV");
		}
		
		@Test(priority=4)
		public void enterUserDetails() {
			tc02.enterUserDetails(driver);
		}
		
		@Test(priority=5)
		public void validateTranPage() {
			tc02.validateTranPage(driver,"Apple TV");
		}
		
		@AfterTest
		public void cleanUp() {
			driver.close();
			SingletonDriver.quitDriver();
		}		
	}

