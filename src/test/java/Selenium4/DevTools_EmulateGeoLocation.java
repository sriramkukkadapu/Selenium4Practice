package Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qeagle.devtools.webdriver.DevToolsService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qeagle.devtools.services.ChromeDevToolsService;

public class DevTools_EmulateGeoLocation {
	ChromeDriver driver;
	
	@BeforeMethod
	public void launch() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/testdata/chromedriver");
		
	}
	
	@Test
	public void chromeExtension() {
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		ChromeDevToolsService devToolsService = DevToolsService.getDevToolsService(driver);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

}
