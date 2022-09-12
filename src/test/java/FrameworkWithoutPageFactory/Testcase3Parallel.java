package FrameworkWithoutPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase3Parallel {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void testPositive() throws InterruptedException  {
			
		driver.get("https://rahulshettyacademy.com/client/");		
//		loginPage.loginToApp("sriramkukkadapu@gmail.com","Test1234!");				
//		homePage.verifyHomePageLaunched();	
		
	}
	
	
	@Test
	public void testNegative() throws InterruptedException  {
		driver.get("https://rahulshettyacademy.com/client/");		
//		loginPage.loginToApp("sriramkukkadapu@gmail.com","invalid");				
//		homePage.verifyHomePageNotLaunched();				
	}
	
}
