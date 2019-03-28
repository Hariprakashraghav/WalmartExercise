package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Accessories {
	public static WebElement reqItem(WebDriver driver, String reqitem) {
		WebElement ele_prod_cat = driver.findElement(By.xpath("//*[text() = \"" + reqitem +  "\"]/../../..//*[@name = \"Buy\"]"));
		return ele_prod_cat;
	}
}
