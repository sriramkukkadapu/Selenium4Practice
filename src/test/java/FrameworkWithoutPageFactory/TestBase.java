package FrameworkWithoutPageFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {
	
	WebDriver driver;
	DriverSafe driverClassObj;
	PageLogin loginPage;
	PageHome homePage;
	
	@Parameters ({"browser"})
	@BeforeClass
	public void setup(String browser) {
		
		driverClassObj = new DriverSafe();
		driver = driverClassObj.getDriver("local", browser);
		loginPage = new PageLogin(driver);
		homePage = new PageHome(driver);
	}
	
	
	@AfterClass
	public void tearDown() {
		driverClassObj.closeDriver();
	}
	
	

}