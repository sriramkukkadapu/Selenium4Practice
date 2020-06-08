package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingleTonDriverClassEx {

	WebDriver driver=null;
	
	@BeforeMethod
	public  void beforeMethod()
	{
		DriverInit driverObj=DriverInit.getInstance();
		driver=driverObj.openBrowser();
	}
	
	@Test
	public void testMethod()
	{
		System.out.println(driver);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
