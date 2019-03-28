package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.Configuration;

//to create a WebDriver object and that would be used across the suite.


public class SingletonDriver {

	
    private static WebDriver driver1;

	
    // Constructor
    private SingletonDriver() {}

    // this method is to create a driver object
    public static WebDriver getInstanceOfDriver(){
        if(driver1==null){
        	
    		if(Configuration.browser.equalsIgnoreCase("Chrome")){

        		System.setProperty("webdriver.chrome.driver",Configuration.chromeDriverPath); 
        	
        		driver1 = new ChromeDriver();

	        } else if(Configuration.browser.equals("Firefox")){

	        	driver1 = new FirefoxDriver();
	        }
		
				driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
        }
        return driver1;
    }

    public static void quitDriver(){
        if (null != driver1){
            driver1.quit();
        }
        driver1 = null;
    }
    
}