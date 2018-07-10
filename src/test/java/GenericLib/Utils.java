package GenericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public void checkElementPresent(WebDriver driver,WebElement ele)
	{
		//
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementClickable(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public boolean isElementDisplayed(WebElement ele)
	{
		if(ele.isDisplayed())
			return true;
		else
			return false;
	}
	
}
