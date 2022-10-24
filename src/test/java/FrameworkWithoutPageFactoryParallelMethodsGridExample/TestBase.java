package FrameworkWithoutPageFactoryParallelMethodsGridExample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	WebDriver driver;
	DriverSafe driverClassObj;
	PageLogin loginPage;
	PageHome homePage;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		
		driverClassObj = new DriverSafe();
		driver = driverClassObj.getDriver("local");
		loginPage = new PageLogin(driver);
		homePage = new PageHome(driver);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driverClassObj.closeDriver();
	}
	
	

}
