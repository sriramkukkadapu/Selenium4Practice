package FrameworkWithoutPageFactory;

import org.testng.annotations.Test;

public class Testcase1 extends TestBase {

	@Test
	public void testEcommercePositive() throws InterruptedException  {
			
		driver.get("https://rahulshettyacademy.com/client/");		
		loginPage.loginToApp("sriramkukkadapu@gmail.com","Test1234!");				
		homePage.verifyHomePageLaunched();	
		
	}
	
	
	@Test
	public void testEcommerceNegative() throws InterruptedException  {
		driver.get("https://rahulshettyacademy.com/client/");		
		loginPage.loginToApp("sriramkukkadapu@gmail.com","invalid");				
		homePage.verifyHomePageNotLaunched();				
	}
	
}
