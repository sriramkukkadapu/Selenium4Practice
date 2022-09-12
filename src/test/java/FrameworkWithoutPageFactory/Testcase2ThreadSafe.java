package FrameworkWithoutPageFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase2ThreadSafe {

	WebDriver driver;
	DriverSafe driverClassObj;
	PageLogin loginPage;
	PageHome homePage;
	
	@BeforeMethod
	public void setup() {
		
		driverClassObj = new DriverSafe();
		driver = driverClassObj.getDriver("local");
		loginPage = new PageLogin(driver);
		homePage = new PageHome(driver);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void testPositive() throws InterruptedException  {
			
		driver.get("https://rahulshettyacademy.com/client/");		
		loginPage.loginToApp("sriramkukkadapu@gmail.com","Test1234!");				
		homePage.verifyHomePageLaunched();	
		
	}
	
	
	@Test
	public void testNegative() throws InterruptedException  {
		driver.get("https://rahulshettyacademy.com/client/");		
		loginPage.loginToApp("sriramkukkadapu@gmail.com","invalid");				
		homePage.verifyHomePageNotLaunched();				
	}
	
}
