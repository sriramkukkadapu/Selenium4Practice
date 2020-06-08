package Tests;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericLib.Driver;

public class HubSpot_SignUp {

	public static void main(String args[]) throws InterruptedException
	{
		Driver driverClassObj=new Driver();
		WebDriver driver=driverClassObj.openBrowser();
		
		driver.get("https://app.hubspot.com/login");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='https://app.hubspot.com/signup/crm']")).click();
		driver.quit();
		
	}
}
