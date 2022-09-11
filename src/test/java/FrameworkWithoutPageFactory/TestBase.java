package FrameworkWithoutPageFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	WebDriver driver;
	Driver driverClassObj;
	PageLogin loginPage;
	PageHome homePage;
	
	@BeforeTest
	public void setup() {
		
		driverClassObj = new Driver();
		driver = driverClassObj.getDriver("local");
		loginPage = new PageLogin(driver);
		homePage = new PageHome(driver);
	}
	
	
	@AfterTest
	public void tearDown() {
		driverClassObj.closeDriver();
	}
	
	

}
