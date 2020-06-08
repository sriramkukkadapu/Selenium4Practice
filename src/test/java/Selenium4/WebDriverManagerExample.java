package Selenium4;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerExample {
  
	WebDriver driver=null;
	
  @BeforeMethod
  public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  //WebDriverManager.firefoxdriver().setup();
	  //driver=new FirefoxDriver();
	  
	  //WebDriverManager.chromedriver().browserVersion("64.0.3282.140").driverVersion("64.0.3282.140").setup();
	  //driver=new ChromeDriver();
  }
  
  @Test
  public void testFunction() {
	  driver.get("https://www.google.com");
	  System.out.println(driver.getTitle());
	  Capabilities caps=((RemoteWebDriver) driver).getCapabilities();
	  System.out.println(caps.getBrowserName());
	  System.out.println(caps.getVersion());
	  System.out.println(caps.getPlatform());
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }
}
