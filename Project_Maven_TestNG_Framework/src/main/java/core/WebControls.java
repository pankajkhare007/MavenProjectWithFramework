package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebControls extends WebDriverHelper {
	
	public static WebElement getWebElement(String locator) {
		
		String arr[] = locator.split("=");
		var locatorType = arr[0].toLowerCase().trim();
		var locatorValue = arr[1].trim();
		WebElement ele = null;
		if(locatorType.equals("xpath")) {
			ele = driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorType.equals("id")) {
			ele = driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equals("name")) {
			ele = driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.equals("innertext")) {
			ele = driver.findElement(By.linkText(locatorValue));
		}
		
		return ele;
	}
	
public static List<WebElement> getWebElements(String locator) {
		
		String arr[] = locator.split("=");
		var locatorType = arr[0].toLowerCase().trim();
		var locatorValue = arr[1].trim();
		List<WebElement> ele = null;
		if(locatorType.equals("xpath")) {
			ele = driver.findElements(By.xpath(locatorValue));
		}
		else if(locatorType.equals("id")) {
			ele = driver.findElements(By.id(locatorValue));
		}
		else if(locatorType.equals("name")) {
			ele = driver.findElements(By.name(locatorValue));
		}
		else if(locatorType.equals("innertext")) {
			ele = driver.findElements(By.linkText(locatorValue));
		}
		
		return ele;
	}
	
	public static void inputText(String obj,String inputText,String reportText) {
		WebElement ele = getWebElement(obj);
		ele.sendKeys(inputText);
		Report.testStep(reportText);
	}
	
	public static void clickOnObject(String obj,String reportText) {
		WebElement ele = getWebElement(obj);
		ele.click();
		Report.testStep(reportText);
	}
	
	public static boolean isElementPresent(String obj) {
        try {
            // Attempt to find at least one element using the given locator
            var elements = getWebElements(obj);

            // If elements.size() is greater than 0, at least one element was found
            return elements.size() > 0;
        } catch (Exception e) {
            // An exception occurred while trying to find the element
            return false;
        }
    }

}
