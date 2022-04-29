package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import GenericLib.DriverManager;

public class TestBase {
	
WebDriver driver=null;
	
	@BeforeTest
	public void setup()  {
		DriverManager dm=new DriverManager();
		driver = dm.newBrowser("chrome");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
