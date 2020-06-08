package Selenium4;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.qeagle.devtools.webdriver.DevToolsService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.qeagle.devtools.*;

import com.qeagle.devtools.services.ChromeDevToolsService;
import com.qeagle.devtools.utils.FullScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullPageScreenshot_Example {
  
	WebDriver driver=null;
	
  @BeforeMethod
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  //System.setProperty("webdriver.chrome.driver", "chromedriver");
	  driver=new ChromeDriver();
  }
  
  @Test
  public void testFunction() {
	  driver.get("https://www.amazon.in");
	  ChromeDevToolsService devToolsService=DevToolsService.getDevToolsService(driver);
	  
	  FullScreenshot.captureFullPageScreenshot(devToolsService, "./screenshot.png");
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
}
