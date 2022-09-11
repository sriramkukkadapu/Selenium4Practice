package FrameworkWithoutPageFactory;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Testcase1 extends TestBase {

	@Test
	public void testPositive() throws InterruptedException  {
			
		driver.get("https://rahulshettyacademy.com/client/");		
		loginPage.loginToApp("sriramkukkadapu@gmail.com","Test1234!");				
		homePage.verifyHomePageLaunched();	
		
//		Thread.sleep(2000);
	}
	
	
	@Test
	public void testNegative() throws InterruptedException  {
		driver.get("https://rahulshettyacademy.com/client/");		
		loginPage.loginToApp("sriramkukkadapu@gmail.com","invalid");				
		homePage.verifyHomePageNotLaunched();				
	}
	
}
