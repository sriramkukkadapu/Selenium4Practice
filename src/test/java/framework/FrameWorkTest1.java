package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GenericLib.DriverManager;
import PageObjects.ProductsHome;

public class FrameWorkTest1 {

	WebDriver driver=null;
	
	@BeforeTest
	public void setup()  {
		DriverManager dm=new DriverManager();
		driver = dm.newBrowser("chrome");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}
	
	@Test
	public void test() throws InterruptedException {
		ProductsHome homePage=new ProductsHome(driver);
		homePage.enterTextInSearchBox("broco");
		Thread.sleep(3000);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
