package exercise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import businessComponents.BusinessComponents;
import utilities.SingletonDriver;

//this test is to order a Magic Mouse using the main methods


public class Test01 {
		public static WebDriver driver = null;
		BusinessComponents tc01 = new BusinessComponents();
		
		@BeforeTest
		public void iniTest() {
			driver = SingletonDriver.getInstanceOfDriver();
		}
	
		@Test()
		public void TestCase01() {
			tc01.login(driver);
			tc01.selectItem(driver,"Magic Mouse");
			tc01.validateProductSelect(driver,"Magic Mouse");
			tc01.enterUserDetails(driver);
			tc01.validateTranPage(driver,"Magic Mouse");
		}
		
		@AfterTest
		public void cleanUp() {
			driver.close();
			SingletonDriver.quitDriver();
		}
		
	}

